package cn.kk.customview.ui.activity

import androidx.fragment.app.Fragment
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.ui.fragment.NormalListFragment
import cn.kk.customview.R
import cn.kk.customview.config.UIConfig
import cn.kk.elementary.anim.adapter.BaseFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_home_new.*

class HomeNewActivity: BaseActivity() {
    val tabs_name = arrayOf("系统学习","系统UI","炫酷应用 300例","第三方UI","Hencoder", "work" )
    override fun getLayout(): Int {
        return R.layout.activity_home_new
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        viewPager.adapter = BaseFragmentAdapter(this, mutableListOf<Fragment>().apply {
            // add fragment ui
            add(NormalListFragment().apply {
                partType = UIConfig.PART_SYSTEM_STUDY
                addItem("绘图基础")
                addItem("动画篇")
                addItem("绘图篇")
                addItem("视图篇")
            })

            add(NormalListFragment().apply {
                partType = UIConfig.PART_SYSTEM_UI
                addItem("ImageView")
                addItem("Dialog")
                addItem("ImmersiveMode")
                addItem("CoordinatorLayout")
                addItem("CoordinatorLayout & CollapsingToolbarLayout")
                addItem("Custom Behavior")
                addItem("Status Bar")
                addItem("Line Height")
                addItem("Material Design")
                addItem("约束布局- TextView 长度可变")
                addItem("TextView with drawable")
                addItem("忽略系统大字体")
                addItem("Html Text")
                addItem("桌面小组件")
                addItem("Drawable")
            })

            add(NormalListFragment().apply {
                partType = UIConfig.PART_COOL_300
                addItem("1. 常用控件")
                addItem("2. 通知栏")
                addItem("3. 菜单")
                addItem("4. 图形和图像")
                addItem("5. 动画")
                addItem("6. 文件和数据")
                addItem("7. 系统和设备")
                addItem("8. Intent")
                addItem("9. 第三方 SDK 开发")
            })

            add(NormalListFragment().apply {
                partType = UIConfig.PART_THIRD
                addItem("LottieAnim")
            })

            add(NormalListFragment().apply {
                partType = UIConfig.PART_HENCODER
                addItem("图形的位置和尺寸测量 136min")
                addItem("Xfermode 完全使用解析 43min")
                addItem("文字的测量 99min")
                addItem("范围裁剪和几何变换 63min")
                addItem("属性动画和硬件加速 127min")
                addItem("Bitmap 和 Drawable 54min")
                addItem("手写 MaterialEditText 76min")
                addItem("布局流程完全解析 35min")
                addItem("尺寸的自定义 40min")
                addItem("Layout 的自定义 65min")
                addItem("绘制流程源码解析 81min")
                addItem("触摸反馈系列")
            })

            add(NormalListFragment().apply {
                partType = UIConfig.PART_WORK
                addItem("时间水平进度条")
                addItem("闪烁按钮")
            })
        })

        // bind tabLayout and viewPager
        TabLayoutMediator(tabs, viewPager, true, object: TabLayoutMediator.TabConfigurationStrategy{
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                tab.text = tabs_name[position]
            }

        }).attach()
    }
}