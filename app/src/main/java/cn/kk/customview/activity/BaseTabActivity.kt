package cn.kk.customview.activity

import androidx.fragment.app.Fragment
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.elementary.anim.adapter.BaseFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_normal_tab.*

abstract class BaseTabActivity: BaseActivity() {

    protected var tabType = -1

    protected val tabsName by lazy {
        getItemNamesByType()
    }
    override fun getItemNamesByType(): MutableList<String> {
        when (tabType) {
            TabType.ANIM_TYPE -> {
              return resources.getStringArray(R.array.anim_items).toMutableList()
            }
            TabType.DRAW_TYPE -> {
                return resources.getStringArray(R.array.draw_sections).toMutableList()
            }
            TabType.VIEW_TYPE -> {
                return resources.getStringArray(R.array.view_sections).toMutableList()
            }

            // region SystemUI Type
            TabType.SystemUI.RECYCLER_VIEW_TYPE -> return resources.getStringArray(R.array.recycler_view_types).toMutableList()
            // endregion

            else -> {
            }
        }
        return super.getItemNamesByType()
    }



    override fun doWhenOnCreate() {
        super.doWhenOnCreate()
        tabType = intent.getIntExtra(INTENT_TYPE_KEY, -1)
        viewPager.adapter = BaseFragmentAdapter(this, mutableListOf<Fragment>().apply {
            addFragments()
        })

        TabLayoutMediator(tabs, viewPager, true, object: TabLayoutMediator.TabConfigurationStrategy {
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                tab.text = tabsName[position]
            }

        }).attach()
    }

    override fun initAdapter() {
        // nothing...
    }

    abstract fun MutableList<Fragment>.addFragments()

    /**
     * 用于 TabActivity
     */
  open class TabType {
        companion object {
            // 动画篇
            val ANIM_TYPE = 1
            // 绘图篇
            val DRAW_TYPE = 2
            // 视图篇
            val VIEW_TYPE = 3
        }

         class SystemUI {
            companion object {

                val RECYCLER_VIEW_TYPE = 10
            }
        }
    }
}