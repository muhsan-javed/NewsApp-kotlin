package com.muhsantech.newsappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    lateinit var adapter : NewsAdapter
    var articles = mutableListOf<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.newsList)

        adapter = NewsAdapter(this@MainActivity, articles)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)



//        val songs = listOf("Hell,", "Muhsan", "List", "Life", "Qunation")
        /*val songsObject = mutableListOf<Song>()
        songsObject.add(Song("Hello","Just the Description"))
        songsObject.add(Song("Hello","Just the Description"))
        songsObject.add(Song("Hello","Just the Description"))
        songsObject.add(Song("Hello","Just the Description"))
        songsObject.add(Song("Hello","Just the Description"))
        songsObject.add(Song("Hello","Just the Description"))
        songsObject.add(Song("Hello","Just the Description"))
        songsObject.add(Song("Hello","Just the Description"))
        songsObject.add(Song("Hello","Just the Description"))
        songsObject.add(Song("Hello","Just the Description"))*/
//        recyclerView.adapter = MyAdapter(songsObject)
//        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        getNews()
    }

    private fun getNews() {
        val news = NewsService.newsInstance.getHeadLines("in",1)
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null){
                    //Log.d("MUHSANTECH", news.toString())
                    articles.addAll(news.articles)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("MUHSANTECH","Error in Fetching NEws")
            }

        })
    }
}