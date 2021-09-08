package com.prj.traveltalk.presenter

import android.util.Log
import com.prj.traveltalk.contract.LoginContract
import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException

class LoginPresenter : LoginContract.Presenter{
    private var view : LoginContract.View? = null
    private lateinit var mSocket : Socket

    override fun setView(view: LoginContract.View) {
        this.view = view
    }

    override fun checkUser() {
        try {
            mSocket = IO.socket("http://192.168.219.176:3000")
            mSocket.connect()
            Log.d("Connected", "OK")
        }catch (e : URISyntaxException){
            Log.d("Err", e.reason)
        }


    }
}