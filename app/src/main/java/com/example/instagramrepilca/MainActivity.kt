package com.example.instagramrepilca

import android.os.Bundle
import android.view.View // Added import
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.AppBarLayout // Added import
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarLayout: AppBarLayout // Added this line

    override fun onCreate(savedInstanceState: Bundle?) {
        // Show splash screen before loading UI
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        appBarLayout = findViewById(R.id.main_app_bar_layout) // Initialize appBarLayout

        // Apply edge-to-edge insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Load HomeFragment by default and ensure AppBar is visible
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
            bottomNavigationView.selectedItemId = R.id.nav_home
            appBarLayout.visibility = View.VISIBLE // Ensure visible on initial load
        }

        bottomNavigationView.setOnItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            // Default to showing the AppBarLayout
            appBarLayout.visibility = View.VISIBLE

            when (item.itemId) {
                R.id.nav_home -> selectedFragment = HomeFragment()
                R.id.nav_search -> {
                    selectedFragment = SearchFragment()
                    appBarLayout.visibility = View.GONE // Hide for SearchFragment
                }
                R.id.nav_add_post -> {
                    appBarLayout.visibility = View.GONE // Hide for Add Post action
                    Toast.makeText(this, "Add Post Clicked!", Toast.LENGTH_SHORT).show()
                    // If you stay on the current fragment, AppBar visibility should be maintained (as GONE)
                    // Or, if you navigate elsewhere, adjust appBarLayout.visibility accordingly
                    return@setOnItemSelectedListener false // Keep current fragment or handle differently
                }
                R.id.nav_reels -> {
                    selectedFragment = ReelsFragment()
                    appBarLayout.visibility = View.GONE // Hide for ReelsFragment
                }
                R.id.nav_profile -> selectedFragment = ProfileFragment()
            }

            selectedFragment?.let {
                replaceFragment(it)
                return@setOnItemSelectedListener true
            }
            false
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
