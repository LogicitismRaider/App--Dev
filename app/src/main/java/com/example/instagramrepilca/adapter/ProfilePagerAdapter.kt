package com.example.instagramrepilca.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity // Changed from FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.instagramrepilca.ProfilePostsGridFragment
import com.example.instagramrepilca.ProfileReelsFragment
import com.example.instagramrepilca.ProfileTaggedFragment

private const val NUM_TABS = 3

class ProfilePagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ProfilePostsGridFragment.newInstance()
            1 -> ProfileReelsFragment.newInstance()
            2 -> ProfileTaggedFragment.newInstance()
            else -> throw IllegalStateException("Invalid position $position")
        }
    }
}
