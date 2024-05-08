package com.eroglu.bookapp.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Result(
    @SerializedName("price")
    val price: String? = null,
    @SerializedName("website")
    val website: String? = null
): Serializable