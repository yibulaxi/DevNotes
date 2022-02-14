package cn.kk.customview.ui

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_lottie_anim.*

class LottieAnimActivity: BaseActivity() {

    val ANIM_LIKE = "ting_icon_knowledge_like.json"
    val ANIM_LIKE2 = "icon_like_2.json"
    val ANIM_VOICE = "icon_voice_wave.json"
    var loadProgress = 0f
    override fun getLayout(): Int {
      return  R.layout.activity_lottie_anim
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        lav.setAnimation(ANIM_VOICE)
        lav.progress = 0f

        lav.setOnClickListener {
            playAnim()
        }

    }

    private fun playAnim(){

        lav.playAnimation()
    }
}