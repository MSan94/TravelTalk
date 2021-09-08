package com.prj.traveltalk.util.model

data class ModelsEntity(
    val ulsanstayEntId : String, // 고유번호
    val ulsanstayTitle : String, // 이름
    val ulsanstayType : String, // 카테고리
    val ulsanstayNewAddr : String, // 주소
    val ulsanstayTel : String, // 전화번호
    val ulsanstayHP : String, // 홈페이지
    val ulsanstayParking : String, // 주차장 보유 여부
    val ulsanstayRoom : String, // 방 개수
    val ulsanstayXpos : String, // 경도
    val ulsanstayYpos : String, // 위도
    val ulsanstayPrice : String, // 가격
)
