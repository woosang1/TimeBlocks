package com.example.timeblcks

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import java.util.logging.Logger

class ViewPagerAdapter(context : Context): RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {

    private lateinit var calendarAdapter: CalendarAdapter
    private val context = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder =
        PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_calendar, parent, false))

    override fun getItemCount(): Int = 12

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        calendarAdapter = CalendarAdapter(context,position)

        val myLayoutManager = GridLayoutManager(context, 7)
        holder.recyclerView.layoutManager = myLayoutManager

//        val date = position % 7
//        // Sun
//        if (date == 0){
//            holder.recyclerView.setBackgroundColor(Color.BLUE)
//
////            calendar.get(Calendar.)
//
//        }
//        // Mon
//        else if(date == 1){
//            holder.recyclerView.setBackgroundColor(Color.RED)
//        }
//
//        // Tue
//        else if (date == 2){
//
//        }
//
//        // Wed
//        else if (date == 3){
//
//        }
//
//        // Fri
//        else if (date == 4){
//
//        }
//
//        // Sat
//
//        else{
//            holder.recyclerView.setBackgroundColor(Color.GREEN)
//        }
        holder.recyclerView.adapter = calendarAdapter

//        holder.bind(mList[position])
    }

    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView = itemView.findViewById<RecyclerView>(R.id.rv_calendar)

//        fun bind(image: Bitmap) {
//            photoView.imageBitmap = image //anko 라이브러리 사용
//        }
    }

    public fun getCalendarAdapter() : CalendarAdapter? {
        if (calendarAdapter != null){
            return calendarAdapter
        }
        else{
            return null
        }
    }

}