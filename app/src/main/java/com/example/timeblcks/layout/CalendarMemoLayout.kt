package com.example.timeblcks.layout

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.example.timeblcks.R

class CalendarMemoLayout : LinearLayout {

    private var memoText = ""
    lateinit var dayTextView: TextView

    constructor(context: Context, text : String) : super(context)
    {
        this.memoText = text
        init(context)
    }
    constructor(context: Context, attrs: AttributeSet?, text : String) : super(context, attrs)
    {
        this.memoText = text
        init(context)
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, text : String) : super(context, attrs, defStyleAttr)
    {
        this.memoText = text
        init(context)
    }

    private fun init(context: Context){
        Log.i("@@" , "CalendarMemoLaout init")
        val view = LayoutInflater.from(context).inflate(R.layout.activity_calendar_memo_item,null,false)
        dayTextView = view.findViewById<TextView>(R.id.tv_memo_day)
        dayTextView.text = memoText
        Log.i("@@" , "text : " + memoText)
    }


}