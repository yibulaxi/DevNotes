package cn.kk.elementary.anim.view

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import cn.kk.elementary.R
import cn.kk.elementary.anim.adapter.AnimFragmentAdapter
import kotlinx.android.synthetic.main.activity_anim_samples.*

/**
 * 动画示例：
 * 1. 镜头由远及近效果
 * 2. 加载动画
 * 3. 水波纹动画
 * 4. 逐帧动画
 */
class AnimSampleActivity: FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_anim_samples)

        anim_sample_viewpager?.adapter = AnimFragmentAdapter(this)
    }
}