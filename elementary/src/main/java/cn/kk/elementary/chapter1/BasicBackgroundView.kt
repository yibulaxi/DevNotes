package cn.kk.elementary.chapter1

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

/**
 * Canvas 使用基础
 * 画布背景
 */
class BasicBackgroundView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    constructor(context: Context?): this(context,null)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawRGB(255,0,255)
    }

}