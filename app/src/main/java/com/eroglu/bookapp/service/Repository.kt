package com.eroglu.bookapp.service

import com.eroglu.bookapp.model.NewBook
import retrofit2.Response

class Repository(private val api: BookAPI) {

    suspend fun getNewBook(): Response<NewBook> {
        return api.getNewBook()
    }

}