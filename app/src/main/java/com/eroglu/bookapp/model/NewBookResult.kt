package com.eroglu.bookapp.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NewBookResult(
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("indirim")
    val indirim: String? = null,
    @SerializedName("fiyat")
    val fiyat: String? = null,
    @SerializedName("yayın")
    val yayin: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("yazar")
    val yazar: String? = null,
): Serializable