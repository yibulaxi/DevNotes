package com.example.hencoder.draw

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
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
    private val TAG = "PieView"
    constructor(context: Context): this(context, null)

    // region const fields
    private val RADIUS = 150f.px
    private var focusSectorIndex = -1

    private val ANGLES = floatArrayOf(30f, 80f, 100f, 150f)
    private val COLORS = listOf(Color.parseColor("#123123"), Color.parseColor("#321321"),
        Color.parseColor("#123456"), Color.parseColor("#654321"))

// endregion


    // region fields
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
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
        var tempAngle = 0f
        for ((index, angle) in ANGLES.withIndex()) {
            paint.color = COLORS[index]
            // 偏移第一个扇形
            // 扇形的中轴线的角度
            tempAngle = startAngle + angle / 2
            if (index == focusSectorIndex) {
                val offsetSectorX = (offsetSector * cos(Math.toRadians(tempAngle.toDouble()))).toFloat()
                val offsetSectorY = (offsetSector * sin(Math.toRadians(tempAngle.toDouble()))).toFloat()
                canvas.translate(offsetSectorX, offsetSectorY)
                drawMyArc(canvas, startAngle, angle)
                canvas.translate(-offsetSectorX, -offsetSectorY)
            } else {

                drawMyArc(canvas, startAngle, angle)
            }
            startAngle += angle
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action){
            MotionEvent.ACTION_DOWN -> {

                return true
            }
            MotionEvent.ACTION_UP -> {
                // 计算按下的点是在哪个扇形里

                // step1: 相对于圆形的坐标
                val touchX = event.x - width / 2.0
                val touchY = event.y - height / 2.0
                val touchAngleRadians = Math.atan(touchY / touchX)
                // 范围：-90 ~ 90
                val touchAngle = Math.toDegrees(touchAngleRadians)

                // step2: 触摸点到圆形连线，与坐标轴（x轴）的夹角根据象限，纠正角度
                var correctAngle = 0.0
                if (touchX >= 0 && touchY >= 0) {
                    // 第四象限
                    correctAngle = touchAngle
                } else if (touchX < 0 && touchY >= 0) {
                    // 第三象限
                    correctAngle = 90 + (90 + touchAngle)
                } else if (touchX < 0 && touchY < 0) {
                    // 第二象限
                    correctAngle = 180 + touchAngle
                } else if (touchX >= 0 && touchY < 0) {
                    // 第一象限
                    correctAngle = 360 + touchAngle
                }
                Log.d(TAG, "onTouchEvent: touchAngle: ${touchAngle}")
                Log.d(TAG, "onTouchEvent: correctAngle: ${correctAngle}")

                // step3: 根据角度，计算属于哪个扇形
                var sectorIndex = 0
                for ((index, angle) in ANGLES.withIndex()){
                    correctAngle -= angle
                    if (correctAngle <= 0) {
                        sectorIndex = index
                        break
                    }
                }
                focusSectorIndex = sectorIndex
                invalidate()
                return true
            }
        }
        return super.onTouchEvent(event)
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

    // endregion
}