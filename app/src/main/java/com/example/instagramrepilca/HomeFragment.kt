package com.example.instagramrepilca

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramrepilca.adapter.PostAdapter // Added import
import com.example.instagramrepilca.adapter.StoryAdapter
import com.example.instagramrepilca.model.Post // Added import
import com.example.instagramrepilca.model.Story

class HomeFragment : Fragment() {

    private lateinit var storiesRecyclerView: RecyclerView
    private lateinit var storyAdapter: StoryAdapter
    private lateinit var sampleStories: List<Story>

    // Added for Post Feed
    private lateinit var feedRecyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private lateinit var samplePosts: List<Post>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize stories RecyclerView
        storiesRecyclerView = view.findViewById(R.id.stories_recycler_view)
        storiesRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Create sample data for stories
        sampleStories = listOf(
            Story(R.drawable.profilepicdemo, "Your Story"),
            Story(R.drawable.profilepicdemo, "user1"),
            Story(R.drawable.profilepicdemo, "user2"),
            Story(R.drawable.profilepicdemo, "another_user"),
            Story(R.drawable.profilepicdemo, "friend_123"),
            Story(R.drawable.profilepicdemo, "insta_user_5"),
            Story(R.drawable.profilepicdemo, "developer")
        )

        // Initialize and set story adapter
        storyAdapter = StoryAdapter(sampleStories)
        storiesRecyclerView.adapter = storyAdapter

        // Initialize feed RecyclerView
        feedRecyclerView = view.findViewById(R.id.feed_recycler_view)
        feedRecyclerView.layoutManager = LinearLayoutManager(context) // Default is vertical

        // Create sample data for posts
        samplePosts = listOf(
            Post(R.drawable.profilepicdemo, "user1", R.drawable.profilepicdemo, 100, "This is the first post! #sample #insta"),
            Post(R.drawable.profilepicdemo, "user2", R.drawable.insta, 250, "Loving this new app. Great content here."),
            Post(R.drawable.profilepicdemo, "developer", R.drawable.metalogo, 50, "Working on this cool project."),
            Post(R.drawable.profilepicdemo, "another_user", R.drawable.profilepicdemo, 123, "Just a random post for the feed.")
        )

        // Initialize and set post adapter
        postAdapter = PostAdapter(samplePosts)
        feedRecyclerView.adapter = postAdapter
    }
}
