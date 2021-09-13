package com.prj.traveltalk.util.retrofit

import com.prj.traveltalk.util.model.Motel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/6480000/gyeongnamlodgeinfo/gyeongnamlodgeinfolist?resultType=json")
    suspend fun getEntitys(
        @Query("serviceKey") serviceKey : String,
        @Query("numOfRows") numOfRows : String,
        @Query("pageNo") pageNo : String
    ) : Motel

}