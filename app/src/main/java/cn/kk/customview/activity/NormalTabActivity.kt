package cn.kk.customview.activity

import androidx.fragment.app.Fragment
import cn.kk.customview.R
import cn.kk.customview.config.UIConfig
import cn.kk.customview.ui.fragment.NormalListFragment
import cn.kk.elementary.anim.adapter.BaseFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_normal_tab.*

class NormalTabActivity: BaseTabActivity() {

    private val tabsName by lazy {
        getItemNamesByType()
    }
    private var tabType = -1

    override fun getTabType(): Int {
        return tabType
    }

    override fun getLayout(): Int {
        return R.layout.activity_normal_tab
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()
        tabType = intent.getIntExtra(INTENT_TYPE_KEY, -1)

        viewPager.adapter = BaseFragmentAdapter(this, mutableListOf<Fragment>().apply {
            when(tabType) {
                // region 动画篇
                TabType.ANIM_TYPE -> {
                    var items = resources.getStringArray(R.array.view_anim_types).toMutableList()
                    add(NormalListFragment().apply {
                        partType = UIConfig.SubConfigSystem.Anim.ANIM_VIEW
                        addItems(items)
                    })
                    items = resources.getStringArray(R.array.property_anim_types).toMutableList()
                    add(NormalListFragment().apply {
                        partType = UIConfig.SubConfigSystem.Anim.ANIM_PROPERTY
                        addItems(items)
                    })
                    items = resources.getStringArray(R.array.anim_advance_sections).toMutableList()
                    add(NormalListFragment().apply {
                        partType = UIConfig.SubConfigSystem.Anim.ANIM_ADVANCE
                        addItems(items)
                    })
                }
                // endregion
            }

        })

        TabLayoutMediator(tabs, viewPager, true, object: TabLayoutMediator.TabConfigurationStrategy {
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                tab.text = tabsName[position]
            }

        }).attach()


    }

}