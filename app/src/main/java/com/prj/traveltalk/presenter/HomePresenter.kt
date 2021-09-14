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

    lateinit var modelList : MutableList<ModelItem>
    private var view : HomeContract.View? = null


    override fun setView(view: HomeContract.View) {
        this.view = view
    }

    override fun setJob(){
        job = Job()
    }


    override fun cancelJob(){
        job.cancel()
    }


    /** 레트로핏 정보 파싱 **/
    override fun getData() = runBlocking {
        Log.d("coroutineTest", "시작")
        val job = launch() {
            Log.d(TAG_COROUTINE, "코루틴 실행")
//
            Log.d("coroutineTest", "중간1")
            val responseService = RetrofitObject.apiService.getEntitys(
                URLDecoder.decode(PropertiesData.SERVICE_KEY),"10","1")
            Log.d("coroutineTest", "중간2")
                modelList = responseService.gyeongnamlodgeinfolist.modelItem
            Log.d("coroutineTest", "중간3")
        }
        job.join()
        Log.d("coroutineTest", "끝")
        job.cancel()
    }


    /** 리스트 반환 **/
    override fun returnList() : MutableList<ModelItem> {
        return modelList
    }

    companion object{
        private const val TAG_COROUTINE = "CoroutineTest"
        private const val TAG_RETROFIT_SUCCESS = "Retrofit_S"
        private const val TAG_RETROFIT_FAIL = "Retrofit_F"
    }
}