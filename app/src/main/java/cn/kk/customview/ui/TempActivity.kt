package cn.kk.customview.ui

import android.graphics.Color
import android.os.Handler
import android.os.SystemClock
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_temp.*

class TempActivity: BaseActivity() {

    val ANIM_LIKE = "ting_icon_knowledge_like.json"
    val ANIM_LIKE2 = "icon_like_2.json"
    var loadProgress = 0f
    override fun getLayout(): Int {
      return  R.layout.activity_temp
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        lav.setAnimation(ANIM_LIKE2)
        lav.progress = 0f

        lav.setOnClickListener {
            playAnim()
        }

    }

    private fun playAnim(){

        lav.playAnimation()
    }
}