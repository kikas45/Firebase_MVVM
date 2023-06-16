package com.example.delta_mvvm.newsfeed


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.delta_mvvm.model.NewsFeedItem
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class NewsFeedRepository {
    val database = FirebaseDatabase.getInstance();

    val getAllItems = MutableLiveData<List<NewsFeedItem>>()

    fun packAllMyNews(news_feed: String) {

        database.getReference(news_feed).addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val myNewsList: List<NewsFeedItem> = snapshot.children.map {
                    it.getValue(NewsFeedItem::class.java)!!
                }
                // fecth data into Mutable list
                getAllItems.value = myNewsList
            }

            override fun onCancelled(error: DatabaseError) {
                // Nothing to do
            }
        })
    }


    // pass data into a live data class so we can observed it
    val myNewsFeedLiveDat: LiveData<List<NewsFeedItem>> = getAllItems

    fun getItems(): LiveData<List<NewsFeedItem>> {
        return myNewsFeedLiveDat
    }

}













//package com.dmp.deltanews.newsfeed
//
//import androidx.lifecycle.MutableLiveData
//import com.dmp.deltanews.model.NewsFeedItem
//import com.google.firebase.database.DataSnapshot
//import com.google.firebase.database.DatabaseError
//import com.google.firebase.database.ValueEventListener
//import com.google.firebase.database.ktx.database
//import com.google.firebase.ktx.Firebase
//
//class NewsFeedRepository {
//
//    private val database = Firebase.database
//    private val newsFeedReference = database.getReference("news_feed")
//
//    fun fetchNewsFeed(liveData: MutableLiveData<List<NewsFeedItem>>) {
//        newsFeedReference
//            .orderByChild("_rank")
//            .addValueEventListener(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    val newsFeedItems: List<NewsFeedItem> = snapshot.children.map { dataSnapshot ->
//                        dataSnapshot.getValue(NewsFeedItem::class.java)!!.copy(id = dataSnapshot.key!!)
//                    }
//
//                    liveData.postValue(newsFeedItems)
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                    // Nothing to do
//                }
//            })
//    }
//
//    fun updateFavoriteStatus(id: String, isFavorite: Boolean) {
//        newsFeedReference.child(id).child("favorite").setValue(isFavorite)
//    }
//}
