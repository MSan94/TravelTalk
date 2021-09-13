package com.prj.traveltalk.contract

import com.prj.traveltalk.BasePresenter
import com.prj.traveltalk.BaseView
import com.prj.traveltalk.util.model.ModelItem

interface HomeContract {

    interface View : BaseView<Presenter> {
        fun initRecyclerView()
        fun getModelData()

        fun getData()

    }

    interface Presenter : BasePresenter{
        fun setView(view : HomeContract.View)
        fun getData()
        fun setJob()
        fun cancelJob()

    }

}