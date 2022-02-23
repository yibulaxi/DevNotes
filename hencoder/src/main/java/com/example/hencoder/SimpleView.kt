package com.example.hencoder

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View


/**
 * 知识点
 * 1. Float 扩展
 * 2. dp to px 转换
 * 3. onDraw()
 * 4. canvas.drawLine()
 * 5. canvas.drawCircle()
 * 6. canvas?.drawPath()
 *      1. path 对象需要初始化，在 view 尺寸变化时候操作：重写 onSizeChanged() 方法
 */
class SimpleView(context: Context?, attrs: AttributeSet?): View(context) {
    val RADIIUS = 100f.px
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paintForPath = Paint()
    private val path = Path()

    init {
        paintForPath.color = Color.BLUE
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        path.reset()
        // 圆心在 view 中心位置，
        // 绘制方向：控制 相交部分的区域是否应该填充
        // 绘制方向：Path.Direction.CCW（顺时针 counter-clockwise）
        // 绘制方向：Path.Direction.CW（顺时针 clockwise）

        // add circle path
        path.addCircle(width / 2f, height / 2f, RADIIUS, Path.Direction.CCW)

        // add rect path
        path.addRect(width / 2f - RADIIUS, height / 2f, width / 2f + RADIIUS, height / 2f + 2 * RADIIUS, Path.Direction.CW)

    }

    override fun onDraw(canvas: Canvas?) {

        // region 绘制 line
        canvas?.drawLine(100f, 100f, 500f, 100f, paint)
        // endregion

        // region 绘制圆
//        canvas?.drawCircle(width / 2f, height / 2f , RADIIUS, paint)
        // endregion

        // region 绘制圆，用 drawPath()
        canvas?.drawPath(path, paintForPath)
        // endregion

    }
}