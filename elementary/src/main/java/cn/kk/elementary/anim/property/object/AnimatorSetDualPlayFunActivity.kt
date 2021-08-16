package cn.kk.elementary.anim.property.`object`

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.core.animation.doOnEnd
import cn.kk.base.activity.BaseActivity
import cn.kk.elementary.R
import kotlinx.android.synthetic.main.activity_animator_set_dual_play_fun.*
import kotlinx.android.synthetic.main.btn_circle.*

/**
 * 组合动画
 * playSequentially() 与 playTogether() 函数
 */
class AnimatorSetDualPlayFunActivity: BaseActivity() {
    override fun getLayout(): Int = R.layout.activity_animator_set_dual_play_fun
    var viewsState = true

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // region 1. 定义多个动画
        val animCircle1Trans = ObjectAnimator.ofFloat(circle1, "translationY", 0f, 1200f)
        val animCircle2Trans = ObjectAnimator.ofFloat(circle2, "translationY", 0f, 1200f)
        val animCircle3Trans = ObjectAnimator.ofFloat(circle3, "translationY", 0f, 1200f)

        val animSet = AnimatorSet().apply {
            playSequentially(animCircle1Trans, animCircle2Trans, animCircle3Trans)
            duration = 500
            doOnEnd { viewsState = false }

        }

        val animCircle1TransR = ObjectAnimator.ofFloat(circle1, "translationY", 1200f, 0f)
        val animCircle2TransR = ObjectAnimator.ofFloat(circle2, "translationY", 1200f, 0f)
        val animCircle3TransR = ObjectAnimator.ofFloat(circle3, "translationY", 1200f, 0f)
        val animSetTogether = AnimatorSet().apply {
            playTogether(animCircle1TransR, animCircle2TransR, animCircle3TransR)
            duration = 200
            doOnEnd { viewsState = true }
        }

         // endregion


        // region 点击，播放动画
        btn_play.setOnClickListener {
            if (viewsState) {
                animSet.start()
            } else {
                animSetTogether.start()
            }

        }
        // endregion
    }
}