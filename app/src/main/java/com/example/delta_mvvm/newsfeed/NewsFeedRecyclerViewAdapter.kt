package com.example.delta_mvvm.newsfeed

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.example.delta_mvvm.R
import com.example.delta_mvvm.model.NewsFeedItem

class NewsFeedRecyclerViewAdapter: RecyclerView.Adapter<NewsFeedRecyclerViewAdapter.MyViewHolder>() {

     private var newsFeedItems = emptyList<NewsFeedItem>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.single_item, parent, false))
    }

    override fun getItemCount(): Int {
        return newsFeedItems.size
    }


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

      //  val imageView : ImageView = itemView.findViewById(R.id.imageView)
     //   val favoriteImageView : AppCompatImageView = itemView.findViewById(R.id.favoriteImageView)
        val titleTextView : TextView = itemView.findViewById(R.id.titleTextView)
        val descriptionTextView : TextView = itemView.findViewById(R.id.descriptionTextView)
        val sourceTextView : TextView = itemView.findViewById(R.id.sourceTextView)
        val publishedTextView : TextView = itemView.findViewById(R.id.publishedTextView)
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newsFeedItems[position]
        holder.titleTextView.text = currentItem.title
        holder.descriptionTextView.text = currentItem.description
        holder.sourceTextView.text = currentItem.source
        holder.publishedTextView.text = currentItem.published
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setItems(user: List<NewsFeedItem>){
        this.newsFeedItems = user
        notifyDataSetChanged()
    }



}