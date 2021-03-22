package cn.kk.customview.utils

import android.content.res.Resources
import android.util.TypedValue

class ValueUtil {
    fun dp2px(value: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            value,
            Resources.getSystem().displayMetrics
        )
    }
}