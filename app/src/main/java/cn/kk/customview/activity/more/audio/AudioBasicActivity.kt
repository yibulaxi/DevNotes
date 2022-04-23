package cn.kk.customview.activity.more.audio

import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import cn.kk.customview.R
import cn.kk.customview.activity.BaseTabActivity
import cn.kk.customview.ui.fragment.NormalViewFragment

class AudioBasicActivity: BaseTabActivity() {

    override fun getLayout(): Int = R.layout.activity_normal_tab

    override fun MutableList<Fragment>.addFragments() {
        add(AudioBasicFragment().apply { imgRes = R.drawable.bg_audio_1 })
    }

    class AudioBasicFragment: NormalViewFragment() {
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
}