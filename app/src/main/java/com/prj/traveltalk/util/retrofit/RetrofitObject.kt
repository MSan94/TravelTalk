package com.prj.traveltalk.util.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object RetrofitObject {


    private fun getRetrofit() : Retrofit {
        val gson : Gson = GsonBuilder()
            .setLenient()
            .create()
        val baseUrl = "http://apis.data.go.kr/"
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun getApiSerivce() : ApiService{
        return getRetrofit().create(ApiService::class.java)
    }

}