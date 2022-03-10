package com.example.hencoder.draw

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import cn.kk.base.UIHelper
import com.example.hencoder.px

/**
 * 仪表盘
 *
 * 过程
 * 1. 确定绘制的区域（矩形），然后绘制圆弧形: canvas.drawArc()，注意：是顺时针绘制
 * 2. 绘制刻度: Path.setPathEffect(PathDashPathEffect)
 * 3.
 */
val RAIDUS = 150f.px
// 开口角度
const val OPEN_ANGLE = 120
 val dash_length = 15f.px
 val dash_width = 3f.px

class DashBoardView(context: Context, attrs: AttributeSet?): View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val startAngle: Float by lazy {
        90f + OPEN_ANGLE / 2
    }
    private val endAngle: Float by lazy {
        360f - OPEN_ANGLE
    }

    init {
        paint.apply {
            style = Paint.Style.STROKE
            color = Color.GRAY
            strokeWidth = UIHelper.dp2px(2f)
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawArc(width / 2f - RAIDUS, height / 2f - RAIDUS, width / 2f + RAIDUS, height/ 2f  + RAIDUS,
        startAngle, endAngle, false, paint)
    }

}