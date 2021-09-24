package com.prj.traveltalk.contract

import com.google.firebase.auth.FirebaseUser
import com.prj.traveltalk.BasePresenter
import com.prj.traveltalk.BaseView
import com.prj.traveltalk.util.model.UserDto

interface LoginContract {


    interface View : BaseView<Presenter> {
        override fun init()
        fun checkValid()
        fun resultLogin(currentUser : FirebaseUser? = null)
    }

    interface Presenter : BasePresenter {
        fun setView(view : View)
        fun checkUser(model : UserDto)
    }

}