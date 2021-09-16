package com.prj.traveltalk.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.prj.traveltalk.R
import com.prj.traveltalk.contract.LoginContract
import com.prj.traveltalk.databinding.ActivityLoginBinding
import com.prj.traveltalk.presenter.LoginPresenter
import com.prj.traveltalk.view.dialog.DetailFragmentDialog


class LoginActivity : AppCompatActivity(), LoginContract.View{
    val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    override lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter = LoginPresenter()
        presenter.setView(this)
        init()

    }

    override fun onResume() {
        super.onResume()
    }

    override fun init() {
        binding.btnJoin.setOnClickListener { btnClickEvent(1) }
        binding.btnLogin.setOnClickListener { btnClickEvent(2) }
        binding.btnGuest.setOnClickListener { btnClickEvent(3) }
    }


    private fun btnClickEvent(type: Int){
        when(type){
            1 -> {
                val intent = Intent(this, JoinActivity::class.java)
                goActivity(intent)
            }
            2 -> {
                presenter.checkUser()
            }
            3 -> {
                val intent = Intent(this, MainActivity::class.java)
                goActivity(intent)
            }
        }
    }

    fun goActivity(intent : Intent){
        startActivity(intent)
    }

}