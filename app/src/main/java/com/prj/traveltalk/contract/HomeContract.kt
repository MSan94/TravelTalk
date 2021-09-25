package com.prj.traveltalk.contract

import com.prj.traveltalk.BasePresenter
import com.prj.traveltalk.BaseView
import com.prj.traveltalk.util.model.ModelItem

interface HomeContract {

    interface View : BaseView<Presenter> {
        override fun init()
        fun initRecyclerView()
        fun getData(search : String?)
    }

    interface Presenter : BasePresenter{
        fun setView(view : HomeContract.View)
        fun getData() // 레트로핏 데이터 파싱
        fun setJob() // 잡 설정
        fun cancelJob()  // 잡 취소
        fun returnList() : MutableList<ModelItem> // 리스트 반환

    }

}