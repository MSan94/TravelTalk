package com.prj.traveltalk.contract

import android.app.Presentation
import com.prj.traveltalk.BasePresenter
import com.prj.traveltalk.BaseView

interface MainContract {

    interface View : BaseView<Presenter>{

    }

    interface Presenter : BasePresenter{
        fun setView(view : MainContract.View)
        fun setJob()
        fun cancelJob()
        fun getData()
    }

}