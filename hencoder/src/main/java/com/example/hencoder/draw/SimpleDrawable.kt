package com.example.hencoder.draw

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.View

/**
 * 写一个简单的 Drawable
 */
class SimpleDrawable(context: Context, attributeSet: AttributeSet?) : View(context, attributeSet) {

    constructor(context: Context) : this(context, null)

    private val drawable = MeshDrawable()

    override fun onDraw(canvas: Canvas) {

        // 设置边界，因为边界默认是 0
        drawable.setBounds(0, 0, width, height)

        drawable.draw(canvas)
    }

}
