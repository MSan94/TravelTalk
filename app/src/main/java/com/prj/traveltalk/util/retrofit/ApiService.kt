package com.prj.traveltalk.util.retrofit

import com.prj.traveltalk.util.model.ModelsEntity
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("ddd")
    suspend fun getEntitys() : Response<ModelsEntity>

}