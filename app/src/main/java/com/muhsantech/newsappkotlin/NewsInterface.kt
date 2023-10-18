package com.muhsantech.newsappkotlin

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query


// https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=2abbbe26ec9f4124ac523870d936040c
// https://newsapi.org/v2/everything?domains=wsj.com&apiKey=2abbbe26ec9f4124ac523870d936040c
// API KEY : 2abbbe26ec9f4124ac523870d936040c

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "2abbbe26ec9f4124ac523870d936040c"
interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadLines(@Query("country") country :String, @Query("page") page:Int) :Call<News>

    //https://newsapi.org/v2/top-headlines?apiKey=2abbbe26ec9f4124ac523870d936040c&country=in&page=1
}

object NewsService {
    val newsInstance : NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}