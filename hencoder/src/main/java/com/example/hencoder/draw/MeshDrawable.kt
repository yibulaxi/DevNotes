package com.example.hencoder.draw

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import androidx.core.graphics.toColorInt
import com.example.hencoder.dp

/**
 * 绘制网格
 */
val INTERVAL = 50.dp

class MeshDrawable: Drawable() {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = "#F9A825".toColorInt()
        strokeWidth = 3.dp
    }

    override fun draw(canvas: Canvas) {
        // step1 绘制竖线
        var x = bounds.left.toFloat()
        while ( x <= bounds.right) {
            canvas.drawLine(x, bounds.top.toFloat(), x, bounds.bottom.toFloat(), paint)
            x += INTERVAL
        }

        // step2 绘制横线
        var y = bounds.top.toFloat()
        while ( y <= bounds.bottom.toFloat()) {
            canvas.drawLine(bounds.left.toFloat(), y, bounds.right.toFloat(), y, paint)
            y += INTERVAL
        }
    }

    override fun setAlpha(alpha: Int) {
       paint.alpha = alpha
    }

    override fun getAlpha(): Int {
        return paint.alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getColorFilter(): ColorFilter? {
        return paint.colorFilter
    }

    override fun getOpacity(): Int {
        // 不透明度
        return when(paint.alpha){
            0 -> PixelFormat.TRANSPARENT
            0xff -> PixelFormat.OPAQUE
            else -> PixelFormat.TRANSLUCENT
        }
    }
}