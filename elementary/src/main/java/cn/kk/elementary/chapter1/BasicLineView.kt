package cn.kk.elementary.chapter1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Canvas 使用基础
 * 画直线
 */
class BasicLineView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    constructor(context: Context?): this(context,null)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawLine(100f,100f,200f,200f, Paint().apply {
            color = Color.RED
            style = Paint.Style.FILL_AND_STROKE
            strokeWidth = 50f
        })
    }

}