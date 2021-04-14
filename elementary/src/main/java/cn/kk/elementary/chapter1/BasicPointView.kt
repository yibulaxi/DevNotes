package cn.kk.elementary.chapter1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Canvas 使用基础
 * 画点
 */
class BasicPointView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    constructor(context: Context?): this(context,null)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawPoint(width / 2f,height / 2f,Paint().apply {
            color = Color.RED
            strokeWidth = 15f
        })
    }

}