package com.example.instagramrepilca.adapter // Or your appropriate package

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramrepilca.R
import com.example.instagramrepilca.model.Post

class ProfilePostsAdapter(private val posts: List<Post>) :
    RecyclerView.Adapter<ProfilePostsAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post_grid, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val postImage: ImageView = itemView.findViewById(R.id.post_image)

        fun bind(post: Post) {
            // TODO: Load image using a library like Glide or Picasso if images are from URLs
            // For now, setting image resource directly if it's a local drawable
            postImage.setImageResource(post.postImageResId)
        }
    }
}
