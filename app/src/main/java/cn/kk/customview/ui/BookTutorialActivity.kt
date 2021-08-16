package cn.kk.customview.ui

import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.adpater.ListAdapter
import cn.kk.customview.chapter.c2.AnimActivity
import cn.kk.customview.chapter.c1.DrawBasicActivity
import cn.kk.customview.chapter.c3.DrawHomeActivity
import cn.kk.customview.chapter.c4.ViewHomeActivity
import kotlinx.android.synthetic.main.activity_book_tutorial.*

/**
 * 「系统学习」导航页面
 */
class BookTutorialActivity : BaseActivity(), ListAdapter.ItemClickListener {

    override fun getLayout(): Int = R.layout.activity_book_tutorial

    override fun getItemNameList(): MutableList<String> {
        return mutableListOf(
            "绘图基础",
            "动画篇",
            "绘图篇",
            "视图篇"
        )
    }
    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // region 设置适配器
        val homeAdapter = ListAdapter(itemList).apply {
            itemClickListener = this@BookTutorialActivity
        }

        val layoutManager = LinearLayoutManager(this)
        rv_book_tutorial.layoutManager = layoutManager
        rv_book_tutorial.adapter = homeAdapter
        // endregion
    }

    // region Recyclerview 的 item 点击事件
    override fun onItemClick(position: Int) {
        val title = itemList[position]
        when(position){
            // region 1. 绘图基础
            0 -> openNextUI(DrawBasicActivity::class.java, title)
            // endregion
            // region 2. 动画篇
            1 -> openNextUI(AnimActivity::class.java, title)
            // endregion
            // region 3. 绘图篇
            2 -> openNextUI(DrawHomeActivity::class.java, title)
            // endregion
            // region 4. 视图篇
            3 -> openNextUI(ViewHomeActivity::class.java, title)
            // endregion

        }
    }
    // endregion

    /*override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.in_left, R.anim.out_right)
    }*/
}