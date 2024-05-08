package com.eroglu.bookapp.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SearchBook(
    @SerializedName("result")
    val result: List<SearchBookResult?>? = null,
    @SerializedName("success")
    val success: Boolean? = null
): Serializable