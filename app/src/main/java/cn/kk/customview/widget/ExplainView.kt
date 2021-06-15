package cn.kk.customview.widget

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import cn.kk.customview.R


open class ExplainView : ViewGroup {

    // 展开状态，默认不展开
    var explainState = false
    val MAXLINES_BEFORE_EXPLAIN = 3
    val textView by lazy {
        TextView(context).apply {
            maxLines = MAXLINES_BEFORE_EXPLAIN
        }
    }
    val imageButton by lazy {
        ImageButton(context).apply {
            setImageResource(R.drawable.icon_explain)

            val params = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            params.height = dp2pxInt(16f)
            layoutParams = params

            setPadding(dp2pxInt(5f), 0, 0, 0)

            setBackgroundColor(Color.WHITE)
        }
    }

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attributeSet: AttributeSet) : super(context, attributeSet) {

    }

    init {

        addView(textView)
        addView(imageButton.apply {
//            background = null
            setOnClickListener {
                // 点击事件

                if (explainState) {
                    textView.maxLines = MAXLINES_BEFORE_EXPLAIN
                    setImageResource(R.drawable.icon_explain)
                } else {
                    textView.maxLines = textView.lineCount
                    setImageResource(R.drawable.icon_collapse)
                }
                explainState = !explainState

            }
        })
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val measureWidthSize = MeasureSpec.getSize(widthMeasureSpec)
        val measureHeightSize = MeasureSpec.getSize(heightMeasureSpec)
        val measureWidthMode = MeasureSpec.getMode(widthMeasureSpec)
        val measureHeightMode = MeasureSpec.getMode(heightMeasureSpec)

        // 这句很重要
        measureChildren(widthMeasureSpec, heightMeasureSpec)

        var containerWidth = 0
        var containerHeight = 0

        for (index in 0 until childCount) {
            val childView = getChildAt(index)
            if (childView is TextView) {
                // 如果是 TextView，那么父控件的尺寸就和该子 view 尺寸一样
                containerWidth = childView.measuredWidth + paddingLeft + paddingRight
                containerHeight = childView.measuredHeight + paddingTop + paddingBottom

                if ((childView as TextView).lineCount > MAXLINES_BEFORE_EXPLAIN) {

                }
            } else {

            }
        }

        val finalWidth =
            if (measureWidthMode == MeasureSpec.EXACTLY) measureWidthSize else containerWidth
        val finalHeight =
            if (measureHeightMode == MeasureSpec.EXACTLY) measureHeightSize else containerHeight

        // 行数不超过限制，就不限时
        if (textView.lineCount <= MAXLINES_BEFORE_EXPLAIN){
            imageButton.visibility = View.GONE
        }
        setMeasuredDimension(finalWidth, finalHeight)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

        for (index in 0 until childCount) {
            val childView = getChildAt(index)
            if (childView is TextView) {
                childView.layout(l + paddingLeft, t + paddingTop, r - paddingRight, b - paddingBottom)
            } else {
                val left = r - childView.measuredWidth - childView.paddingLeft + paddingLeft
                val top = b - childView.measuredHeight + paddingTop
                childView.layout(left, top, r - paddingRight, b - paddingBottom)
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        explainState = textView.lineCount <= textView.maxLines

    }

    fun setData(data: String) {
        textView.text = data
    }

    companion object {
        fun dp2px(value: Float): Float {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                value,
                Resources.getSystem().displayMetrics
            )
        }

        fun dp2pxInt(value: Float): Int {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                value,
                Resources.getSystem().displayMetrics
            ).toInt()
        }
    }
}