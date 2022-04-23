package cn.kk.customview.activity.more.audio

import androidx.core.content.ContextCompat
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_normal_image.*

class AudioBasicActivity: BaseActivity() {

    override fun getLayout(): Int = R.layout.activity_normal_image

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        image_view.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bg_audio_1))
    }
}