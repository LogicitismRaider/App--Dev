package com.example.instagramrepilca.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramrepilca.R
import com.example.instagramrepilca.model.Post
import com.google.android.material.imageview.ShapeableImageView

class PostAdapter(private val postList: List<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post_placeholder, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.userImage.setImageResource(post.userImageResId)
        holder.username.text = post.username
        holder.postImage.setImageResource(post.postImageResId)
        holder.likesCount.text = "${post.likesCount} likes"
        // For the caption, we can combine username and the caption text
        holder.caption.text = "${post.username} ${post.caption}" 
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userImage: ShapeableImageView = itemView.findViewById(R.id.post_user_image_placeholder)
        val username: TextView = itemView.findViewById(R.id.post_username_placeholder)
        val postImage: ImageView = itemView.findViewById(R.id.post_image_placeholder)
        // Action buttons (like, comment, send, bookmark) can be accessed here if needed for listeners
        val likesCount: TextView = itemView.findViewById(R.id.post_likes_count_placeholder)
        val caption: TextView = itemView.findViewById(R.id.post_caption_placeholder)
        // val viewComments: TextView = itemView.findViewById(R.id.post_view_comments_placeholder)
    }
}
