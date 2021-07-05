package cn.kk.customview.widget

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.annotation.FloatRange
import kotlin.math.max
import kotlin.math.min

/**
 * 两头是圆角的进度条
 */
class RoundCornerProgressBar @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0,
        defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    companion object {
        private const val DEFAULT_STROKE_WIDTH: Int = 0
        private const val DEFAULT_STROKE_COLOR: Int = 0xFFDAE1FE.toInt()
        private const val DEFAULT_PROGRESS_COLOR: Int = 0xFF6087DB.toInt()
    }

    private val strokePaint: Paint = Paint()
    private val progressPaint: Paint = Paint()
    private val solidPaint: Paint = Paint()
    private val progressPath: Path = Path()

    private var strokeWidth: Float = 0F
    private var strokeColor: Int = 0
    private var progressColor: Int = 0
    private var mSolidColor: Int = 0

    var vocabularyProgress: Float = 0F


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val radius: Float = height / 2F

        drawSolid(canvas, radius)

        drawProgress(canvas, radius)
    }

    private fun drawStroke(canvas: Canvas, radius: Float) {
        val left: Float = paddingStart + strokeWidth / 2
        val top: Float = strokeWidth / 2
        val right: Float = width - paddingEnd - strokeWidth / 2
        val bottom: Float = height - strokeWidth / 2

        canvas.drawRoundRect(left, top, right, bottom, radius, radius, strokePaint)
    }

    private fun drawProgress(canvas: Canvas, radius: Float) {
        canvas.save()

        val left: Float = strokeWidth + paddingStart
        val top: Float = strokeWidth
        val right: Float = (width - paddingStart - paddingEnd - strokeWidth * 2) * vocabularyProgress + left
        val bottom: Float = height - strokeWidth

        progressPath.reset()
        progressPath.addRect(
                left, top, right, bottom, Path.Direction.CW
        )
        canvas.clipPath(progressPath)

        canvas.drawRoundRect(
                left, top, if (right < radius * 2 + left) radius * 2 + left else right, bottom, radius, radius,
                progressPaint
        )

        canvas.restore()
    }

    private fun drawSolid(canvas: Canvas, radius: Float) {
        val left: Float = strokeWidth + paddingStart
        val top: Float = strokeWidth
        val right: Float = width - paddingStart - paddingEnd - strokeWidth * 2 + left
        val bottom: Float = height - strokeWidth

        progressPath.reset()
        progressPath.addRect(
                left, top, right, bottom, Path.Direction.CW
        )
        canvas.clipPath(progressPath)
        canvas.save()
        canvas.drawRoundRect(
                left, top, right, bottom, radius, radius,
                solidPaint
        )

        canvas.restore()
    }


    fun setProgress(@FloatRange(from = 0.0, to = 1.0) progress: Float) {
        this.vocabularyProgress = progress
        invalidate()
    }

    fun setSmoothProgress(@FloatRange(from = 0.0, to = 1.0) progress: Float, duration: Long = 1000) {
        val valueAnimator = ValueAnimator
                .ofFloat(this.vocabularyProgress, progress)
                .setDuration(duration)
        valueAnimator.addUpdateListener { animation ->
            setProgress(animation.animatedValue as Float)
        }
        valueAnimator.start()
    }

    fun dp2px(dpValue: Int): Int {
        return (dpValue * resources.displayMetrics.density).toInt()
    }

    /**
     * 给 color 添加透明度
     * @param alpha 透明度 0f～1f
     * @param baseColor 基本颜色
     * @return
     */
    fun getColorWithAlpha(alpha: Float, baseColor: Int): Int {
        val a = min(255, max(0, (alpha * 255).toInt())) shl 24
        val rgb = 0x00ffffff and baseColor
        return a + rgb
    }
}