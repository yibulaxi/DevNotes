package cn.kk.customview

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.addListener
import androidx.core.animation.doOnEnd
import kotlinx.android.synthetic.main.activity_immersive_mode.*

/**
 * 沉浸式模式
 * [郭霖博客文章](https://mp.weixin.qq.com/s/CjFUKHIz6bQZaKw46Lj7VQ)
 */
class ImmersiveModeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_immersive_mode)
        // 两个 Flag 结合使用，表示让应用主题内容占用系统状态栏的空间
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        // 设置系统状态栏颜色为透明
        window.statusBarColor = Color.TRANSPARENT


        val anim1 = ObjectAnimator.ofFloat(iv_avatar, "rotationY", -10f, 10f)
        val anim2 = ObjectAnimator.ofFloat(iv_avatar, "rotationY", 10f, -10f)

        val animSet = AnimatorSet().apply {
            playSequentially(anim1, anim2)
            duration = 1500
        }

        animSet.addListener(object: Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                animSet.start()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationRepeat(animation: Animator?) {
            }

        })
        animSet.start()

    }
}