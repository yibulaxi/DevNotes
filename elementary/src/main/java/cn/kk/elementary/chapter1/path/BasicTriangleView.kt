package cn.kk.elementary.chapter1.path

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * Canvas 使用基础
 * 画路径- 三角形
 *
 * 1. 画直线
 * 2. 画三条直线 -> 三角形
 *
 * # 画直线(Path)
 * 1. moveTo
 * 2. lineTo
 * 3. close
 */
class BasicTriangleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    constructor(context: Context?): this(context,null)

    val paint = Paint().apply {
        color = Color.RED
        style = Paint.Style.STROKE
        strokeWidth = 5f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)


        val path = Path().apply {
            moveTo(10f,10f)
            lineTo(10f,200f)       // 第一条线
            lineTo(200f,200f)      // 第二条线
            close()                     // 闭环
        }

        canvas.drawPath(path,paint)

    }

}