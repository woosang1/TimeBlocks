package com.example.timeblcks

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(context : Context): RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {

//    lateinit var recyclerView: RecyclerView
    lateinit var calendarAdapter: CalendarAdapter
    val context = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder =
        PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_calendar, parent, false))

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        calendarAdapter = CalendarAdapter()

        val myLayoutManager = GridLayoutManager(context, 7)
        holder.recyclerView.layoutManager = myLayoutManager

        if (position == 0){
            holder.recyclerView.setBackgroundColor(Color.BLUE)
        }
        else if(position == 1){
            holder.recyclerView.setBackgroundColor(Color.RED)
        }
        else{
            holder.recyclerView.setBackgroundColor(Color.GREEN)
        }
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