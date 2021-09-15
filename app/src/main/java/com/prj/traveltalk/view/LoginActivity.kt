package com.prj.traveltalk.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.prj.traveltalk.contract.LoginContract
import com.prj.traveltalk.databinding.ActivityLoginBinding
import com.prj.traveltalk.presenter.LoginPresenter
import com.prj.traveltalk.util.adapter.MapKey
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
//        val intent : Intent = Intent(this, MapKey::class.java)
//        startActivity(intent)
        DetailFragmentDialog().show(
            supportFragmentManager, "SampleDialog"
        )
    }

    override fun init() {
        binding.btnJoin.setOnClickListener { btnClickEvent(1) }
        binding.btnLogin.setOnClickListener { btnClickEvent(2) }
        binding.btnGuest.setOnClickListener { btnClickEvent(3) }
    }


    fun btnClickEvent(type : Int){
        when(type){
            2 -> {
                presenter.checkUser()
            }
            3 ->{
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

}