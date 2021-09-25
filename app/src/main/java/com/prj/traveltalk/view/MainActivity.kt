package com.prj.traveltalk.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.prj.traveltalk.R
import com.prj.traveltalk.contract.MainContract
import com.prj.traveltalk.databinding.ActivityMainBinding
import com.prj.traveltalk.presenter.LoginPresenter
import com.prj.traveltalk.presenter.MainPresenter
import com.prj.traveltalk.view.fragment.HomeFragment
import com.prj.traveltalk.view.fragment.InfoFragment
import com.prj.traveltalk.view.fragment.MyFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class MainActivity() : AppCompatActivity() , MainContract.View{
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override lateinit var presenter: MainContract.Presenter
    private val homeFragment = HomeFragment()
    private val infoFragment = InfoFragment()
    private val myFragment = MyFragment()
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    lateinit var bottomNavigationView : BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
        presenter = MainPresenter()
        presenter.setView(this)

        /** 바텀메뉴 선택 이벤트 **/
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    replaceFragment(homeFragment)
                }
                R.id.info -> {
                    replaceFragment(infoFragment)
                }
                R.id.my -> {
                    replaceFragment(myFragment)
                }
            }
            true
        }

    }

    /** 프래그먼트 초기화 **/
    override fun init() {
        bottomNavigationView = binding.bottomNavigationView
        replaceFragment(homeFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    /** 프래그먼트 전환 **/
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.fragmentContainer, fragment)
                commit()
            }
    }

    override fun logoutEvent() {
        auth.signOut()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }


}