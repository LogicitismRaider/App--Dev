package com.example.instagramrepilca

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramrepilca.adapter.ProfilePostsAdapter
import com.example.instagramrepilca.model.Post

class ProfilePostsGridFragment : Fragment() {

    private lateinit var postsRecyclerView: RecyclerView
    private lateinit var profilePostsAdapter: ProfilePostsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_posts_grid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postsRecyclerView = view.findViewById(R.id.posts_recyclerview)

        // Sample data for posts - this could be passed in or fetched from a ViewModel
        val allSamplePosts = listOf(
            Post(
                userImageResId = R.drawable.profilepicdemo,
                username = "sample_user",
                postImageResId = R.drawable.profilepicdemo,
                likesCount = 0,
                caption = "Sample Post"
            ),
            Post(
                userImageResId = R.drawable.profilepicdemo,
                username = "sample_user",
                postImageResId = R.drawable.insta,
                likesCount = 0,
                caption = "Sample Post"
            ),
            Post(
                userImageResId = R.drawable.profilepicdemo,
                username = "sample_user",
                postImageResId = R.drawable.metalogo,
                likesCount = 0,
                caption = "Sample Post"
            ),
            Post(
                userImageResId = R.drawable.profilepicdemo,
                username = "sample_user",
                postImageResId = R.drawable.homepageic,
                likesCount = 0,
                caption = "Sample Post"
            ),
            Post(
                userImageResId = R.drawable.profilepicdemo,
                username = "sample_user",
                postImageResId = R.drawable.plusicon,
                likesCount = 0,
                caption = "Sample Post"
            ),
            Post(
                userImageResId = R.drawable.profilepicdemo,
                username = "sample_user",
                postImageResId = R.drawable.reelsicon,
                likesCount = 0,
                caption = "Sample Post"
            ),
            Post(
                userImageResId = R.drawable.profilepicdemo,
                username = "sample_user",
                postImageResId = R.drawable.searchicon,
                likesCount = 0,
                caption = "Sample Post"
            )
        )

        // Take only the first post if the list is not empty
        val postsToShow = if (allSamplePosts.isNotEmpty()) {
            listOf(allSamplePosts.first())
        } else {
            emptyList()
        }

        profilePostsAdapter = ProfilePostsAdapter(postsToShow)

        // The GridLayoutManager is already set in the XML (app:layoutManager and app:spanCount)
        postsRecyclerView.adapter = profilePostsAdapter
    }

    companion object {
        fun newInstance() = ProfilePostsGridFragment()
    }
}
