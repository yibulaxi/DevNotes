package cn.kk.customview.chapter

import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_anim_interpolator.*

/**
 * 动画插值器
 */
class AnimInterpolatorActivity: AppCompatActivity() {

    val animList = arrayListOf<Animation>()
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim_interpolator)

        val alphaInterpolatorAnim = AnimationUtils.loadAnimation(this, R.anim.alpha_linear_interpolator_anim)
        val transInterpolatorAnim = AnimationUtils.loadAnimation(this, R.anim.trans_interpolator_anim)

        val transInterpolatorAnim2 = TranslateAnimation(0f, 900f, 0f, 0f).apply {
            duration = 1000
            fillAfter = true
            interpolator = AccelerateDecelerateInterpolator()
        }

        animList.add(alphaInterpolatorAnim)
        animList.add(transInterpolatorAnim)
        animList.add(transInterpolatorAnim2)

        btn_play.setOnClickListener {

            val curAnim = animList[(count++) % animList.size]
            viewBlock.startAnimation(curAnim)
        }
    }
}