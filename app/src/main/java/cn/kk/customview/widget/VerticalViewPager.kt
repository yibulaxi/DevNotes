package cn.kk.customview.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class VerticalViewPager(context: Context, attrs: AttributeSet?) : ViewPager(context, attrs) {
    var canSwipe = true

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        if (canSwipe) return true
        return false
    }
}