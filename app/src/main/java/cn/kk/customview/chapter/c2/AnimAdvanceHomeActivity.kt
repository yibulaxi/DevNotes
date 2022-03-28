package cn.kk.customview.chapter.c2

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.activity.BaseActivity
import cn.kk.base.bean.ListItemAction
import cn.kk.customview.R
import cn.kk.customview.adpater.ListAdapter

/**
 * 动画进阶导航页面
 */
class AnimAdvanceHomeActivity: BaseActivity(), ListAdapter.ItemClickListener {
    override fun getLayout(): Int = R.layout.activity_base_list

    override fun getItemNameList(): MutableList<ListItemAction> {
        return getItemActionList(resources.getStringArray(R.array.anim_advance_sections))
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // region 设置适配器
        val homeAdapter = ListAdapter(itemList).apply {
            itemClickListener = this@AnimAdvanceHomeActivity
        }

        val layoutManager = LinearLayoutManager(this)
        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        rvList.layoutManager = layoutManager
        rvList.adapter = homeAdapter
        // endregion
    }

    override fun onItemClick(position: Int) {
        val itemName = itemList[position]
        when(position){
        }
    }
}