package cn.kk.elementary.anim.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import cn.kk.elementary.R

/**
 * 动画示例：
 * 加载框效果
 */
class RotateAnimFragment(animTitle: String): BaseFragment(animTitle) {
     lateinit  var fragmentView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentView = inflater.inflate(R.layout.fragment_rotate_anim, container, false)
        return fragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // 播放伸缩动画
        // 播放缩放动画
       val rotateAnim = RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f).apply {
           duration = 1200
           repeatCount = Animation.INFINITE
           interpolator = LinearInterpolator()
       }

        val ivRotate = fragmentView.findViewById<ImageView>(R.id.iv_rotate)
        ivRotate.startAnimation(rotateAnim)
    }

    override fun animTitle(title: String) {
        fragmentView.findViewById<TextView>(R.id.tv_anim_title).text = title
    }
}