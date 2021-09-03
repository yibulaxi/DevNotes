package cn.kk.customview.chapter.c3

import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.elementary.anim.adapter.BaseFragmentAdapter
import cn.kk.elementary.drawview.fragment.BezierFragment
import cn.kk.elementary.drawview.fragment.HardwareAccelerateFragment
import cn.kk.elementary.drawview.fragment.PaintFunsFragment
import cn.kk.elementary.drawview.fragment.PaintTextFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_draw_advance.*
import kotlinx.android.synthetic.main.activity_paint.*

/**
 * 绘图进阶
 * 7.1 贝塞尔曲线
 * 7.2 setShadowLayer 与阴影效果
 * 7.3 BlurMaskFilter 发光效果与图片阴影
 * 7.4 Shader 与 BitmapShader
 * 7.5 Shader 之 LinearGradient
 * 7.6 Shader 之 RadialGradient
 */
class DrawAdvanceActivity: BaseActivity() {
    val sections = arrayOf("贝塞尔曲线", "setShadowLayer 与阴影效果", "BlurMaskFilter 发光效果与图片阴影", "Shader")
    override fun getLayout(): Int = R.layout.activity_draw_advance

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        // 适配器，添加 Fragment
        viewPager.adapter = BaseFragmentAdapter(this, mutableListOf<Fragment>().apply {
            add(BezierFragment())
        })

        TabLayoutMediator(tl_title, viewPager) { tab, position -> tab.text = sections[position] }.attach()

    }
}