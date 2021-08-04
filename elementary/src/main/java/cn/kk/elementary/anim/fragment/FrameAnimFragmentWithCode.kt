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
 * 代码方式 实现：
 */
class FrameAnimFragmentWithCode(animName: String): BaseFragment(animName) {

     lateinit  var viewRoot: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewRoot = inflater.inflate(R.layout.fragment_frame_anim_with_code, container, false)
        return viewRoot
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val frameAnim = AnimationDrawable()
        // 添加帧动画资源
        frameAnim.addFrame(resources.getDrawable(R.drawable.ic_arrow_up), 300)
        frameAnim.addFrame(resources.getDrawable(R.drawable.ic_arrow_right), 300)
        frameAnim.addFrame(resources.getDrawable(R.drawable.ic_arrow_down), 300)
        frameAnim.addFrame(resources.getDrawable(R.drawable.ic_arrow_left), 300)

        frameAnim.isOneShot = false


        // 设置动画
        viewRoot.findViewById<ImageView>(R.id.iv_frame_anim).apply {
            background = frameAnim
        }

        frameAnim.start()

    }

    override fun animTitle(title: String) {
       viewRoot.findViewById<TextView>(R.id.tv_anim_title).text = title
    }
}