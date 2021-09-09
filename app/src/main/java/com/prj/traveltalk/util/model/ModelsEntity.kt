package com.prj.traveltalk.util.model

import com.google.gson.annotations.SerializedName

data class ModelsEntity(
    @SerializedName("item") val model: List<ModelEntity>
)
