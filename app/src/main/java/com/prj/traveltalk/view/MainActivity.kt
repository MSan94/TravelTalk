package com.prj.traveltalk.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
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
    lateinit var bottomNavigationView : BottomNavigationView
//    = findViewById<BottomNavigationView>(R.id.bottomNavigationView)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
        presenter = MainPresenter()
        presenter.setView(this)


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
    override fun init() {
        bottomNavigationView = binding.bottomNavigationView
        replaceFragment(homeFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun replaceFragment(fragment: Fragment) {
        // 트랜잭션 작업 설정
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.fragmentContainer, fragment)
                commit()
            }
    }

}