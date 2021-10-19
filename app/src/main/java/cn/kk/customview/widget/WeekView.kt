package cn.kk.customview.widget

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView

class WeekView: ViewGroup {

    val WEEK_SIZE = 7
    val WEEKS = arrayOf("一","二","三","四","五","六","日")
    val intervalLineSpace = 50

    constructor(context: Context): super(context){
        initView(context)
    }

    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet){
        initView(context)

    }

    fun initView(context: Context){
        // create 7 view
        createUpperView(context)
        createLowerView(context)
    }

    fun createUpperView(context: Context){
        for(index in 0 until WEEK_SIZE){
            addView(TextView(context).apply { text = WEEKS[index] })
        }
    }

    fun createLowerView(context: Context){
        for(index in 0 until WEEK_SIZE){
            val lowerView = FrameLayout(context)
            lowerView.addView(TextView(context).apply { text = (index+1).toString() })
            addView(lowerView)
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
            if (index < childCount / 2){
                if (containerHeight < childHeight){
                    containerHeight = childHeight
                }
            } else {
                if (index == childCount / 2){
                    // 换行
                    containerHeight += intervalLineSpace + childHeight
                }
            }
        }

        setMeasuredDimension(widthSize, containerHeight)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val lineCount = childCount / 2
        val horizontalSpaceFirst = ((r - l) - lineCount * (getChildAt(0).measuredWidth)) / (lineCount - 1)
        val horizontalSpaceSecond = ((r - l) - lineCount * (getChildAt(lineCount).measuredWidth)) / (lineCount - 1)
        for(index in 0 until childCount){
            val child = getChildAt(index)

            val lineIndex = if (index < lineCount) index else index - lineCount
            val left = lineIndex * (if (index < lineCount) horizontalSpaceFirst else horizontalSpaceSecond + child.measuredWidth)
            val right = left + child.measuredWidth
            val top = if (index < lineCount) 0 else getChildAt(0).measuredHeight + intervalLineSpace
            val bottom = top + child.measuredHeight

            child.layout(left, top, right, bottom)
        }
    }
}