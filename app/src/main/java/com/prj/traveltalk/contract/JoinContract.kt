package com.prj.traveltalk.contract

import com.prj.traveltalk.BasePresenter
import com.prj.traveltalk.BaseView
import com.prj.traveltalk.util.model.ModelItem
import com.prj.traveltalk.util.model.UserDto

interface JoinContract {

    interface View : BaseView<Presenter> {
        override fun init()

        fun sendUserData(model : UserDto) // 가입정보 전송
        fun resultSignIn(result : Boolean)
    }

    interface Presenter : BasePresenter {
        fun setView(view : View)

        fun singIn(model : UserDto)
    }

}