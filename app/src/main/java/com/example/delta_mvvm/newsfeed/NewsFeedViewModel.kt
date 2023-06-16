package com.example.delta_mvvm.newsfeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.delta_mvvm.model.NewsFeedItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NewsFeedViewModel : ViewModel() {

    private val repository = NewsFeedRepository()

    val numnpy = MutableLiveData<Int>()

    fun fetchNewsFeed(news_feed: String): LiveData<Int> {
        repository.packAllMyNews(news_feed)
        return numnpy
    }


    val ui_object = repository.getItems()

}



//package com.dmp.deltanews.newsfeed
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.dmp.deltanews.model.NewsFeedItem
//
//class NewsFeedViewModel : ViewModel() {
//
//    private val repository = NewsFeedRepository()
//
//    private val _newsFeedLiveData = MutableLiveData<List<NewsFeedItem>>()
//    val newsFeedLiveData: LiveData<List<NewsFeedItem>> = _newsFeedLiveData
//
//    fun fetchNewsFeed() {
//        repository.fetchNewsFeed(_newsFeedLiveData)
//    }
//
//    fun updateFavoriteStatus(id: String, isFavorite: Boolean) {
//        repository.updateFavoriteStatus(id, isFavorite)
//    }
//}