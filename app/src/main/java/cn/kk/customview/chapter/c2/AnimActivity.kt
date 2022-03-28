package cn.kk.customview.chapter.c2

import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.activity.BaseActivity
import cn.kk.base.bean.ListItemAction
import cn.kk.customview.R
import cn.kk.customview.adpater.ListAdapter
import kotlinx.android.synthetic.main.activity_anim.*

/**
 * 「动画篇」页面
 */
class AnimActivity: BaseActivity(), ListAdapter.ItemClickListener {

    override fun getLayout(): Int = R.layout.activity_anim

    override fun getItemNameList(): MutableList<ListItemAction> = getItemActionList(resources.getStringArray(R.array.anim_types))

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // region 设置适配器
        val homeAdapter = ListAdapter(itemList).apply {
            itemClickListener = this@AnimActivity
        }

        val layoutManager = LinearLayoutManager(this)
        rv_anim.layoutManager = layoutManager
        rv_anim.adapter = homeAdapter
        // endregion
    }

    override fun onItemClick(position: Int) {
        when(position){
            // region 1. 打开视图动画
            0 -> openNextUI(ViewAnimHomeActivity::class.java, itemList[position].title)
            // endregion
            // region 2. 打开属性动画
            1 -> openNextUI(PropertyAnimHomeActivity::class.java, itemList[position].title)
            // endregion
            // region 3. 打开动画进阶
            2 -> openNextUI(AnimAdvanceHomeActivity::class.java, itemList[position].title)
            // endregion
        }
    }


}