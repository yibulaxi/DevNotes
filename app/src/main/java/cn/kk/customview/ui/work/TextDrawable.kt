package cn.kk.customview.ui.work

import android.content.res.Resources
import android.graphics.*
import android.util.TypedValue

import android.graphics.Paint.Align
import android.graphics.drawable.GradientDrawable


class TextDrawable(res: Resources, text: String,val size: Int): GradientDrawable() {

    private val DEFAULT_COLOR: Int = Color.WHITE
    private val DEFAULT_TEXTSIZE = 15
    private var mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mBgPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mText: String? = null
    private var mIntrinsicWidth = 0
    private var mIntrinsicHeight = 0

    init {
        shape = RECTANGLE
        mText = text
        mBgPaint.setColor(Color.BLUE)
        mPaint.setColor(DEFAULT_COLOR)
        mPaint.setTextAlign(Align.CENTER)
        val textSize: Float = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            DEFAULT_TEXTSIZE.toFloat(), res.getDisplayMetrics()
        )
        mPaint.setTextSize(textSize)
        mIntrinsicWidth = ((mPaint.measureText(mText, 0, mText!!.length) + 0.5).toInt())
        mIntrinsicHeight = mPaint.getFontMetricsInt(null)

        cornerRadius = size / 2f
        setColor(Color.RED)
    }

    override fun draw(canvas: Canvas) {
        canvas.drawARGB(130, 200, 100, 80)
        canvas.drawText(mText!!, 0, mText!!.length, bounds.centerX().toFloat(), bounds.centerY().toFloat(), mPaint)
    }

    override fun getIntrinsicWidth(): Int {
        return mIntrinsicWidth
    }

    override fun getIntrinsicHeight(): Int {
        return mIntrinsicHeight
    }

    override fun setAlpha(alpha: Int) {
        mPaint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        mPaint.colorFilter = colorFilter
    }

    override fun getOpacity(): Int {
        return  mPaint.alpha
    }
}