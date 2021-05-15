package com.example.timeblcks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CalendarAdapter(): RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder =
        CalendarViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_calendar_item, parent, false))

    override fun getItemCount(): Int = 30

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.day.text = position.toString()
//        holder.bind(mList[position])
    }

    inner class CalendarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val day = itemView.findViewById<TextView>(R.id.tv_day)
//        private val photoView = itemView.find<PhotoView>(R.id.photoView)

//        fun bind(image: Bitmap) {
//            photoView.imageBitmap = image //anko 라이브러리 사용
//        }
    }
}