package cn.kk.customview.ui.work

import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import cn.kk.customview.R
import cn.kk.customview.activity.BaseTabActivity
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
        add(MenuFragment().apply { title = tabsName[0] })
        add(MenuFragment().apply { title = tabsName[1] })
        add(MenuFragment().apply { title = tabsName[2] })
        add(MenuFragment().apply { title = tabsName[3] })
    }

    class MenuFragment: NormalViewFragment() {
        var title = ""
        override fun getMyView(): View {
            return TextView(requireContext()).apply {
                text = title
                layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT)
                gravity = Gravity.CENTER
                textSize = 34f
            }
        }
    }
}