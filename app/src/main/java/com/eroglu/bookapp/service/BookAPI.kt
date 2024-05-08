package com.eroglu.bookapp.service

import com.eroglu.bookapp.model.NewBook
import com.eroglu.bookapp.model.SearchBook
import com.eroglu.bookapp.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BookAPI {

    @Headers(
        "content-type: application/json",
        "authorization: apikey $API_KEY"
    )
    @GET("newBook")
    suspend fun getNewBook(
    ): Response<NewBook>

    @Headers(
        "content-type: application/json",
        "authorization: apikey $API_KEY"
    )
    @GET("search/")
    suspend fun getSearchBook(
        @Query("data.query") data: String
    ): Response<SearchBook>

    @Headers(
        "content-type: application/json",
        "authorization: apikey $API_KEY"
    )
    @GET("bookPriceComparison")
    suspend fun getIsbnBook(
        @Query("isbn") isbn: String
    ): Response<SearchBook>


}