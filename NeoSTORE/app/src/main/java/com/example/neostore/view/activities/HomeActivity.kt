package com.example.neostore.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.neostore.R
import com.example.neostore.view.fragments.BagFragment
import com.example.neostore.view.fragments.FavoriteFragment
import com.example.neostore.view.fragments.HomeFragment
import com.example.neostore.view.fragments.ProfileFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        appBarConfiguration = AppBarConfiguration
            .Builder(R.id.homeFragment, R.id.favFragment, R.id.bagFragment, R.id.profileFragment)
            .setOpenableLayout(main_drawer_layout)
            .build()

        //set toolbar to action bar
        setSupportActionBar(main_toolbar)

        navController = findNavController(R.id.fragment_host)
        setupActionBarWithNavController(navController, appBarConfiguration)

        //setting bottom fragments
        loadFragment(HomeFragment.newInstance())
        main_bottom_navigation_view.setOnItemSelectedListener { item ->
            var fragment: Fragment
            when (item.itemId) {
                R.id.homeFragment -> {
                    main_toolbar?.title = "Home"
                    fragment = HomeFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.favFragment -> {
                    main_toolbar?.title = "Favorite"
                    fragment = FavoriteFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.bagFragment -> {
                    main_toolbar?.title = "Bag"
                    fragment = BagFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.profileFragment -> {
                    main_toolbar?.title = "Profile"
                    fragment = ProfileFragment()
                    loadFragment(fragment)
                    true
                }
                else -> false
            }
        }

        val toggle = ActionBarDrawerToggle(
            this, main_drawer_layout, main_toolbar, 0, 0
        )
        main_drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        main_navigation_view.setNavigationItemSelectedListener(this)
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_host, fragment)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment
        when (item.itemId) {
            R.id.homeDrFragment -> {
                main_toolbar?.title = "Home"
                fragment = HomeFragment()
                loadFragment(fragment)
                true
            }
            R.id.favDrFragment -> {
                main_toolbar?.title = "Favorite"
                fragment = FavoriteFragment()
                loadFragment(fragment)
                true
            }
            R.id.bagDrFragment -> {
                main_toolbar?.title = "Bag"
                fragment = BagFragment()
                loadFragment(fragment)
                true
            }
            R.id.profileDrFragment -> {
                main_toolbar?.title = "Profile"
                fragment = ProfileFragment()
                loadFragment(fragment)
                true
            }
            else -> false
        }

        main_drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


}

