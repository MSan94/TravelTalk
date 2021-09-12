package com.prj.traveltalk.presenter

import android.util.Log
import com.prj.traveltalk.contract.MainContract
import com.prj.traveltalk.util.model.ModelItem
import com.prj.traveltalk.util.model.Motel
import com.prj.traveltalk.util.model.modelGyeongnamlodgeinfolist
import com.prj.traveltalk.util.retrofit.RetrofitObject.apiService
import kotlinx.coroutines.*
import java.net.URLDecoder
import kotlin.coroutines.CoroutineContext

class MainPresenter : MainContract.Presenter, CoroutineScope {
    private var view : MainContract.View? = null
    private lateinit var job: Job
    override val coroutineContext : CoroutineContext
        get() = Dispatchers.Main + job

    private var _motelList : MutableList<ModelItem>? = null

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
        launch(Dispatchers.IO) {
            Log.d(TAG_COROUTINE, "코루틴 실행")
//
            val responseService = apiService.getEntitys(URLDecoder.decode("aAYj%2B%2FxzbnIufpdEs6pPdTu7H0Tbve6sEljLAwKe5T4JufmD2S5Rom7CezaN4qeI9GTWGkH7mL%2FpjiFj9Bb5aA%3D%3D"),"10","2")
            withContext(Dispatchers.Main){
                _motelList = responseService.gyeongnamlodgeinfolist.modelItem
                Log.d(TAG_COROUTINE, "사이즈 : ${_motelList?.size}")
                Log.d("ModelTest", _motelList?.size.toString())
                for(i in _motelList?.indices!!){
                    Log.d("TestData", _motelList!![i].toString())
                }
            }
        }
    }
    companion object{
        private const val TAG_COROUTINE = "CoroutineTest"
        private const val TAG_RETROFIT_SUCCESS = "Retrofit_S"
        private const val TAG_RETROFIT_FAIL = "Retrofit_F"
    }
}