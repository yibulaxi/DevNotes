package cn.kk.customview.chapter

import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.adpater.ListAdapter
import kotlinx.android.synthetic.main.activity_anim.*

/**
 * 「动画篇」页面
 */
class AnimActivity: BaseActivity(), ListAdapter.ItemClickListener {

    override fun getLayout(): Int = R.layout.activity_anim

    override fun getItemNameList(): MutableList<String> = resources.getStringArray(R.array.anim_types).toMutableList()

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
        showToast("click: ${itemList[position]}")
        when(position){
            // region 打开视图动画
            0 -> openNextUI(ViewAnimHomeActivity::class.java, itemList[position])
            // endregion
            1 -> openNextUI(PropertyAnimHomeActivity::class.java, itemList[position])
        }
    }


}