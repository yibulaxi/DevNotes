package cn.kk.elementary.anim.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cn.kk.elementary.anim.fragment.*

/**
 * 存放 fragment
 */
class AnimFragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    val fragments = mutableListOf<Fragment>()


    init {
        fragments.add(ScaleAnimFragment("由远及近动画"))
        fragments.add(RotateAnimFragment("加载动画"))
        fragments.add(WaveAnimFragment("水波纹动画"))
        fragments.add(FrameAnimFragment("逐帧动画 XML 方式"))
        fragments.add(FrameAnimFragmentWithCode("逐帧动画代码方式"))
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}