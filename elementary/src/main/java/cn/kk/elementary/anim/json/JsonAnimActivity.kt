package cn.kk.elementary.anim.json

import android.os.Bundle
import cn.kk.base.activity.BaseActivity
import cn.kk.elementary.R
import kotlinx.android.synthetic.main.activity_anim_json.*

/**
 * 动画
 * 使用 LottieAnimationView 播放 Json 格式的 After Effects 动画
 */
class JsonAnimActivity: BaseActivity() {

    var count = 0
    val anims = arrayOf("home.json", "ting.json", "learn.json", "account.json")

    override fun getLayout(): Int = R.layout.activity_anim_json

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        btn_play.setOnClickListener {
            lottieAnim.setAnimation(anims[count++ % 4])
            lottieAnim.playAnimation()

        }
    }
}