package com.muhsantech.newsappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

//        val songs = listOf("Hell,", "Muhsan", "List", "Life", "Qunation")

        val songsObject = mutableListOf<Song>()
        songsObject.add(Song("Hello","Just the Description"))
        songsObject.add(Song("Hello","Just the Description"))
        songsObject.add(Song("Hello","Just the Description"))
        songsObject.add(Song("Hello","Just the Description"))
        songsObject.add(Song("Hello","Just the Description"))
        songsObject.add(Song("Hello","Just the Description"))
        songsObject.add(Song("Hello","Just the Description"))
        songsObject.add(Song("Hello","Just the Description"))
        songsObject.add(Song("Hello","Just the Description"))
        songsObject.add(Song("Hello","Just the Description"))
        recyclerView.adapter = MyAdapter(songsObject)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
    }
}