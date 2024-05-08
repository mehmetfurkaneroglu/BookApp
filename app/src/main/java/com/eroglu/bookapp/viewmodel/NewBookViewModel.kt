package com.eroglu.bookapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eroglu.bookapp.adapter.BookAdapter
import com.eroglu.bookapp.adapter.ItemClickedListener
import com.eroglu.bookapp.model.NewBookResult
import com.eroglu.bookapp.service.Repository
import com.eroglu.bookapp.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewBookViewModel @Inject constructor(private val repository: Repository): ViewModel() {

//    var isLoading = MutableLiveData(false)
//    var isError = MutableLiveData(false)

    val books = SingleLiveEvent<NewBookResult?>()
    val booksError = MutableLiveData<Boolean>()
    val booksLoading = MutableLiveData<Boolean>()

    init {
        getNewBooks()
    }

    val bookAdapter = BookAdapter().apply {
        itemClickedListener = object : ItemClickedListener {
            override fun onItemClicked(item: NewBookResult) {
                books.postValue(item)
            }
        }
    }

    private fun getNewBooks() {
        viewModelScope.launch {
            booksLoading.value = true
            val result = repository.getNewBook()

            if (result.isSuccessful){
                result.body()?.let {
                    it.result?.let {
                        bookAdapter.bookList = it
                    }
                }
            }
            booksLoading.value = false
        }
    }


}