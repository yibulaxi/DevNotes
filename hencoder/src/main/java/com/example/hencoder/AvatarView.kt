package com.example.hencoder

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class AvatarView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    constructor(context: Context) : this(context, null)

    private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bound: RectF = RectF()
    private val PORTERDUFF = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    private val AVATAR_WIDTH = 600
    private val MARGIN_LEFT = 100f.px
    private val MARGIN_TOP = 200f.px

    init {
        bound.left = MARGIN_LEFT
        bound.top = MARGIN_TOP
        bound.right = MARGIN_LEFT + AVATAR_WIDTH
        bound.bottom = MARGIN_TOP + AVATAR_WIDTH
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //step0 绘制缓冲区
        val saveLayer = canvas.saveLayer(bound, paint)

        //step1 绘制圆圈
        canvas.drawOval(bound, paint)
        paint.xfermode = PORTERDUFF

        //step2 绘制 bitmap
        canvas.drawBitmap(getAvatar(AVATAR_WIDTH), MARGIN_LEFT, MARGIN_TOP, paint)

        //step3 恢复
        paint.xfermode = null
        canvas.restoreToCount(saveLayer)
    }

    private fun getAvatar(width: Int): Bitmap {
        var options: BitmapFactory.Options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian, options)
    }
}