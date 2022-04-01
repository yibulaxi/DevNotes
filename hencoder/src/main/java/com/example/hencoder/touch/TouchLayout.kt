package com.example.hencoder.touch

import android.content.Context
import android.util.AttributeSet
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
}