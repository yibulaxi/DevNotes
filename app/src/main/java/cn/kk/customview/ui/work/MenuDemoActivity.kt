package cn.kk.customview.ui.work

import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import cn.kk.customview.R
import cn.kk.customview.activity.BaseTabActivity
import cn.kk.customview.ui.cool300.chapter3.Simple_063
import cn.kk.customview.ui.cool300.chapter3.Simple_071
import cn.kk.customview.ui.cool300.chapter3.Simple_072
import cn.kk.customview.ui.fragment.NormalViewFragment
import cn.kk.customview.ui.system.RecyclerViewAddViewDemoFragment
import cn.kk.customview.ui.system.RecyclerViewContextMenuFragment
import cn.kk.customview.utils.px

/**
 * Menu 常见用法
 */
class MenuDemoActivity: BaseTabActivity() {

    override fun getLayout(): Int {
        return R.layout.activity_normal_tab
    }

    override fun MutableList<Fragment>.addFragments() {
        add(MenuFragment().apply {
            title = tabsName[0]
            type = TabType.SystemUI.menu_option
        })
        add(MenuFragment().apply {
            title = tabsName[1]
            type = TabType.SystemUI.menu_bottom
        })
        add(MenuFragment().apply {
            title = tabsName[2]
            type = TabType.SystemUI.menu_context
        })
        add(MenuFragment().apply { title = tabsName[3] })
        add(MenuFragment().apply { title = tabsName[4] })
    }

    class MenuFragment: NormalViewFragment() {
        var type = -1
        var title = ""
        override fun getMyView(): View {
            return TextView(requireContext()).apply {
                text = title
                layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT)
                gravity = Gravity.CENTER
                textSize = 34f
                setOnClickListener {
                    when (type) {
                        TabType.SystemUI.menu_option -> startNextUI(Simple_063::class.java, title)
                        TabType.SystemUI.menu_bottom -> startNextUI(Simple_071::class.java, title)
                        TabType.SystemUI.menu_context -> startNextUI(Simple_072::class.java, title)
                        else -> {
                            showToast(getString(R.string.not_yet))
                        }
                    }
                }
            }
        }
    }
}