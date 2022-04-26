package cn.kk.customview.ui.work

import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.customview.R
import cn.kk.customview.activity.BaseTabActivity
import cn.kk.customview.ui.fragment.NormalViewFragment
import cn.kk.customview.ui.system.RecyclerViewAddViewDemoFragment
import cn.kk.customview.ui.system.RecyclerViewContextMenuFragment
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * RecyclerView 常见用法
 */
class RecyclerViewDemoActivity: BaseTabActivity() {

    override fun getLayout(): Int {
        return R.layout.activity_normal_tab
    }

    override fun MutableList<Fragment>.addFragments() {
        add(DragListFragment())
        add(RecyclerViewAddViewDemoFragment())
        add(RecyclerViewContextMenuFragment())
        add(ScrollListenerFragment().apply { title = tabsName[3] })
        add(ScrollOrientationFragment().apply { title = tabsName[4] })
        add(ScrollListenerFragment().apply { title = tabsName[5] })
        add(ScrollListenerFragment().apply { title = tabsName[6] })
    }

    class ScrollListenerFragment: NormalViewFragment() {
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

    class ScrollOrientationFragment: NormalViewFragment() {
        var scrollUp = false

        override fun getMyView(): View {
            val childView = getAddViewByInflate(R.layout.view_at_recyclerview_in_nestedscrollview_layout)

            // RecyclerView config adapter
            val rvList = childView.findViewById<RecyclerView>(R.id.rv_list)
            rvList.layoutManager = LinearLayoutManager(context)
            rvList.adapter = object : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_list_v4, getTestStringList(60)){
                override fun convert(holder: BaseViewHolder, item: String) {
                    holder.setText(R.id.tv_item_home_name, item)
                }

            }

            // 由于 RecyclerView 嵌套在 NestedScrollView 中，因此监听滑动方向用 NestedScrollView
            val scrollView = childView.findViewById<NestedScrollView>(R.id.scroll_view)
            scrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                // 向上滑动
                if (oldScrollY < scrollY) { //向上滑动
                    if (!scrollUp) { // 方向改变了
                        showToast("Up...")
                        scrollUp = oldScrollY < scrollY
                    }
                } else {
                    if (scrollUp) { // 方向改变了
                        showToast("Down...")
                        scrollUp = oldScrollY < scrollY
                    }
                }
            }
            return childView
        }
    }

}