package com.prj.traveltalk.util.model

data class ImageEntity(
    val ulsanstayEntId : String, // 고유번호
    val ulsanstayFileId	: String, // 사진번호
    val fileOrgNm : String, // 사진원본명
    val fileRelNm : String, // 사진저장명
    val fileUrl	: String // url
)
