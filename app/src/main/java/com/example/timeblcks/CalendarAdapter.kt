package com.example.timeblcks

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class CalendarAdapter(addMonth : Int): RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>() {

    var addMonth = addMonth
    var dayCount = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder =
        CalendarViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_calendar_item, parent, false))

    override fun getItemCount(): Int = 30

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        val startDay = startDay(addMonth)
        if (startDay <= position){
            holder.day.text = dayCount.toString()
            dayCount++
        }
        else{
            holder.day.text = ""
        }
//        holder.bind(mList[position])
    }

    inner class CalendarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val day = itemView.findViewById<TextView>(R.id.tv_day)

//        private val photoView = itemView.find<PhotoView>(R.id.photoView)

//        fun bind(image: Bitmap) {
//            photoView.imageBitmap = image //anko 라이브러리 사용
//        }
    }

    private fun startDay(addMonth : Int) : Int{
        var calendar  = Calendar.getInstance()
        calendar.add(Calendar.MONTH,addMonth)
        val startDay = calendar.get(Calendar.DAY_OF_WEEK) -1
        Log.i("aa" , "startDay : $startDay")
        return startDay
    }

}