package com.prj.traveltalk.util.model

import com.google.gson.annotations.SerializedName

data class Motel(val gyeongnamlodgeinfolist : modelGyeongnamlodgeinfolist)

data class modelGyeongnamlodgeinfolist(
    @SerializedName("item")
    val modelItem : MutableList<ModelItem>?,
    val numOfRows : Int,
    val pageNo : Int,
    val totalCount : Int
)

data class ModelItem(
    @SerializedName("data_title") val data_title : String, // 상호명
    @SerializedName("category_name1") val category_name1 : String, // 숙박유형
    @SerializedName("category_name3") val category_name3 : String, // 시군구명
    @SerializedName("data_content") val data_content : String, // 내용
    @SerializedName("user_address") val user_address : String, // 주소
    @SerializedName("telno") val telno : String, // 연락처
    @SerializedName("lattitude") val lattitude : String, // 위도
    @SerializedName("logitude") val logitude : String, // 경도
    @SerializedName("roominfo") val roominfo : String, // 객실정보
    @SerializedName("parkinginfo") val parkinginfo : String, // 주차정보
    @SerializedName("trafficinfo") val trafficinfo : String, // 교통편
    @SerializedName("user_homepage") val user_homepage : String, // 홈페이지 주소
    @SerializedName("fileurl1") val fileurl1 : String, // 파일1
    @SerializedName("fileurl2") val fileurl2 : String, // 파일2
    @SerializedName("fileurl3") val fileurl3 : String, // 파일3
    @SerializedName("fileurl4") val fileurl4 : String, // 파일4
    @SerializedName("fileurl5") val fileurl5 : String, // 파일5
)
