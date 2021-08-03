package cn.kk.elementary.anim.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cn.kk.elementary.anim.fragment.RotateAnimFragment
import cn.kk.elementary.anim.fragment.ScaleAnimFragment
import cn.kk.elementary.anim.fragment.WaveAnimFragment

/**
 * 存放 fragment
 */
class AnimFragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    val fragments = mutableListOf<Fragment>()


    init {
        fragments.add(ScaleAnimFragment())
        fragments.add(RotateAnimFragment())
        fragments.add(WaveAnimFragment())
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}