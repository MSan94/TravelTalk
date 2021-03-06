package com.prj.traveltalk.contract

import com.google.firebase.auth.FirebaseUser
import com.prj.traveltalk.BasePresenter
import com.prj.traveltalk.BaseView
import com.prj.traveltalk.util.model.ModelItem

interface MyContract {

    interface View : BaseView<Presenter> {
        override fun init()
        fun logoutEvent()
        fun userCheck()
        fun resultLogin(currentUser: FirebaseUser?)
    }

    interface Presenter : BasePresenter {
        fun setView(view : View)
    }

}