package com.prj.traveltalk.util.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object RetrofitObject {

    private fun getRetrofit() : Retrofit {
        val baseUrl = "http://apis.data.go.kr/6480000/gyeongnamlodgeinfo/gyeongnamlodgeinfolist/"
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiSerivce() : ApiService{
        return getRetrofit().create(ApiService::class.java)
    }

}