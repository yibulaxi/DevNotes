package cn.kk.elementary.anim.fragment

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import cn.kk.elementary.R

/**
 * 逐帧动画
 *
 * XML 实现：
 * 1. 定义 xml 动画文件
 * 2. 设置 ImageView
 * 3. AnimationDrawable 开始动画
 *      用来创建一个逐帧动画，并且可以对帧进行拉伸。
 */
class FrameAnimFragment(animName: String): BaseFragment(animName) {

     lateinit  var viewRoot: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewRoot = inflater.inflate(R.layout.fragment_frame_anim, container, false)
        return viewRoot
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // 3. AnimationDrawable 开始动画
        viewRoot.findViewById<ImageView>(R.id.iv_frame_anim).apply {
            (drawable as AnimationDrawable).start()
        }

    }

    override fun animTitle(title: String) {
       viewRoot.findViewById<TextView>(R.id.tv_anim_title).text = title
    }
}