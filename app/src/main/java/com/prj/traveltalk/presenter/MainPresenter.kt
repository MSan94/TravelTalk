package com.prj.traveltalk.presenter

import android.util.Log
import com.prj.traveltalk.contract.LoginContract
import com.prj.traveltalk.contract.MainContract
import com.prj.traveltalk.util.retrofit.ApiService
import com.prj.traveltalk.util.retrofit.RetrofitObject.getApiSerivce
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainPresenter : MainContract.Presenter, CoroutineScope {
    private var view : MainContract.View? = null

    private lateinit var job: Job
    override val coroutineContext : CoroutineContext
        get() = Dispatchers.Main + job


    override fun setView(view: MainContract.View) {
        this.view = view
    }

    override fun setJob(){
        job = Job()
    }


    override fun cancelJob(){
        job.cancel()
    }

    override fun getData() {
        launch {
            Log.d("Test", "코루틴 실행")
            val response = getApiSerivce().getEntitys()
        }
    }
}