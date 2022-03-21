package cn.kk.customview.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import cn.kk.base.activity.BaseActivity
import cn.kk.base.fragment.BaseFragment
import cn.kk.customview.R
import cn.kk.customview.config.UIConfig
import cn.kk.elementary.anim.adapter.BaseFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_card_view.*
import kotlinx.android.synthetic.main.fragment_normal_tab.*

/**
 * Fragment: tab + viewPager(Fragment)
 */
class NormalTabFragment : BaseFragment() {
    var partType = -1

    val TABS_NAME_COOL300 = arrayOf("常用控件", "通知栏", "菜单", "图形和图像", "动画", "文件和数据", "系统和设备", "Intent", "第三方 SDK 开发")

    override fun getLayoutId(): Int {
        return R.layout.fragment_normal_tab
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager.adapter =
            BaseFragmentAdapter(activity as BaseActivity, mutableListOf<Fragment>().apply {
                // 常用控件
                add(NormalListFragment().apply {
                    partType = UIConfig.SubConfig.COMMON_VIEW
                    addItem("005. 自定义 CheckBox 风格")
                    addItem("009. Drawable shape 作为 btn 背景")
                    addItem("010. Drawable shape 渐变圆角按钮")
                    addItem("022. 自定义 selector 以透明前景切换控件")
                })
                // 通知栏
                add(NormalListFragment().apply {

                })
                // 菜单
                add(NormalListFragment().apply {
                    partType = UIConfig.SubConfig.MENU_VIEW
                    addItem("063. 使用 Toolbar 在工具栏上添加菜单")
                    addItem("071. 在弹出底部菜单时，主窗口立刻变暗")
                    addItem("072. 长按 view 弹出上下文")
                })
                // 图形和图像
                add(NormalListFragment().apply {

                })
                // 动画
                add(NormalListFragment().apply {
                    partType = UIConfig.SubConfig.ANIM_VIEW
                    addItem("143. 使用 RippleDrawable 创建波纹扩散动画")
                })
                // 文件和数据
                add(NormalListFragment().apply {

                })
                // 系统和设备
                add(NormalListFragment().apply {

                })
                // Intent
                add(NormalListFragment().apply {

                })
                // 第三方 SDK 开发
                add(NormalListFragment().apply {

                })
            })

        TabLayoutMediator(tabs, viewPager, object : TabLayoutMediator.TabConfigurationStrategy {
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                tab.text = getTabsName()[position]
            }

        }).attach()
    }

    private fun getTabsName(): Array<String>{
        when(partType){
            UIConfig.PART_COOL_300 -> return TABS_NAME_COOL300

            else -> return arrayOf()
        }
    }
}