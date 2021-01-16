package com.example.neostore.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.custom.sliderimage.adapters.ViewPagerAdapter
import com.example.neostore.R


class HomeActivity: AppCompatActivity() {

    // creating object of ViewPager
    var mViewPager: ViewPager? = null

    // images array
    var images = intArrayOf(
        R.drawable.slider_img1,
        R.drawable.slider_img2,
        R.drawable.slider_img3,
        R.drawable.slider_img4
    )

    // Creating Object of ViewPagerAdapter
    var mViewPagerAdapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

//        // Initializing the ViewPager Object
//        mViewPager = findViewById(R.id.view_pager) as ViewPager
//
//        // Initializing the ViewPagerAdapter
//        mViewPagerAdapter = ViewPagerAdapter(this, images)
//
//        // Adding the Adapter to the ViewPager
//        mViewPager!!.adapter = mViewPagerAdapter
    }
}