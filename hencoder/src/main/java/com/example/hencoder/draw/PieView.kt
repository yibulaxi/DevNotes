package com.example.hencoder.draw

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import cn.kk.base.UIHelper
import com.example.hencoder.px
import kotlin.math.cos
import kotlin.math.sin

/**
 * 饼图
 *
 * 过程
 * 1. 绘制圆弧，绘制多个。
 * 2. 偏移某块扇形: canvas.translate()
 */

class PieView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    constructor(context: Context): this(context, null)

    // region const fields
    private val RADIUS = 150f.px

    // 开口角度
    private val OPEN_ANGLE = 120

    private val ANGLES = floatArrayOf(30f, 80f, 100f, 150f)
    private val COLORS = listOf(Color.parseColor("#123123"), Color.parseColor("#321321"),
        Color.parseColor("#123456"), Color.parseColor("#654321"))

// endregion


    // region fields
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val startAngle: Float by lazy {
        90f + OPEN_ANGLE / 2
    }
    // endregion

    // region init
    init {
        paint.apply {
            style = Paint.Style.FILL
            color = Color.GRAY
            strokeWidth = UIHelper.dp2px(2f)

        }

    }
    // endregion

    // region override functions
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // step1 绘制 弧线

        var startAngle = 0f
        val offsetSector = 10f.px
        for ((index, angle) in ANGLES.withIndex()) {
            paint.color = COLORS[index]
            // 偏移第一个扇形
            if (index == 0) {
                val offsetSectorX = (offsetSector * cos(Math.toRadians(angle.toDouble() / 2))).toFloat()
                val offsetSectorY = (offsetSector * sin(Math.toRadians(angle.toDouble() / 2))).toFloat()
                canvas.translate(offsetSectorX, offsetSectorY)
                drawMyArc(canvas, startAngle, angle)
                canvas.translate(-offsetSectorX, -offsetSectorY)
            } else {

                drawMyArc(canvas, startAngle, angle)
            }
            startAngle += angle
        }


    }


    // endregion

    // region my functions
    /**
     * 以 view 中心为圆心，绘制自定义的弧线
     */
    private fun drawMyArc(canvas: Canvas, startAngle: Float, sweepAngle: Float) {
        canvas.drawArc(width / 2f - RADIUS, height / 2f - RADIUS,
            width / 2f + RADIUS, height / 2f + RADIUS,
            startAngle, sweepAngle, true, paint)
    }


    private fun removePathDashEffect() {
        paint.pathEffect = null
    }

    private fun markToRadians(mark: Int) =
        Math.toRadians(startAngle.toDouble() + (360 - OPEN_ANGLE) / 20F * mark)

    // endregion
}