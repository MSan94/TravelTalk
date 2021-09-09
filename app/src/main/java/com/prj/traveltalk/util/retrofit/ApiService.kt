package com.prj.traveltalk.util.retrofit

import com.prj.traveltalk.util.model.ModelEntity
import com.prj.traveltalk.util.model.ModelsEntity
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/6480000/gyeongnamlodgeinfo/gyeongnamlodgeinfolist?resultType=json")
    fun getEntitys(
        @Query("serviceKey") serviceKey : String,
        @Query("numOfRows") numOfRows : String,
        @Query("pageNo") pageNo : String
    ) : Call<ModelEntity>

}