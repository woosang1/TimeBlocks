package com.example.timeblcks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CalendarAdapter(val list : ArrayList<String>) : RecyclerView.Adapter<CalendarAdapter.onViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): onViewHolder {
        return onViewHolder(parent)
    }

    override fun onBindViewHolder(holder: onViewHolder, position: Int) {
        holder.day.text = list[position].toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class onViewHolder(parent: ViewGroup)  : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.calendar_item, parent, false)){
        val context = parent.context
        var day: TextView = itemView.findViewById<TextView>(R.id.tv_day)
    }


}