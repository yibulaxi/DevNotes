package cn.kk.customview.chapter.c3

import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.elementary.anim.adapter.BaseFragmentAdapter
import cn.kk.elementary.drawview.fragment.HardwareAccelerateFragment
import cn.kk.elementary.drawview.fragment.PaintFunsFragment
import cn.kk.elementary.drawview.fragment.PaintTextFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_paint.*

/**
 * Paint 基本使用
 */
class PaintActivity: BaseActivity() {
    val sections = arrayOf("硬件加速", "文字", "Paint 常用函数")
    override fun getLayout(): Int = R.layout.activity_paint

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        // 适配器，添加 Fragment
        viewPager.adapter = BaseFragmentAdapter(this, mutableListOf<Fragment>().apply {
            add(HardwareAccelerateFragment())
            add(PaintTextFragment())
            add(PaintFunsFragment())
        })

        TabLayoutMediator(tl_paint, viewPager) { tab, position -> tab.text = sections[position] }.attach()

    }
}