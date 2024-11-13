package com.example.bookshelfapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://www.googleapis.com/books/v1/"

interface BooksApiService {

    @GET("volumes")
    suspend fun searchBooks(@Query("q") query: String): BooksResponse

    companion object {
        fun create(): BooksApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(BooksApiService::class.java)
        }
    }
}