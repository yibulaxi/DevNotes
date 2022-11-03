package cn.kk.customview.widget.work

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import cn.kk.customview.R
import com.example.hencoder.dp

/**
 * 流式布局
 * todo
 * 1. 课指定行数 ok
 * 2. 分状态：选中、非选中
 * 3. 指定最大行数
 */
class ChannelTabView(ctx: Context, attrs: AttributeSet): ViewGroup(ctx, attrs) {

    val tab_count = 4
    var lineCount = 2 // 默认2行

    val TAB_VIEW_HEIGHT = dp2pxInt(30f)
    val TEXT_SZIE_OF_NORMAL_WORD = 15f
    val TAB_INTERVAL_MARGIN = dp2px(12f).toInt() // tab item view 左右间距
    val TAB_INTERVAL_MARGIN_VERTICAL = dp2px(10f).toInt() // tab item view 上下间距

    val tabNames = arrayListOf<String>()

    init {
        for (i in 1 until tab_count + 1) {
            tabNames.add(String.format("星期 · %d", i + 1))
        }

        createTabViews()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        var containerWidth = paddingLeft // 父容器宽
        var containerHeight = paddingTop // 父容器高

        var lineHeight = 0  // 记录每一行高度
        var lineWidth = 0  // 记录每一行宽度

        var totalTabViewWidth = 0 // 一行摆开，tab item views 总宽度，包括间隔
        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            if (childView.visibility != View.GONE) {
                measureChild(childView, widthMeasureSpec, heightMeasureSpec)
            } else {
                continue
            }

            // 拿到测量的宽和高
            val childW = childView.measuredWidth
            val childH = childView.measuredHeight

            totalTabViewWidth += childW
            if (i != childCount - 1) { // 不是最后一个，后面再加上 tab item view 间距
                totalTabViewWidth += TAB_INTERVAL_MARGIN
            }
        }

        // 根据要分几行，粗略计算一行的大致宽度，也就是父容器的宽度
        containerWidth = totalTabViewWidth / lineCount

        // 计算实际需要的一行宽度，也就是容器总宽度
        var tempWidth = 0
        for(i in 0 until childCount) {
            tempWidth += getChildAt(i).measuredWidth
            if (tempWidth >= containerWidth) {
                containerWidth = tempWidth;
                break
            }
        }

        containerHeight = getChildAt(0).measuredHeight * lineCount + (lineCount - 1) * TAB_INTERVAL_MARGIN_VERTICAL
        // 测量完成后，设置给系统
        setMeasuredDimension(containerWidth, containerHeight)

    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val containerWidth = r - l
        var lineHeight = 0
        var childLeft = paddingLeft
        var childTop = paddingTop

        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            if (childView.visibility == View.GONE) {
                continue
            }
            val childWidth = childView.measuredWidth
            val childHeight = childView.measuredHeight

            lineHeight = Math.max(childHeight, lineHeight)
            if (childLeft + childWidth + paddingRight > containerWidth) { // 换行
                childLeft = paddingLeft
                childTop += TAB_INTERVAL_MARGIN_VERTICAL + lineHeight
                lineHeight = childHeight
            }

            // 摆放 tab item view
            childView.layout(childLeft, childTop, childLeft + childWidth, childTop + childHeight)

            // 更新 childLeft
            childLeft += (childWidth + TAB_INTERVAL_MARGIN)
        }
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    // region create tab item view
    private fun createTabViews(){

        tabNames.forEach {
            val tab = TextView(context).apply {
                height = TAB_VIEW_HEIGHT
                textSize = TEXT_SZIE_OF_NORMAL_WORD
                text = it
                gravity = Gravity.CENTER
                setTextColor(ContextCompat.getColor(context, R.color.colorPrimary))
                setPadding(10.dp.toInt(), 0, 10.dp.toInt(), 0)
                setBackgroundResource(R.drawable.bg_shape_corner_primary_frame)
            }

            addView(tab)
        }

    }


    // endregion

    // region util method
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
    // endregion
}