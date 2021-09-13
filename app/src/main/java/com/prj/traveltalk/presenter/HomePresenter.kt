package com.prj.traveltalk.presenter

import android.content.Context
import android.util.Log
import com.prj.traveltalk.R
import com.prj.traveltalk.contract.HomeContract
import com.prj.traveltalk.util.PropertiesData
import com.prj.traveltalk.util.adapter.ModelAdapter
import com.prj.traveltalk.util.model.ModelItem
import com.prj.traveltalk.util.retrofit.RetrofitObject
import kotlinx.coroutines.*
import okhttp3.internal.wait
import java.net.URLDecoder
import kotlin.coroutines.CoroutineContext

class HomePresenter : HomeContract.Presenter , CoroutineScope {

    private lateinit var job: Job
    override val coroutineContext : CoroutineContext
        get() = Dispatchers.Main + job

//    private var _motelList : List<ModelItem>? = null
    lateinit var modelList : MutableList<ModelItem>
    private var view : HomeContract.View? = null
    lateinit var modelAdapter : ModelAdapter


    override fun setView(view: HomeContract.View) {
        this.view = view
    }

    override fun setJob(){
        job = Job()
    }


    override fun cancelJob(){
        job.cancel()
    }

    override fun getData(){

        val job = launch() {
            Log.d(TAG_COROUTINE, "코루틴 실행")
//
            val responseService = RetrofitObject.apiService.getEntitys(
                URLDecoder.decode(PropertiesData.SERVICE_KEY),"10","1")
                modelList = responseService.gyeongnamlodgeinfolist.modelItem
                Log.d("TestInit", "${modelList.size}")
                Log.d(TAG_COROUTINE, "사이즈1 : ${modelList?.size}")
                Log.d("ModelTest", modelList?.size.toString())
                for(i in modelList?.indices!!){
                    Log.d("TestData", modelList!![i].toString())
                }
        }

    }

//    override fun sendData() : MutableList<ModelItem>{
//        return modelList
//    }


    companion object{
        private const val TAG_COROUTINE = "CoroutineTest"
        private const val TAG_RETROFIT_SUCCESS = "Retrofit_S"
        private const val TAG_RETROFIT_FAIL = "Retrofit_F"
    }
}