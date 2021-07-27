package cn.kk.elementary.chapter1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import cn.kk.elementary.R

/**
 * 画笔 Paint 基本使用
 * 1. onDraw() 中画圆
 * 2. Paint 基本设置
 *  1. style: Paint.Style.STROKE, Paint.Style.FILL, Paint.Style.FILL_AND_STROKE
 *  2. color
 *  3. strokeWidth
 */
class BasicCircleRingView : View {

    var bodyColor: Int = Color.BLACK
    var bodyRadius: Float = 0f
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var mStrokeWidth = 1f

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet){
        // 获取自定义属性
        val styleAttrs = context.obtainStyledAttributes(attributeSet, R.styleable.BasicCircleRingView)

        bodyColor = styleAttrs.getColor(R.styleable.BasicCircleRingView_circle_color, Color.BLACK)
        bodyRadius = styleAttrs.getDimension(R.styleable.BasicCircleRingView_circle_raidus, 0f)
        when (styleAttrs.getInt(R.styleable.BasicCircleRingView_fill_type,1)) {
            1 -> { paint.style = Paint.Style.FILL }
            2 -> paint.style = Paint.Style.STROKE
            else -> {
                paint.style = Paint.Style.FILL_AND_STROKE
            }
        }
        mStrokeWidth = styleAttrs.getDimension(R.styleable.BasicCircleRingView_stroke_width,1f)
        styleAttrs.recycle()
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    )


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 画布颜色
        val aColor = 200
        val rColor = 120
        val gColor = 140
        val bColor = 180
        canvas.drawARGB(aColor,rColor,gColor,bColor)

        // 设置画笔
        paint.apply {
            color = Color.argb(0xff, 0xff, 0x00, 0x00)
            strokeWidth = mStrokeWidth        // 画笔宽度
        }
        val centX = width / 2f
        val centY = height / 2f
        if (bodyRadius == 0f || bodyRadius > centX || bodyRadius > centY){
            bodyRadius = Math.min(width, height) / 2f
        }

        // 画圆环
        val radius = Math.min(width, height) / 2f - 200
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 80f
        canvas.drawCircle(centX, centY, radius, paint)


    }
}