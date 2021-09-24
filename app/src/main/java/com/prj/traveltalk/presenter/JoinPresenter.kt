package com.prj.traveltalk.presenter

import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.prj.traveltalk.contract.JoinContract
import com.prj.traveltalk.util.model.UserDto
import kotlinx.coroutines.*
import okhttp3.internal.wait

class JoinPresenter : JoinContract.Presenter {
    private var view: JoinContract.View? = null
    var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private var result = false


    override fun setView(view: JoinContract.View) {
        this.view = view
        Log.d("TestScope", "실행1");
    }

    /** 회원가입 진행 **/
    override fun singIn(model: UserDto) {
        jobSignIn(model)
    }

    fun jobSignIn(model: UserDto) {
        Log.d("TestScope", "실행2");
        auth.createUserWithEmailAndPassword(model.id.toString(), model.pw.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("SignInEvent", "회원가입 이벤트 발생 _ 성공 : ${model.id}")
                    view?.resultSignIn("1")
                } else {
                    Log.d("SignInEvent", "회원가입 이벤트 발생 _ 실패 _ 아이디 중복 : ${model.id}")
                    view?.resultSignIn("2")
                }
            }
            .addOnFailureListener {
                Log.d("SignInEvent", "회원가입 이벤트 발생 _ 실패 : ${model.id}")
                view?.resultSignIn("3")
            }
    }


}