package com.example.bookshelfapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class BooksViewModel(private val repository: BooksRepository) : ViewModel() {
    fun searchBooks(query: String) = liveData(Dispatchers.IO) {
        val books = repository.searchBooks(query)
        emit(books)
    }
}