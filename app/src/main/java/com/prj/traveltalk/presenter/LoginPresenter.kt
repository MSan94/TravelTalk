package com.prj.traveltalk.presenter

import android.provider.Settings.Global.getString
import android.util.Log
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.prj.traveltalk.R
import com.prj.traveltalk.contract.LoginContract
import com.prj.traveltalk.util.model.UserDto

class LoginPresenter : LoginContract.Presenter{
    private var view : LoginContract.View? = null
    var auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun setView(view: LoginContract.View) {
        this.view = view
    }

    override fun checkUser(model : UserDto) {
        try {
            auth.signInWithEmailAndPassword(model.id, model.pw)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Log.d("ResultLogin","성공")
                        val currentUser = auth.currentUser
                        view?.resultLogin(currentUser,"1")
                    }else{
                        Log.d("ResultLogin","실패")
                        view?.resultLogin(null,"2")
                    }
                }
        }catch (e : Exception){
            Log.d("Err", e.printStackTrace().toString())
        }
    }



}