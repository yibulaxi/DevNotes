package cn.kk.elementary.drawview.advance

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * 贝塞尔曲线
 * 相关函数：quadTo(float x1, float y1, float x2, float y2), rQuadTo(), cubicTo(), rCubicTo()
 *
 * (x1, y1) 是控制点
 * (x2, y2) 是终点
 *
 */
class BezierView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRGB(200, 200, 200)

        val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.RED
        }
        val path = Path().apply {

        }
        // 1. 先走到起点
        path.moveTo(100f, 300f)

        // 2. 绘制第一段曲线
        path.quadTo(200f, 200f, 300f, 300f)

        // 3. 绘制第二段曲线
        path.quadTo(400f, 400f, 500f, 300f)

        canvas.drawPath(path, paint)
    }
}