package com.example.hencoder.touch

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewGroup

/**
 * 不需要滚动的布局
 */
class TouchLayout(context: Context, attributeSet: AttributeSet?): ViewGroup(context, attributeSet) {

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

    }

    override fun shouldDelayChildPressedState(): Boolean {
        return false
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        // 根据需要拦截，默认不拦截
        val intercept = true
        if (intercept) return true
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }
}