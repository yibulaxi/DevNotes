package com.example.hencoder.draw

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import cn.kk.base.UIHelper
import com.example.hencoder.px

/**
 * 饼图
 *
 * 过程
 * 1. 确定绘制的区域（矩形），然后绘制圆弧形: canvas.drawArc()，注意：是顺时针绘制
 */

class PieView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    constructor(context: Context): this(context, null)

    // region const fields
    private val RADIUS = 150f.px

    // 开口角度
    private val OPEN_ANGLE = 120

    // 刻度数
    private val SCALE_COUNT = 20
    private val DASH_LENGTH = 15f.px
    private val DASH_WIDTH = 3f.px



// endregion


    // region fields
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val archPath = Path()
    private val dashPath = Path()
    private val startAngle: Float by lazy {
        90f + OPEN_ANGLE / 2
    }
    private val endAngle: Float by lazy {
        360f - OPEN_ANGLE
    }
    private lateinit var mPathEffect: PathDashPathEffect
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
        drawMyArc(canvas)


    }


    // endregion

    // region my functions
    /**
     * 以 view 中心为圆心，绘制自定义的弧线
     */
    private fun drawMyArc(canvas: Canvas) {
        canvas.drawPath(archPath, paint)
        canvas.drawArc(width / 2f - RADIUS, height / 2f - RADIUS,
            width / 2f + RADIUS, height / 2f + RADIUS,
            0f, 60f, true, paint)
    }


    private fun removePathDashEffect() {
        paint.pathEffect = null
    }

    private fun markToRadians(mark: Int) =
        Math.toRadians(startAngle.toDouble() + (360 - OPEN_ANGLE) / 20F * mark)

    // endregion
}