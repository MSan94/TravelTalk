package com.prj.traveltalk.presenter

import android.util.Log
import com.prj.traveltalk.contract.MainContract
import com.prj.traveltalk.util.PropertiesData
import com.prj.traveltalk.util.model.ModelItem
import com.prj.traveltalk.util.model.Motel
import com.prj.traveltalk.util.model.modelGyeongnamlodgeinfolist
import com.prj.traveltalk.util.retrofit.RetrofitObject.apiService
import kotlinx.coroutines.*
import java.net.URLDecoder
import kotlin.coroutines.CoroutineContext

class MainPresenter : MainContract.Presenter{
    private var view : MainContract.View? = null

    override fun setView(view: MainContract.View) {
        this.view = view
    }


}