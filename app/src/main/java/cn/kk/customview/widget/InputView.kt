package cn.kk.customview.widget

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView

private const val TAG = "InputView"
val TEXT_SZIE = 26f
val TEXT_COLOR = Color.parseColor("#BBCCBB")

class InputView(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {


    constructor(context: Context?) : this(context, null)

    fun setData() {
        // 接收数据，根据数据动态生成子 view
        val textView1 = TextView(context).apply {
            text = "What are askdfjask lkasjf a"
//            text = "-_-_-"
            textSize = TEXT_SZIE
            setTextColor(TEXT_COLOR)

            val targetLayoutParams =
                LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            targetLayoutParams.width = paint.measureText(text.toString()).toInt()
            layoutParams = targetLayoutParams
        }
        val word1 = "you"
        val et1 = EditText(context).apply {
            textSize = TEXT_SZIE
            setTextColor(TEXT_COLOR)
            minWidth = (paint.measureText("you") * word1.length).toInt()
            val targetLayoutParams =
                LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            targetLayoutParams.width = minWidth
            layoutParams = targetLayoutParams
        }
        val word2 = "doing"
        val et2 = EditText(context).apply {
            textSize = TEXT_SZIE
            setTextColor(TEXT_COLOR)
            minWidth = (paint.measureText(" ") * word2.length).toInt()
            val targetLayoutParams =
                LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            targetLayoutParams.width = minWidth
            layoutParams = targetLayoutParams
        }
        val textView2 = TextView(context).apply {
            text = " now?"
            textSize = TEXT_SZIE
            setTextColor(TEXT_COLOR)
            val targetLayoutParams =
                LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            targetLayoutParams.width = paint.measureText(text.toString()).toInt()
            layoutParams = targetLayoutParams
        }

        addView(textView1)
        addView(et1)
        addView(et2)
        addView(textView2)

//        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMode)
        val heightSize = MeasureSpec.getSize(heightMode)

        /*measureChildren(widthMeasureSpec, heightMeasureSpec)

        if (childCount == 0) {
            setMeasuredDimension(0, 0)
        } else {
            for (i in 0 until childCount) {
                val curChild = getChildAt(i)
                val curChildWidth = curChild.measuredWidth
                val curChildHeight = curChild.measuredHeight
                if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
                    // 宽和高都是 AT_MOST，宽度设置为所有宽度的和，高度设置为第一个 子view 的高度
                    setMeasuredDimension(curChildWidth, curChildHeight)
                } else if (widthMode == MeasureSpec.AT_MOST) {
                    // 宽是 AT_MOST,宽度设置为所有宽度的和
                    setMeasuredDimension(getChildAt(0).width * childCount, heightSize)
                } else if (heightMode == MeasureSpec.AT_MOST) {
                    // 高是 AT_MOST,高度设置为第一个元素的高度
                    Log.d(
                        TAG,
                        "onMeasure: curChildWidth: ${curChildWidth}, curChildHeight: ${curChildHeight}"
                    )
                    setMeasuredDimension(curChildWidth, curChildHeight)
                }
            }
        }*/

        for (i in 0 until childCount){
            val curChild = getChildAt(i)
            curChild.layoutParams
            curChild.measure(getChildMeasureSpec(widthMeasureSpec,0,curChild.layoutParams.width),
            getChildMeasureSpec(heightMeasureSpec,0,curChild.layoutParams.height))
            val curChildWidth = curChild.measuredWidth
            val curChildHeight = curChild.measuredHeight
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var left = 0
        var top = 0
        var lastViewOfLineHeight = 0;
        for (i in 0 until childCount) {
            if (left > width) {
                left = 0
                top += lastViewOfLineHeight
            }
            getChildAt(i).layout(left, top, left + measuredWidth, top + measuredHeight)
            left += measuredWidth
            lastViewOfLineHeight = measuredHeight
            Log.d(TAG, "onLayout: left: ${left}, top: ${top}")
            Log.d(
                TAG,
                "onLayout: measuredWidth: ${measuredWidth}, measuredHeight: ${measuredHeight}"
            )
        }
    }


}