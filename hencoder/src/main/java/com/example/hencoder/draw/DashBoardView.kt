package com.example.hencoder.draw

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import cn.kk.base.UIHelper
import com.example.hencoder.px

/**
 * 仪表盘
 *
 * 过程
 * 1. 确定绘制的区域（矩形），然后绘制圆弧形: canvas.drawArc()，注意：是顺时针绘制
 * 2. 绘制刻度(给 path 加效果，这里加的是虚线效果): Path.setPathEffect(PathDashPathEffect)
 * 3. 按照固定的刻度数调整刻度
 *      1. 测量圆弧长度: 修改绘制圆弧的方式，改用 path
 */

// region const fields
val RAIDUS = 150f.px
// 开口角度
const val OPEN_ANGLE = 120
// 刻度数
const val SCALE_COUNT = 20
 val DASH_LENGTH = 15f.px
 val DASH_WIDTH = 3f.px

// endregion

class DashBoardView(context: Context, attrs: AttributeSet?): View(context, attrs) {

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
            style = Paint.Style.STROKE
            color = Color.GRAY
            strokeWidth = UIHelper.dp2px(2f)

            // dash path config
            dashPath.addRect(0f, 0f, DASH_WIDTH, DASH_LENGTH, Path.Direction.CCW)
        }
    }
    // endregion

    // region override functions
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        archPath.reset()
        archPath.addArc(width / 2f - RAIDUS,
            height / 2f - RAIDUS,
            width / 2f + RAIDUS,
            height / 2f + RAIDUS,
            startAngle,
            endAngle)

        // measure arch length
        val archPathMeasure = PathMeasure(archPath, false)
        // 一个刻度的长度
        val scaleLength = (archPathMeasure.length - DASH_WIDTH) / SCALE_COUNT
        mPathEffect = PathDashPathEffect(dashPath, scaleLength, 0f, PathDashPathEffect.Style.ROTATE)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // step1 绘制 弧线
        drawMyArc(canvas)

        // step1 绘制 刻度
        applyPathDashEffect()
        drawMyArc(canvas)
        removePathDashEffect()
    }

    // endregion

    // region my functions
    /**
     * 以 view 中心为圆心，绘制自定义的弧线
     */
    private fun drawMyArc(canvas: Canvas) {
        canvas.drawPath(archPath, paint)
    }

    /**
     * 以特效（自己定义的虚线）绘制圆弧
     */
   private fun applyPathDashEffect() {
        /**
         * Android 估计是把这个概念弄反了
         * advance: 间隔
         * phase: 提前量
         */
        paint.pathEffect = mPathEffect
    }

    private fun removePathDashEffect(){
        paint.pathEffect = null
    }

    // endregion
}