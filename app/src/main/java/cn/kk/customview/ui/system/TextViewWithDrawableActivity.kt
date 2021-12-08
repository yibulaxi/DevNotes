package cn.kk.customview.ui.system

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.widget.TextView
import androidx.core.content.ContextCompat
import cn.kk.base.UIHelper
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R


class TextViewWithDrawableActivity: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_textview_with_drawable
    }


    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        val tvRight = findViewById<TextView>(R.id.tv_right)

        resetPlayIcon(tvRight, Color.RED)
    }

    private fun resetPlayIcon(textView: TextView, filterColor: Int) {
        val drawable: Drawable? = ContextCompat.getDrawable(textView.context, R.drawable.icon_voice)
        if (drawable != null) {
            val iconSize: Int = UIHelper.dip2px(textView.context, 14.0)
            val paddingLeft: Int = UIHelper.dip2px(textView.context, 6.0)
            val minimumWidth = drawable.minimumWidth
            val minimumHeight = drawable.minimumHeight
            drawable.setBounds(0, 0, iconSize , iconSize)
            drawable.setColorFilter(filterColor, PorterDuff.Mode.SRC_ATOP)
            textView.setCompoundDrawables(drawable, null, null, null)
        }
    }
}