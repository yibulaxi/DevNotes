package cn.kk.customview.activity.more.audio

import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.content.ContextCompat
import cn.kk.customview.R
import cn.kk.customview.ui.fragment.NormalViewFragment

/**
 * 声音是如何保存成数字信号的
 */
class AudioBasic1Fragment: NormalViewFragment() {
    var imgRes: Int = -1
    override fun getMyView(): View {
        val imageView = ImageView(context).apply {
            // match parent
            layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
            // bg color
            setBackgroundColor(ContextCompat.getColor(context, R.color.gray))
            // src img
            if (imgRes != -1) {
                setImageDrawable(ContextCompat.getDrawable(context, imgRes))
            }
        }
        return imageView
    }
}