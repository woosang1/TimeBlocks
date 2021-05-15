package com.example.timeblcks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
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
                getToday(position)
//                if (position == 0) {
//                    // you are on the first page
//
//                }
//                else if (position == 1) {
//                    // you are on the second page
//                }
//                else if (position == 2){
//                    // you are on the third page
//                }
                super.onPageSelected(position)
            }
        })

    }

    private fun getToday(addDay : Int){
        val cal = Calendar.getInstance()
        cal.add(Calendar.MONTH, addDay)
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH) + 1
        val day = cal.get(Calendar.DATE)

        mouthTextView.text = month.toString()
        yearTextView.text = year.toString()
    }
}