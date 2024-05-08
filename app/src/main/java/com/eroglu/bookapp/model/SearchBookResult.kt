package com.eroglu.bookapp.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SearchBookResult(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("img")
    val img: String? = null,
    @SerializedName("oldprice")
    val oldprice: String? = null,
    @SerializedName("price")
    val price: String? = null,
    @SerializedName("author")
    val author: String? = null
): Serializable