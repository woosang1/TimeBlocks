package com.example.timeblcks

import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class PopupConfirm(context : Context, calendarAdapter: CalendarAdapter) {
    private val context = context
    private val calendarAdapter = calendarAdapter
    private val dlg = Dialog(context)
    private lateinit var dayOfWeekTextView : TextView
    private lateinit var dayTextView: TextView
    private lateinit var monthTextView: TextView
    private lateinit var btnOK : Button
    private lateinit var memoText : EditText

    fun start(addMonth : Int, dayCount : Int) {

        dlg.setContentView(R.layout.popup_confirm)     //다이얼로그에 사용할 xml 파일을 불러옴
        dlg.setCancelable(false)    //다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함

        dayOfWeekTextView = dlg.findViewById<TextView>(R.id.tv_popup_day_of_week)
        dayTextView = dlg.findViewById<TextView>(R.id.tv_popup_day)
        monthTextView = dlg.findViewById<TextView>(R.id.tv_popup_month)
        memoText = dlg.findViewById<EditText>(R.id.et_memo_text)

        btnOK = dlg.findViewById(R.id.b_confirm)

        var todayCalendar: Calendar = Calendar.getInstance()
        val cal = todayCalendar

        cal.set(Calendar.DAY_OF_MONTH , dayCount);
        Log.i("@@ ", "before : " + cal.time.toString());
        cal.add(Calendar.MONTH, addMonth)

        Log.i("@@ ", "after : " + cal.time.toString());

        val df: DateFormat = SimpleDateFormat("EEE-MMMM-d")
        val dayOfWeekStr = df.format(cal.time).split("-")[0]
        val monthStr = df.format(cal.time).split("-")[1]
        val dayStr = df.format(cal.time).split("-")[2]

        dayOfWeekTextView.text = dayOfWeekStr + ","
        dayTextView.text = dayStr
        monthTextView.text = monthStr

        dlg.show()

        btnOK.setOnClickListener {
            val df2: DateFormat = SimpleDateFormat("yyyyMMdd")
            saveData(df2.format(cal.time), memoText.text.toString());
            dlg.dismiss()
            if (calendarAdapter != null){
                calendarAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun saveData(date : String, text : String){
        Log.i("@@ ", "memo  date : " + date + "text : " + text)
        val prefs: SharedPreferences = context.getSharedPreferences("Memo", Context.MODE_PRIVATE)
        val edit = prefs.edit()
        edit.putString(date , text)
        edit.apply()
    }

}
