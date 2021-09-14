package cn.kk.base.utils

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.View


/**
 * 视图帮助类
 */
object ViewHelper {

    /**
     * 给控件设置背景，效果是两边是半圆
     * @param target 目标 view
     * @param color 背景 shape 颜色
     */
    fun setShapeDualSemicircle(target: View, color: Int, alpha: Float){
        val correctAlpha = Math.min(Math.max(0f, alpha), 1.0f)
        target.post {
            target.background = GradientDrawable().apply {
                cornerRadius = target.measuredHeight / 2f
                val blue: Float = Color.blue(color).toFloat()
                val red: Float = Color.red(color).toFloat()
                val green: Float = Color.green(color).toFloat()
                var aColor = -1
                (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    Color.argb(correctAlpha, red, green, blue) else {
                    val alphaInt = (correctAlpha * 255.0f + 0.5f).toInt()
                    color and 0x00ffffff or (alphaInt shl 24)
                }).also { aColor = it }
                setColor(aColor)
            }

        }
    }

}