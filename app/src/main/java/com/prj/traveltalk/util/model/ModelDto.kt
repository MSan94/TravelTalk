package com.prj.traveltalk.util.model

import com.google.gson.annotations.SerializedName

data class ModelDto(
    val data_title : String, // 상호명
    val category_name1 : String, // 숙박유형
    val category_name3 : String, // 시군구명
    val data_content : String, // 내용
    val user_address : String, // 주소
    val telno : String, // 연락처
    val lattitude : String, // 위도
    val logitude : String, // 경도
    val roominfo : String, // 객실정보
    val parkinginfo : String, // 주차정보
    val trafficinfo : String, // 교통편
    val user_homepage : String, // 홈페이지 주소
    val fileurl1 : String, // 파일1
    val fileurl2 : String, // 파일2
    val fileurl3 : String, // 파일3
    val fileurl4 : String, // 파일4
    val fileurl5 : String, // 파일5

)