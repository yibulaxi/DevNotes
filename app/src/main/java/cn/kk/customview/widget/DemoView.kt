package cn.kk.customview.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

class DemoView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : FrameLayout(context, attrs, defStyleAttr) {
    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null) : this(context, null, 0) {
    }

    fun initView() {}

    init {
        initView()
    }
}