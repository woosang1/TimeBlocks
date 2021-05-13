package com.example.timeblcks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var calendarAdapter: CalendarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<String>()

        for (i in 0 .. 41){
            list.add("1")
        }

        calendarAdapter = CalendarAdapter(list)
        recyclerView = findViewById(R.id.rv_calendar)
        recyclerView.layoutManager = GridLayoutManager(this,7)
        recyclerView.adapter = calendarAdapter

    }
}