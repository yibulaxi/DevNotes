package cn.kk.elementary.anim.property.`object`

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.activity.BaseActivity
import cn.kk.base.adapter.ListAdapter
import cn.kk.base.bean.ListItemAction
import cn.kk.elementary.R

/**
 * 组合动画——AnimatorSet
 */
class AnimatorSetActivity: BaseActivity(), ListAdapter.ItemClickListener {
    override fun getLayout(): Int = R.layout.activity_base_list

    override fun getItemNameList(): MutableList<ListItemAction> {
        val itemList = mutableListOf<ListItemAction>()
        for (s in resources.getStringArray(R.array.animator_set_types).toMutableList()) {
            itemList.add(ListItemAction(s, true))
        }
        return itemList
    }
    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // region 设置适配器
        val homeAdapter = ListAdapter(itemList).apply {
            itemClickListener = this@AnimatorSetActivity
        }
        val layoutManager = LinearLayoutManager(this)
        val rvHome = findViewById<RecyclerView>(R.id.rv_list)
        rvHome.layoutManager = layoutManager
        rvHome.adapter = homeAdapter
        // endregion

    }

    override fun onItemClick(position: Int) {
        val title = itemList[position].title
        when(position){
            // region 3.5.1 playSequentially() 与 playTogether() 函数
            0 -> openNextUI(AnimatorSetDualPlayFunActivity::class.java, title)
            // endregion
            // region 3.5.2 AnimatorSet.Builder
            1 -> openNextUI(AnimatorSetBuilderActivity::class.java, title)
            // endregion
            // region 3.5.3 AnimatorSet 监听
            2 -> openNextUI(AnimatorSetListenerActivity::class.java, title)
            // endregion
            // region 3.5.4 AnimatorSet 常用函数
            3 -> openNextUI(AnimatorSetCommonFuncsActivity::class.java, title)
            // endregion
            // region 3.5.5 示例：路径动画
            4 -> openNextUI(AnimatorSetPathSampleActivity::class.java, title)
            // endregion
        }
    }
}