package com.muhsantech.newsappkotlin

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)