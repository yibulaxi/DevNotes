package cn.kk.customview.widget.work

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import cn.kk.base.utils.DateHelper
import cn.kk.customview.R

/**
 * 打卡页面，显示星期的控件
 * 1. 周一到周日
 * 2. 汉字一排，数字一排
 * 3. 打卡的数字上要覆盖上动画
 */
class CheckInWeekView: ViewGroup {
    val TAG = "CheckInWeekView---"
    val WEEK_SIZE = 7
    val WEEKS = arrayOf("一","二","三","四","五","六","日")
    var todayIndexOfWeek = 0

    constructor(context: Context): super(context){
        initView(context)
    }

    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet){
        initView(context)
    }

    fun initView(context: Context){
        createDayView(context)
    }

    private fun createDayView(context: Context) {
        // 获取当前的日期
        val dayOfWeek = DateHelper.getWeekDay()
        todayIndexOfWeek = dayOfWeek - 1
        val allWeekDays = DateHelper.getAllDaysOfWeek()
        for(index in 0 until WEEK_SIZE){
            addView(DayView(context).apply {
                setData(allWeekDays.get(index + 1)!!, WEEKS[index], allWeekDays.get(dayOfWeek)!!)
            })
        }
    }

    /**
     * 星期中的某一天 view
     */
    inner class DayView(context: Context): RelativeLayout(context) {
       lateinit var containerView: View
       var monthDay = 0
        var isToday = false

        constructor(context: Context, attributeSet: AttributeSet): this(context)

        init {
            initView(context)
        }

       fun initView(context: Context){
           containerView = LayoutInflater.from(context).inflate(R.layout.day_view_checkin, this, true)
       }

        /**
         * @param dayOfMonth
         * @param weekDay 周一 ～ 周日
         * @param checkInState 打卡状态
         * @param todayOfMonth 今天是几号
         */
        fun setData(dayOfMonth: Int, weekDay: String, todayOfMonth: Int){
            val tvWeekDay = containerView.findViewById<TextView>(R.id.tv_week_day)
            val tvMonthDay = containerView.findViewById<TextView>(R.id.tv_month_day)
            monthDay = dayOfMonth

            tvMonthDay.text = dayOfMonth.toString()
            tvWeekDay.text = weekDay
            isToday = todayOfMonth == dayOfMonth

        }

        fun getCheckInFlagView(): ImageView{
            return containerView.findViewById(R.id.iv_checkin_flag)
        }

        fun signCheckInState(){
            getCheckInFlagView().visibility = View.VISIBLE
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)

        var containerHeight = 0

        for (index in 0 until childCount){

            val child = getChildAt(index)
            measureChild(child, widthMeasureSpec, heightMeasureSpec)

            val childHeight = child.measuredHeight
            if (containerHeight < childHeight){
                containerHeight = childHeight
            }
        }

        setMeasuredDimension(widthSize, containerHeight)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val totalWidth = r - l - paddingLeft - paddingRight
        val spaceSize = (totalWidth - getChildAt(0).measuredWidth * childCount) / (childCount - 1)
        var lineLeft = 0 + paddingLeft
        var lineTop = 0

        for (index in 0 until  childCount){
            val childView = getChildAt(index)

            childView.layout(lineLeft, lineTop, lineLeft + childView.measuredWidth, lineTop + childView.measuredHeight)
            lineLeft += (spaceSize + childView.measuredWidth)
        }
    }

    /**
     * 给签到的日期盖章
     * @param signDays 服务器得到的最近签到的日期数组。格式：2021-10-21
     * @param hasShowTodayFlag 今天是否打开过打卡页面
     */
    fun signCheckInView(signDays: Array<String>, hasShowTodayFlag: Boolean){
        val signDaysOfMonth = mutableListOf<Int>()

        signDays.forEach {
           val dayOfMonth = it.split("-")[2].toInt()
            signDaysOfMonth.add(dayOfMonth)
        }

        for (index in 0 until childCount) {
            val dayView = (getChildAt(index) as DayView)
            signDaysOfMonth.forEach {
                if (dayView.monthDay == it) {
                    // 如果是今天，今天已经进入过打卡页面了，则显示 盖章，否则不显示 盖章
                        if (dayView.isToday){
                            if (hasShowTodayFlag){
                                dayView.signCheckInState()
                            }

                        } else {
                             dayView.signCheckInState()
                        }
                    return@forEach
                }
            }
        }

    }

    /**
     * 播放动画
     * @param 需要被动画覆盖的 DayView 索引
     * @param animView 播放动画的控件（非 CheckInWeekView 中的控件，和 CheckInWeekView 在同一个容器中）
     */
    fun playAnim(animView: View){
        val scaleRadio = 14
        val flagView = (getChildAt(todayIndexOfWeek) as DayView).getCheckInFlagView()

        val outFlagViewSize = flagView.width * scaleRadio

        val left = flagView.left + (flagView.parent.parent as View).left
        val top = flagView.top + top
        val cenX = (left + flagView.width / 2)
        val cenY = (top + flagView.height / 2)



        if (animView.parent is ConstraintLayout) {
            animView.layoutParams = (animView.layoutParams as ConstraintLayout.LayoutParams).apply {
                width = outFlagViewSize
                height = outFlagViewSize
            }
        } else if (animView.parent is RelativeLayout) {
            animView.layoutParams = (animView.layoutParams as RelativeLayout.LayoutParams).apply {
                width = outFlagViewSize
                height = outFlagViewSize
            }
        } else if (animView.parent is LinearLayout) {
            animView.layoutParams = (animView.layoutParams as LinearLayout.LayoutParams).apply {
                width = outFlagViewSize
                height = outFlagViewSize
            }
        } else if (animView.parent is FrameLayout) {
            animView.layoutParams = (animView.layoutParams as FrameLayout.LayoutParams).apply {
                width = outFlagViewSize
                height = outFlagViewSize
            }
        }

        animView.post(object : Runnable{
            override fun run() {
                val startLeft = cenX - outFlagViewSize / 2
                val startTop = cenY - outFlagViewSize / 2

                animView.layout(startLeft, startTop, startLeft + outFlagViewSize, startTop + outFlagViewSize)
                animView.visibility = View.VISIBLE

                val scaleAnim = ScaleAnimation(1f, 0.071f, 1f, 0.071f,
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
                val alphaAnim = AlphaAnimation(0f, 1f)

                val animationSet = AnimationSet(true)
                animationSet.addAnimation(scaleAnim)
                animationSet.addAnimation(alphaAnim)
                animationSet.duration = 500
                animationSet.fillAfter = true

                animationSet.setAnimationListener(object : Animation.AnimationListener{
                    override fun onAnimationStart(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        animationSet.fillAfter = false
                        animView.visibility = View.GONE
                        flagView.visibility = View.VISIBLE
                    }

                    override fun onAnimationRepeat(animation: Animation?) {
                    }

                })
                animView.startAnimation(animationSet)
            }

        })


    }

}

