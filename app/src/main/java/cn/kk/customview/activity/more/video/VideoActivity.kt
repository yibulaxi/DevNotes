package cn.kk.customview.activity.more.video

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.activity.more.audio.AudioHomeFragment

/**
 * 视频知识学习
 */
class VideoActivity: BaseActivity() {

    override fun getLayout() = R.layout.activity_video

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, VideoHomeFragment()).commit()
    }
}