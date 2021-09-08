package com.prj.traveltalk.contract

import com.prj.traveltalk.BasePresenter
import com.prj.traveltalk.BaseView

interface LoginContract {


    interface View : BaseView<Presenter> {
        override fun init()
    }

    interface Presenter : BasePresenter {
        fun setView(view : View)
        fun checkUser()
    }

}