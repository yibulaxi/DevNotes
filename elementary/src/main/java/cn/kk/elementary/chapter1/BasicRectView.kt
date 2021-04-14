package cn.kk.elementary.chapter1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * Canvas 使用基础
 * 画矩形
 *
 * RectF(float 类型数值), Rect(int 类型数值)
 */
class BasicRectView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    constructor(context: Context?) : this(context, null)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 在画布中间绘制边长为 200 的矩形，填充类型为描边
        canvas.drawRect(width / 2 - 100f, height / 2 - 100f, width / 2 + 100f, height / 2 + 100f,
            Paint().apply {
                color = Color.RED
                strokeWidth = 15f
                style = Paint.Style.STROKE
            })

        val rect2 = RectF(width / 2 - 100f, height / 2 + 150f, width / 2 + 100f, height / 2 + 350f)
        canvas.drawRect(rect2,
            Paint().apply {
                color = Color.RED
                strokeWidth = 15f
                style = Paint.Style.FILL
            })


    }

}