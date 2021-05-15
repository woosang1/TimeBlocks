package com.example.timeblcks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    lateinit var viewPager : ViewPager2
    lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.vp_pager);

        viewPagerAdapter = ViewPagerAdapter()
        viewPager.adapter = viewPagerAdapter
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

//        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback())

    }
}