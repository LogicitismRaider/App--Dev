package com.example.instagramrepilca.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramrepilca.R
import com.example.instagramrepilca.model.Story
import com.google.android.material.imageview.ShapeableImageView

class StoryAdapter(private val storyList: List<Story>) :
    RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_story_placeholder, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val story = storyList[position]
        holder.storyImage.setImageResource(story.imageResId)
        holder.storyUsername.text = story.username
    }

    override fun getItemCount(): Int {
        return storyList.size
    }

    class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val storyImage: ShapeableImageView = itemView.findViewById(R.id.story_image_placeholder)
        val storyUsername: TextView = itemView.findViewById(R.id.story_username_placeholder)
    }
}
