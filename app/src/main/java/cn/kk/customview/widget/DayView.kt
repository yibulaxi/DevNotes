package cn.kk.customview.widget

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import cn.kk.customview.R

class DayView(context: Context): RelativeLayout(context) {
    lateinit var containerView: View
   constructor(context: Context, attributeSet: AttributeSet): this(context){

   }

    init {
        initView()
    }

    fun initView(){
       containerView = LayoutInflater.from(context).inflate(R.layout.day_view, this, true)
    }

    fun setData(day: Int, weekDay: String,checkInState: Boolean, today: Int){
        val tvWeekDay = containerView.findViewById<TextView>(R.id.tv_week_day)
        val tvMonthDay = containerView.findViewById<TextView>(R.id.tv_month_day)
        val ivCheckIn = containerView.findViewById<ImageView>(R.id.iv_checkin_flag)
        if (checkInState) ivCheckIn.visibility = View.VISIBLE
        tvMonthDay.text = day.toString()
        tvWeekDay.text = weekDay

        if (day < today){
            tvMonthDay.setTextColor(Color.RED)
        } else if (day == today) {
            tvMonthDay.setTextColor(Color.GREEN)
        } else {
            tvMonthDay.setTextColor(Color.BLUE)
        }
    }

    fun getCheckInFlagView(): ImageView{
        return containerView.findViewById(R.id.iv_checkin_flag)
    }
}