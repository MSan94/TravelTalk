package com.prj.traveltalk.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

    /** 초기화 **/
    override fun init() {
        binding.btnJoin.setOnClickListener { btnClickEvent(1) }
        binding.btnLogin.setOnClickListener { btnClickEvent(2) }
        binding.btnGuest.setOnClickListener { btnClickEvent(3) }
    }

    /** 버튼 이벤트 **/
    private fun btnClickEvent(type: Int){
        when(type){
            1 -> {
                val intent = Intent(this, JoinActivity::class.java)
                goActivity(intent)
            }
            2 -> {
                checkValid()
            }
            3 -> {
                val intent = Intent(this, MainActivity::class.java)
                goActivity(intent)
            }
        }
    }

    /** 액티비티 전환 **/
    fun goActivity(intent : Intent){
        startActivity(intent)
    }


    /** 계정 유효성 검사 **/
    override fun checkValid() {
        if(binding.editTextId.length() < 5){
            Toast.makeText(this,"아이디를 정확하게 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }
        if(binding.editTextPw.length() < 5){
            Toast.makeText(this,"패스워드를 정확하게 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }
        presenter.checkUser()
    } 

}