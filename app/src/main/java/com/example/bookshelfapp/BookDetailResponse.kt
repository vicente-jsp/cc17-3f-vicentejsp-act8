package com.example.bookshelfapp

data class BookDetailResponse(
    val id: String,
    val volumeInfo: DetailedVolumeInfo
)

data class DetailedVolumeInfo(
    val title: String,
    val authors: List<String>?,
    val description: String?,
    val imageLinks: ImageLinks?,
    val infoLink: String
)

