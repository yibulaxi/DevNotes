package cn.kk.customview.widget;

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.widget.GridView
import android.widget.TextView
import androidx.core.view.setPadding
import cn.kk.customview.utils.ValueUtil

/**
 * description: This is ...
 * Project: CustomeView
 * 创建人: zhangkx(张开旭)
 * 创建时间: 2021-04-12 2:08 AM
 */
private const val TAG = "AlertView"

class AlertView(context: Context?, attrs: AttributeSet?) : TextView(context, attrs) {
    val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val rect: RectF = RectF()

    constructor(context: Context?) : this(context, null)

    init {
        paint.apply {
            style = Paint.Style.STROKE
        }
        setPadding(ValueUtil.dp2pxInt(4f))
        elevation = ValueUtil.dp2px(20f)
        gravity = Gravity.START
        setBackgroundColor(Color.WHITE)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = paint.measureText(text.toString())


    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        /* // 绘制边框形状
         rect.right = width - 5f
         rect.bottom = height - 5f
         canvas.drawRoundRect(rect,8f,8f,paint)*/

    }
}