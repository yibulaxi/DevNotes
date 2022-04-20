package cn.kk.customview.ui.work

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import cn.kk.customview.R
import cn.kk.customview.activity.BaseTabActivity
import cn.kk.customview.ui.fragment.NormalViewFragment
import cn.kk.customview.ui.system.RecyclerViewAddViewDemoFragment
import cn.kk.customview.ui.system.RecyclerViewContextMenuFragment

/**
 * RecyclerView 常见用法
 */
class RecyclerViewDemoActivity: BaseTabActivity() {

    override fun getLayout(): Int {
        return R.layout.activity_normal_tab
    }

    override fun MutableList<Fragment>.addFragments() {
        when(tabType) {
            TabType.SystemUI.RECYCLER_VIEW_TYPE -> {
                add(DragListFragment())
                add(RecyclerViewAddViewDemoFragment())
                add(RecyclerViewContextMenuFragment())
                add(ScrollListenerFragment().apply { title = tabsName[3] })
                add(ScrollListenerFragment().apply { title = tabsName[4] })
            }
        }
    }

    class ScrollListenerFragment: NormalViewFragment() {
        var title = ""
        override fun getMyView(): View {
            return TextView(requireContext()).apply { text = title}
        }
    }
}