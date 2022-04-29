package cn.kk.customview.activity.more

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.activity.more.audio.AudioHomeFragment

/**
 * 音频知识学习
 */
class AudioActivity: BaseActivity() {

    override fun getLayout() = R.layout.activity_audio

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, AudioHomeFragment()).commit()
    }
}