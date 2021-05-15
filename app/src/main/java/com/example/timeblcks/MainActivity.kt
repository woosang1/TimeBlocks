package com.example.timeblcks

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var viewPager : ViewPager2
    lateinit var viewPagerAdapter: ViewPagerAdapter

    lateinit var mouthTextView : TextView
    lateinit var yearTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.vp_pager);

        viewPagerAdapter = ViewPagerAdapter(applicationContext)
        viewPager.adapter = viewPagerAdapter
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        mouthTextView = findViewById(R.id.tv_month)
        yearTextView = findViewById(R.id.tv_year)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                getToday(position)
            }
        })

    }

    private fun getToday(addDay : Int){
        var todayCalendar: Calendar = Calendar.getInstance()
        val cal = todayCalendar
        cal.add(Calendar.MONTH, addDay)
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH) + 1
        val day = cal.get(Calendar.DATE)

        mouthTextView.text = month.toString()
        yearTextView.text = year.toString()
    }
}