package com.example.delta_mvvm


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.delta_mvvm.newsfeed.NewsFeedRecyclerViewAdapter
import com.example.delta_mvvm.newsfeed.NewsFeedViewModel

private lateinit var mUserViewModel: NewsFeedViewModel
private lateinit var recyclerview: RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview = findViewById(R.id.recyclerView)

        val adapter = NewsFeedRecyclerViewAdapter()
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(applicationContext)

        mUserViewModel = ViewModelProvider(this).get(NewsFeedViewModel::class.java)

        mUserViewModel.fetchNewsFeed("news_feed") // here we initialize an instance of Firebase here


        mUserViewModel.ui_object.observe(this, Observer {
            adapter.setItems(it)

            Toast.makeText(applicationContext, "item.. ${mUserViewModel.numnpy}", Toast.LENGTH_SHORT).show()
        })




    }
}