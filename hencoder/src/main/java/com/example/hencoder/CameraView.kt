package com.example.hencoder

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

private val BITMAP_SIZE = 200f.px
private val BITMAP_PADDING = 100f.px

/**
 * canvas.clipRect()
 * canvas.clipPath()
 */
class CameraView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    constructor(context: Context): this(context, null)

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvatar(BITMAP_SIZE.toInt())
    private val camera = Camera()

    init {
        camera.rotateX(30f)
        camera.setLocation(0f,0f,-6 * resources.displayMetrics.density)

    }

    private val clipPath = Path().apply {
        addOval(
            BITMAP_PADDING, BITMAP_PADDING, BITMAP_PADDING + BITMAP_SIZE ,
                BITMAP_PADDING + BITMAP_SIZE ,Path.Direction.CCW)
    }

    override fun onDraw(canvas: Canvas) {

       /* canvas.clipRect(BITMAP_PADDING, BITMAP_PADDING, BITMAP_PADDING + BITMAP_SIZE * 0.8f,
        BITMAP_PADDING + BITMAP_SIZE * 0.8f)
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING,paint)*/

        // 上半部分
        canvas.save()
        canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
        canvas.rotate(-30f)
        canvas.clipRect(- BITMAP_SIZE, - BITMAP_SIZE, BITMAP_SIZE, 0f)
        canvas.rotate(30f)
        canvas.translate(- (BITMAP_PADDING + BITMAP_SIZE / 2), - (BITMAP_PADDING + BITMAP_SIZE / 2))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        canvas.restore()

        // 下半部分
        canvas.save()
        canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
        canvas.rotate(-30f)
        camera.applyToCanvas(canvas)
        canvas.clipRect(- BITMAP_SIZE, 0f, BITMAP_SIZE, BITMAP_SIZE)
        canvas.rotate(30f)
        canvas.translate(- (BITMAP_PADDING + BITMAP_SIZE / 2), - (BITMAP_PADDING + BITMAP_SIZE / 2))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        canvas.restore()
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