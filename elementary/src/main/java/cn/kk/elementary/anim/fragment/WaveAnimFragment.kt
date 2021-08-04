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
 * 微波效果
 */
class WaveAnimFragment(animName: String): BaseFragment(animName) {
     lateinit  var fragmentView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentView = inflater.inflate(R.layout.fragment_wave_anim, container, false)
        return fragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // 播放组合动画
        val waveAnim1 = AnimationUtils.loadAnimation(context, R.anim.wave_anim)
        val waveAnim2 = AnimationUtils.loadAnimation(context, R.anim.wave_anim)
        val waveAnim3 = AnimationUtils.loadAnimation(context, R.anim.wave_anim)
        val waveAnim4 = AnimationUtils.loadAnimation(context, R.anim.wave_anim)

        val ivCircle1 = fragmentView.findViewById<ImageView>(R.id.iv_circle_1)
        val ivCircle2 = fragmentView.findViewById<ImageView>(R.id.iv_circle_2)
        val ivCircle3 = fragmentView.findViewById<ImageView>(R.id.iv_circle_3)
        val ivCircle4 = fragmentView.findViewById<ImageView>(R.id.iv_circle_4)

        // 间隔播放动画，间隔 600ms
        val delay = 600L
        ivCircle1.startAnimation(waveAnim1)

        waveAnim2.startOffset = delay
        ivCircle2.startAnimation(waveAnim2)

        waveAnim3.startOffset = delay
        ivCircle3.startAnimation(waveAnim3)

        waveAnim4.startOffset = delay
        ivCircle4.startAnimation(waveAnim4)
    }

    override fun animTitle(title: String) {
        fragmentView.findViewById<TextView>(R.id.tv_anim_title).text = title
    }
}