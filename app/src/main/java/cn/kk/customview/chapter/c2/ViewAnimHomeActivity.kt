package cn.kk.customview.chapter.c2

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.adpater.ListAdapter
import cn.kk.customview.chapter.AnimInterpolatorActivity
import cn.kk.customview.chapter.ViewAnimIntrosActivity
import cn.kk.elementary.anim.view.AnimSampleActivity

/**
 * 视图动画导航页面
 */
class ViewAnimHomeActivity: BaseActivity(), ListAdapter.ItemClickListener {
    override fun getLayout(): Int = R.layout.activity_view_anim_home

    override fun getItemNameList(): MutableList<String> {
        return resources.getStringArray(R.array.view_anim_types).toMutableList()
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // region 设置适配器
        val homeAdapter = ListAdapter(itemList).apply {
            itemClickListener = this@ViewAnimHomeActivity
        }

        val layoutManager = LinearLayoutManager(this)
        val rvHome = findViewById<RecyclerView>(R.id.rv_home)
        rvHome.layoutManager = layoutManager
        rvHome.adapter = homeAdapter
        // endregion
    }

    override fun onItemClick(position: Int) {
        when(position){
            0 -> openNextUI(ViewAnimIntrosActivity::class.java, itemList[position])
            1 -> openNextUI(AnimSampleActivity::class.java, itemList[position])
            2 -> openNextUI(AnimInterpolatorActivity::class.java, itemList[position])
        }
    }
}