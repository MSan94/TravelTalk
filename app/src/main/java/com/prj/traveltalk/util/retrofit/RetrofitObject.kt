package com.prj.traveltalk.util.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.prj.traveltalk.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

object RetrofitObject {
    private val baseUrl = "http://apis.data.go.kr/"

    private fun createOkHttpClient() : OkHttpClient{
       val interceptor = HttpLoggingInterceptor()

       if(BuildConfig.DEBUG){
           interceptor.level = HttpLoggingInterceptor.Level.BODY
       }else{
           interceptor.level = HttpLoggingInterceptor.Level.NONE
       }

       return OkHttpClient.Builder()
           .connectTimeout(20, TimeUnit.SECONDS)
           .readTimeout(20, TimeUnit.SECONDS)
           .writeTimeout(20, TimeUnit.SECONDS)
           .addNetworkInterceptor(interceptor)
           .build()
    }

    private val retrofitService = Retrofit.Builder()
       .baseUrl(baseUrl)
       .addConverterFactory(GsonConverterFactory.create())
       .client(createOkHttpClient())
       .build()

    val apiService : ApiService = retrofitService.create(ApiService::class.java)
}