package cn.kk.customview.chapter.c3

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.adpater.ListAdapter

/**
 * 「绘图篇」页面
 */
class DrawHomeActivity: BaseActivity(), ListAdapter.ItemClickListener {

    override fun getLayout(): Int = R.layout.activity_base_list

    override fun getItemNameList(): MutableList<String> = resources.getStringArray(R.array.draw_sections).toMutableList()

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // region 设置适配器
        val homeAdapter = ListAdapter(itemList).apply {
            itemClickListener = this@DrawHomeActivity
        }

        val layoutManager = LinearLayoutManager(this)

        val rvDraw = findViewById<RecyclerView>(R.id.rv_home)
        rvDraw.layoutManager = layoutManager
        rvDraw.adapter = homeAdapter
        // endregion
    }

    override fun onItemClick(position: Int) {
        when(position){
            // region 打开视图动画
        }
    }


}