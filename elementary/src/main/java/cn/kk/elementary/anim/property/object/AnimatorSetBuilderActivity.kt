package cn.kk.elementary.anim.property.`object`

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import cn.kk.base.activity.BaseActivity
import cn.kk.elementary.R
import kotlinx.android.synthetic.main.activity_animator_set_builder.*
import kotlinx.android.synthetic.main.btn_circle.*

/**
 * 3.5.2 AnimatorSet.Builder
 * play()
 * with()
 * before()
 * after()
 */
class AnimatorSetBuilderActivity: BaseActivity() {
    override fun getLayout(): Int = R.layout.activity_animator_set_listener

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // region 1. 定义多个动画
        val animCircle1Trans = ObjectAnimator.ofFloat(circle1, "translationY", 0f, 1200f)
        val animCircle2Trans = ObjectAnimator.ofFloat(circle2, "translationY", 0f, 1200f)
        val animCircle3Trans = ObjectAnimator.ofFloat(circle3, "translationY", 0f, 1200f)


        btn_play.setOnClickListener {
            val animatorSet = AnimatorSet()

            // animCircle1Trans 和 animCircle3Trans 一起执行，然后再执行 animCircle2Trans
            animatorSet.
            play(animCircle1Trans)
                .with(animCircle3Trans)
                .before(animCircle2Trans)

            animatorSet.start()
        }
    }
}