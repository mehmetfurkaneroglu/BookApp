package com.eroglu.bookapp.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NewBook(
    @SerializedName("result")
    val result: List<NewBookResult?>? = null,
    @SerializedName("success")
    val success: Boolean? = null
): Serializable