package com.example.neostore.view.activities

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.neostore.R
import com.example.neostore.view.fragments.BagFragment
import com.example.neostore.view.fragments.FavoriteFragment
import com.example.neostore.view.fragments.HomeFragment
import com.example.neostore.view.fragments.ProfileFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.custom_tab_home.*


class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

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
        iv_ic_menu.setOnClickListener {
            main_drawer_layout.openDrawer(Gravity.LEFT)
        }

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

        main_navigation_view.setNavigationItemSelectedListener(this)
    }

    private fun loadFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction()
            .replace(R.id.relative_layout, fragment)
            .addToBackStack(null)
            .commit()
    }


    //setting navigation fragments
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

