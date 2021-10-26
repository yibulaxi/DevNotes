package cn.kk.customview.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import cn.kk.base.utils.DateHelper

/**
 * 周日历打卡控件
 */
class WeekView: ViewGroup {

    val WEEK_SIZE = 7
    val WEEKS = arrayOf("一","二","三","四","五","六","日")

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
        val weekDay = DateHelper.getWeekDay()
        val allDaysOfWeek = DateHelper.getAllDaysOfWeek()
        for(index in 0 until WEEK_SIZE){
            addView(DayView(context).apply {
                setData(allDaysOfWeek.get(index +1)!!.toInt(), WEEKS[index], false, allDaysOfWeek.get(weekDay)!!)
            })
        }
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)

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
     * 播放动画
     * @param 需要被动画覆盖的 DayView 索引
     * @param animView 播放动画的控件（非 WeekView 中的控件，和 WeekView 在同一个容器中）
     */
    fun playAnim(index: Int, animView: View){
       val flagView = (getChildAt(index) as DayView).getCheckInFlagView()

        val left = flagView.left + (flagView.parent.parent as View).left
        val top = flagView.top + top
        val cenX = (left + flagView.width / 2)
        val cenY = (top + flagView.height / 2)

        val startLeft = cenX - animView.width / 2
        val startTop = cenY - animView.height / 2
        animView.layout(startLeft, startTop, startLeft + animView.width, startTop + animView.height)
        animView.visibility = View.VISIBLE

        val scaleAnim = ScaleAnimation(1f, 0.1f, 1f, 0.1f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        scaleAnim.duration = 500
        scaleAnim.fillAfter = true

        animView.startAnimation(scaleAnim)
    }
}