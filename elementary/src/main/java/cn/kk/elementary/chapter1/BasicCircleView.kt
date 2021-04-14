package cn.kk.elementary.chapter1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * 画笔 Paint 基本使用
 * 1. onDraw() 中画圆
 * 2. Paint 基本设置
 *  1. style: Paint.Style.STROKE, Paint.Style.FILL, Paint.Style.FILL_AND_STROKE
 *  2. color
 *  3. strokeWidth
 */
class BasicCircleView : View {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    )


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 设置画笔
        val paint = Paint().apply {
            color = Color.argb(0xff, 0xff, 0x00, 0x00)
            style = Paint.Style.STROKE  // 填充样式, 描边
            strokeWidth = 50f           // 画笔宽度
        }

        // 画圆环
        val centX = 190f
        val centY = 200f
        val radius = 150f
        canvas.drawCircle(centX, centY, 150f, paint)

        // 画实心圆
        val radius2 = 100f
        paint.style = Paint.Style.FILL  // 填充样式, 填充
        paint.color = Color.argb(0x7e, 0xff, 0x00, 0x00)
        canvas.drawCircle(centX, centY, 150f, paint)
    }
}