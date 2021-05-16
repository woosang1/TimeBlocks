package com.example.timeblcks

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.timeblcks.layout.CalendarMemoLayout
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.zip.Inflater

class CalendarAdapter(context : Context, addMonth : Int): RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>() {

    val context = context
    var addMonth = addMonth
    var dayCount = 1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder =
        CalendarViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_calendar_item, parent, false))

    override fun getItemCount(): Int = 35

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        var calendar  = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_MONTH , dayCount);
        calendar.add(Calendar.MONTH,addMonth)

        val startDay = startDay(addMonth)
        if (startDay <= position && dayCount <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH)){
            holder.day.text = dayCount.toString()
            dayCount++
        }
        else{
            holder.day.text = ""
        }
        val df2: DateFormat = SimpleDateFormat("yyyyMMdd")
        val memoText = getMemoFromDB(df2.format(calendar.time))
//        holder.memoLayout.addView(CalendarMemoLayout(context, "ssss"))
        if(memoText != ""){
            Log.i("@@", "memoText exsit : " + memoText)
            val factory: LayoutInflater = LayoutInflater.from(context)
            val myView: View = factory.inflate(R.layout.activity_calendar_memo_item, null)
            val itemText = myView.findViewById<TextView>(R.id.tv_memo_day)
            itemText.text = memoText
            holder.memoLayout.addView(myView)
            holder.memoLayout.invalidate();
        }
        // 존재 X
        else{

        }

        holder.day.setOnClickListener {
            Log.i("@@" , "calendarAdapter click : " + position)
            val popup = PopupConfirm(context = context , this , position)
            popup.start(addMonth, Integer.parseInt(holder.day.text.toString()))
        }

    }

    inner class CalendarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val day = itemView.findViewById<TextView>(R.id.tv_day)
        val memoLayout = itemView.findViewById<LinearLayout>(R.id.ll_memo_layout)
    }

     public fun changeMonth(newAddMonth: Int){
        addMonth = newAddMonth
    }

    private fun startDay(addMonth : Int) : Int{
        var calendar  = Calendar.getInstance()
        calendar.add(Calendar.MONTH,addMonth)
        val startDay = calendar.get(Calendar.DAY_OF_WEEK) -1
//        Log.i("aa" , "startDay : $startDay")
        return startDay
    }

    private fun getMemoFromDB(date : String) : String{
        val prefs: SharedPreferences = context.getSharedPreferences("Memo", Context.MODE_PRIVATE)
        val text = prefs.getString(date,"")
        return text!!
    }

}