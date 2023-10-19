package com.muhsantech.newsappkotlin

import android.graphics.Color
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.icu.lang.UCharacter.VerticalOrientation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jackandphantom.carouselrecyclerview.CarouselLayoutManager
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : CarouselRecyclerview
    private lateinit var container : ConstraintLayout
    lateinit var adapter : NewsAdapter
    var articles = mutableListOf<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.newsList)
        container = findViewById(R.id.container)

        adapter = NewsAdapter(this@MainActivity, articles)
        recyclerView.adapter = adapter
        recyclerView.set3DItem(true)
        recyclerView.setInfinite(true)
        recyclerView.setAlpha(true)
        recyclerView.setFlat(true)
        recyclerView.setIsScrollingEnabled(true)
        recyclerView.setOrientation(RecyclerView.SCROLL_AXIS_HORIZONTAL)

        val carouselLayoutManager = recyclerView.getCarouselLayoutManager()
        //val currentlyCenterPosition = recyclerView.getSelectedPosition()

//        recyclerView.setItemSelectListener(object : CarouselLayoutManager.OnSelected {
//            override fun onItemSelected(position: Int) {
//                //Cente item
//               if (currentlyCenterPosition != position){
//                   container.setBackgroundColor(Color.parseColor(ColorPicker.getColor()))
//               }
//
//            }
//        })

        recyclerView.layoutManager = carouselLayoutManager

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