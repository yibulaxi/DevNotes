package com.example.hencoder

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import cn.kk.base.UIHelper

const val RADIIUS = 100f
class SimpleView(context: Context?, attrs: AttributeSet?): View(context) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas?) {

        // 绘制 line
        canvas?.drawLine(100f, 100f, 500f, 100f, paint)

        // 绘制圆
        canvas?.drawCircle(width / 2f, height / 2f , UIHelper.dp2px(RADIIUS).toFloat(), paint)

    }
}