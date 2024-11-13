package com.example.bookshelfapp

class BooksRepository(private val apiService: BooksApiService) {
    suspend fun searchBooks(query: String): List<Book> {
        val response = apiService.searchBooks(query)
        return response.items.map { bookItem ->
            Book(
                id = bookItem.id,
                title = bookItem.volumeInfo.title,
                thumbnail = bookItem.volumeInfo.imageLinks?.thumbnail?.replace("http", "https") ?: "",
                infoLink = bookItem.volumeInfo.infoLink
            )
        }
    }
}