package com.eroglu.bookapp.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BookPriceComparison(
    @SerializedName("author")
    val author: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("publisher")
    val publisher: String? = null,
    @SerializedName("result")
    val result: List<Result?>? = null,
    @SerializedName("success")
    val success: Boolean? = null
):Serializable