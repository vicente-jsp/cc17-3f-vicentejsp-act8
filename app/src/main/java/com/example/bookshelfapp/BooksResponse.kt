package com.example.bookshelfapp

data class BooksResponse(
    val items: List<BookItem>
)

data class BookItem(
    val id: String,
    val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    val title: String,
    val imageLinks: ImageLinks?,
    val infoLink: String
)

