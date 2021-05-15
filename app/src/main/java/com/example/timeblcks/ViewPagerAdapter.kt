package com.example.timeblcks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(): RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {

//    lateinit var recyclerView: RecyclerView
    lateinit var calendarAdapter: CalendarAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder =
        PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_calendar, parent, false))

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {

        calendarAdapter = CalendarAdapter()
        holder.recyclerView.adapter = calendarAdapter

//        holder.bind(mList[position])
    }

    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView = itemView.findViewById<RecyclerView>(R.id.rv_calendar)

//        fun bind(image: Bitmap) {
//            photoView.imageBitmap = image //anko 라이브러리 사용
//        }
    }
}