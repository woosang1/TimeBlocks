package com.example.timeblcks

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.Button
import android.widget.TextView
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class PopupConfirm(context : Context) {
    private val dlg = Dialog(context)
    private lateinit var dayOfWeekTextView : TextView
    private lateinit var dayTextView: TextView
    private lateinit var monthTextView: TextView
    private lateinit var btnOK : Button

    fun start(addMonth : Int, dayCount : Int) {

        dlg.setContentView(R.layout.popup_confirm)     //다이얼로그에 사용할 xml 파일을 불러옴
        dlg.setCancelable(false)    //다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함

        dayOfWeekTextView = dlg.findViewById<TextView>(R.id.tv_popup_day_of_week)
        dayTextView = dlg.findViewById<TextView>(R.id.tv_popup_day)
        monthTextView = dlg.findViewById<TextView>(R.id.tv_popup_month)

        btnOK = dlg.findViewById(R.id.b_confirm)
        btnOK.setOnClickListener {

            dlg.dismiss()
        }

        var todayCalendar: Calendar = Calendar.getInstance()
        val cal = todayCalendar
        cal.add(Calendar.MONTH, addMonth)
        cal.add(Calendar.DAY_OF_WEEK, dayCount)

        val month = cal.get(Calendar.MONTH) + 1
        val day = cal.get(Calendar.DATE)
        val dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)

        val df: DateFormat = SimpleDateFormat("EEE-MMMM-d")
        val dayOfWeekStr = df.format(cal.time).split("-")[0]
        val monthStr = df.format(cal.time).split("-")[1]
        val dayStr = df.format(cal.time).split("-")[2]

        dayOfWeekTextView.text = dayOfWeekStr + ","
        dayTextView.text = dayStr
        monthTextView.text = monthStr

        dlg.show()
    }

}
