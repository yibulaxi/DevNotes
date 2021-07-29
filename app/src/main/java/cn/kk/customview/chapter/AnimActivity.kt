package cn.kk.customview.chapter

import android.os.Bundle
import android.os.PersistableBundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_anim.*

/**
 * 动画的一些列子
 */
class AnimActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim)

        btn_scale_play.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this, R.anim.scale_anim)
            tv_scale_anim.startAnimation(anim)
        }
    }
}