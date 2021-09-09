package com.prj.traveltalk.presenter

import android.util.Log
import com.prj.traveltalk.contract.LoginContract
import com.prj.traveltalk.contract.MainContract
import com.prj.traveltalk.util.model.ModelEntity
import com.prj.traveltalk.util.model.ModelsEntity
import com.prj.traveltalk.util.retrofit.ApiService
import com.prj.traveltalk.util.retrofit.RetrofitObject.getApiSerivce
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.internal.notify
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import java.net.URLDecoder
import kotlin.coroutines.CoroutineContext

class MainPresenter : MainContract.Presenter, CoroutineScope {
    private var view : MainContract.View? = null
    private lateinit var job: Job
    override val coroutineContext : CoroutineContext
        get() = Dispatchers.Main + job

//    var list : MutableList<ModelEntity>? = mutableListOf();

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
            Log.d(TAG_COROUTINE, "코루틴 실행")
            val service = getApiSerivce()
            service.getEntitys(URLDecoder.decode("aAYj%2B%2FxzbnIufpdEs6pPdTu7H0Tbve6sEljLAwKe5T4JufmD2S5Rom7CezaN4qeI9GTWGkH7mL%2FpjiFj9Bb5aA%3D%3D"),"10","1")
                .enqueue(object : Callback<ModelEntity>{
                    override fun onResponse(
                        call: Call<ModelEntity>,
                        response: Response<ModelEntity>
                    ) {
                        if(response.isSuccessful.not()){
                            Log.d(TAG_RETROFIT_FAIL,"Not Success")
                            return
                        }
                        if(response.isSuccessful){
                            Log.d(TAG_RETROFIT_FAIL,"Success")
                            Log.d(TAG_RETROFIT_FAIL,response.body().toString())

                        }
                        response.body()?.let{
                            Log.d(TAG_RETROFIT_SUCCESS,it.toString())
                            Log.d(TAG_RETROFIT_SUCCESS,response.message())
                            Log.d(TAG_RETROFIT_SUCCESS,response.toString())
                        }
                    }

                    override fun onFailure(call: Call<ModelEntity>, t: Throwable) {
                        Log.d(TAG_RETROFIT_FAIL,"FAIL")
                        Log.d(TAG_RETROFIT_FAIL,call.request().toString())
                    }

                })
        }
    }
    companion object{
        private const val TAG_COROUTINE = "CoroutineTest"
        private const val TAG_RETROFIT_SUCCESS = "Retrofit_S"
        private const val TAG_RETROFIT_FAIL = "Retrofit_F"
    }
}