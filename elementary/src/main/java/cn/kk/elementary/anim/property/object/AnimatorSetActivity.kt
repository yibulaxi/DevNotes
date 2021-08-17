package cn.kk.elementary.anim.property.`object`

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.activity.BaseActivity
import cn.kk.base.adapter.ListAdapter
import cn.kk.elementary.R

/**
 * 组合动画——AnimatorSet
 */
class AnimatorSetActivity: BaseActivity(), ListAdapter.ItemClickListener {
    override fun getLayout(): Int = R.layout.activity_base_list

    override fun getItemNameList(): MutableList<String> {
        return resources.getStringArray(R.array.animator_set_types).toMutableList()
    }
    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // region 设置适配器
        val homeAdapter = ListAdapter(itemList).apply {
            itemClickListener = this@AnimatorSetActivity
        }
        val layoutManager = LinearLayoutManager(this)
        val rvHome = findViewById<RecyclerView>(R.id.rv_home)
        rvHome.layoutManager = layoutManager
        rvHome.adapter = homeAdapter
        // endregion

    }

    override fun onItemClick(position: Int) {
        val title = itemList[position]
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