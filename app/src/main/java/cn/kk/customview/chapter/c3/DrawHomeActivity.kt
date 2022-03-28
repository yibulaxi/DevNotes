package cn.kk.customview.chapter.c3

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.activity.BaseActivity
import cn.kk.base.bean.ListItemAction
import cn.kk.customview.R
import cn.kk.customview.adpater.ListAdapter

/**
 * 「绘图篇」页面
 *   第 6 章 Paint 的基本使用
 *   第 7 章 绘图进阶
 *   第 8 章 混合模式
 *   第 9 章 Canvas 与图层
 *   第 10 章 Android 画布
 *   第 11 章 Matrix 与坐标变换
 */
class DrawHomeActivity : BaseActivity(), ListAdapter.ItemClickListener {

    override fun getLayout(): Int = R.layout.activity_base_list

    override fun getItemNameList(): MutableList<ListItemAction> = getItemActionList( resources.getStringArray(R.array.draw_sections))

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // region 设置适配器
        val homeAdapter = ListAdapter(itemList).apply {
            itemClickListener = this@DrawHomeActivity
        }

        val layoutManager = LinearLayoutManager(this)

        val rvDraw = findViewById<RecyclerView>(R.id.rv_list)
        rvDraw.layoutManager = layoutManager
        rvDraw.adapter = homeAdapter
        // endregion
    }

    override fun onItemClick(position: Int) {
        val nextTitle = itemList[position]
        when (position) {
            // region 打开视图动画
            0 -> openNextUI(PaintActivity::class.java, nextTitle.title)
            1 -> openNextUI(DrawAdvanceActivity::class.java, nextTitle.title)
            // endregion
        }
    }


}