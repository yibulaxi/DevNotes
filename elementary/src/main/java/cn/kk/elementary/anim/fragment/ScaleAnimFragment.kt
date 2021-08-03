package cn.kk.elementary.anim.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import androidx.fragment.app.Fragment
import cn.kk.elementary.R

/**
 * 动画示例：
 * 镜头由远及近效果
 */
class ScaleAnimFragment: Fragment() {
     lateinit  var fragmentView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentView = inflater.inflate(R.layout.fragment_scale_anim, container, false)
        return fragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // 播放伸缩动画
        // 播放缩放动画
        val scaleAnimation = ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f).apply {
            duration = 4000
            fillAfter = true
            interpolator = BounceInterpolator()
        }

        val ivScale = fragmentView.findViewById<ImageView>(R.id.iv_scale)
        ivScale.startAnimation(scaleAnimation)
    }
}