package com.example.hencoder.touch

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * 知识点
 * 1. 触发点击：performClick()
 * 2. actionMasked 和 action
 *      0. action 多点触控引入后，建议用 actionMasked
 *      1. 早期没有 actionMasked，多点触控后引入的。建议用这个
 *      2. MotionEvent.ACTION_POINTER_DOWN: 非第一根手指按下
 *      3. MotionEvent.ACTION_POINTER_UP: 非第一根手指抬起
 *
 * 3. onTouchEvent() 分析
 *      1. clickable 状态：clickable 或者 long_clickable 或者 context_clickable
 *      2. view 即使为 disable，也要消费 event 的事件序列。避免事件穿透
 *      3. mTouchDelegate, 用来扩大 view 的点击区域。现在用的不多了
 *      4. ★★★
 *          4.1 属性：tooltipText: 解释性描述(长安后显示)。API 26 之后引入
 *          4.2 ShouldDelayChildPressedState(), 延迟 100ms 判断 子view 是否要滑动。
 *           那么如果自定义 ViewGroup 不需要滑动的话，就要重写这个方法，并且返回 false。见：[TouchLayout]
 *  4. 其他相关的自定义类：[TouchLayout]
 */
class TouchView(context: Context, attributeSet: AttributeSet?): View(context, attributeSet) {

    constructor(context: Context): this(context, null)


    override fun onTouchEvent(event: MotionEvent): Boolean {
        /*if (event.actionMasked == MotionEvent.ACTION_UP){
            // 手指抬起时，触发点击
            performClick()
        }*/
        return super.onTouchEvent(event)
    }
}