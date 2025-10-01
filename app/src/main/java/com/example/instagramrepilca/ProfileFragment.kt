package com.example.instagramrepilca

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.instagramrepilca.adapter.ProfilePagerAdapter
import com.example.instagramrepilca.adapter.StoryHighlightsAdapter
import com.example.instagramrepilca.model.StoryHighlight
import com.google.android.material.appbar.AppBarLayout // Added import
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var profilePagerAdapter: ProfilePagerAdapter

    private lateinit var highlightsRecyclerView: RecyclerView
    private lateinit var storyHighlightsAdapter: StoryHighlightsAdapter
    private lateinit var profileToolbar: MaterialToolbar // Renamed for clarity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true) 
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Hide MainActivity's toolbar
        val mainActivityToolbar = requireActivity().findViewById<AppBarLayout>(R.id.main_app_bar_layout)
        mainActivityToolbar?.visibility = View.GONE

        // Profile Toolbar setup
        profileToolbar = view.findViewById(R.id.profile_toolbar) // ID Changed
        (requireActivity() as AppCompatActivity).setSupportActionBar(profileToolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.profile_username_default)

        // ViewPager and TabLayout setup
        viewPager = view.findViewById(R.id.view_pager)
        tabLayout = view.findViewById(R.id.tab_layout)
        profilePagerAdapter = ProfilePagerAdapter(requireActivity())
        viewPager.adapter = profilePagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.setIcon(R.drawable.pixels)
                1 -> tab.setIcon(R.drawable.reelsicon)
                2 -> tab.setIcon(R.drawable.person)
            }
        }.attach()

        // Story Highlights RecyclerView setup
        highlightsRecyclerView = view.findViewById(R.id.highlights_recyclerview)
        highlightsRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val addHighlightItem = listOf(
            StoryHighlight(R.drawable.plus2, "Highlights") // Changed to plus2
        )

        storyHighlightsAdapter = StoryHighlightsAdapter(addHighlightItem)
        highlightsRecyclerView.adapter = storyHighlightsAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Show MainActivity's toolbar when ProfileFragment is destroyed
        val mainActivityToolbar = requireActivity().findViewById<AppBarLayout>(R.id.main_app_bar_layout)
        mainActivityToolbar?.visibility = View.VISIBLE
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.profile_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(context, "Settings clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
