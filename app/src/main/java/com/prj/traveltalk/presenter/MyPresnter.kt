package com.prj.traveltalk.presenter

import com.prj.traveltalk.contract.MainContract
import com.prj.traveltalk.contract.MyContract

class MyPresnter : MyContract.Presenter {

    private var view : MyContract.View? = null

    override fun setView(view: MyContract.View) {
        this.view = view
    }
}