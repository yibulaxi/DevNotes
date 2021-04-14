package cn.kk.customview.utils

import android.content.res.Resources
import android.util.TypedValue

class ValueUtil {

    companion object {
        fun dp2px(value: Float): Float {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                value,
                Resources.getSystem().displayMetrics
            )
        }

        fun dp2pxInt(value: Float): Int {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                value,
                Resources.getSystem().displayMetrics
            ).toInt()
        }
    }
}