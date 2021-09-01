package cn.kk.base.utils

import android.graphics.drawable.GradientDrawable
import android.view.View

/**
 * 视图帮助类
 */
object ViewHelper {

    /**
     * 给控件设置背景，效果是两边是半圆
     * @param view 目标 view
     * @param color 背景 shape 颜色
     */
    fun setShapeDualSemicircle(view: View, color: Int){
        view.post {
            val height = view.measuredHeight
            view.background = GradientDrawable().apply {
                cornerRadius = height / 2f
                setColor(color)
            }
        }
    }
}