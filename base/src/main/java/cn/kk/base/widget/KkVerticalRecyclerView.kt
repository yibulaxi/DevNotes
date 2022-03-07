package cn.kk.base.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

/**
 * 和 ViewPager2 搭配使用，处理滑动冲突。
 * 只有 竖直滑动 > 水平滑动 时，才拦截事件
 *
 * 实现方式：内部拦截法
 * 概念：父容器不拦截任何事件，所有的事件都传递给子元素，如果子元素需要此事件，就直接消耗掉，否则就交给父容器处理。要配合 requestDisallowInterceptTouchEvent() 使用
 * 1. 重写子元素的 dispatchTouchEvent() 方法
 * 2. MotionEvent.ACTION_DOWN 拦截
 * 3. MotionEvent.ACTION_MOVE 根据条件判断是否拦截
 * 4. MotionEvent.ACTION_UP 不拦截，交给父容器处理
 */
class KkVerticalRecyclerView(context: Context, attributeSet: AttributeSet?): RecyclerView(context, attributeSet) {
    val TAG = "KkRecyclerView"

    constructor(context: Context): this(context, null)


    var startX = 0f
    var startY = 0f
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {

        when(ev.action){
            MotionEvent.ACTION_DOWN -> {
                startX = ev.x
                startY = ev.y
                parent.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_MOVE -> {
                val diffX = ev.x - startX
                val diffY = ev.y - startY
                if (Math.abs(diffX) > Math.abs(diffY)){
                    // 水平滑动更多，
                    parent.requestDisallowInterceptTouchEvent(false)
                } else {
                    parent.requestDisallowInterceptTouchEvent(true)
                }
            }
            MotionEvent.ACTION_UP -> {
                parent.requestDisallowInterceptTouchEvent(false)
            }
        }

        return super.dispatchTouchEvent(ev)
    }
}