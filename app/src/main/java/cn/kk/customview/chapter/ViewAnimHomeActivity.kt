package cn.kk.customview.chapter

import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.adpater.ListAdapter
import cn.kk.elementary.anim.property.value.interpolation.InterpolationActivity
import cn.kk.elementary.anim.view.AnimSampleActivity
import kotlinx.android.synthetic.main.activity_home.*

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
        rv_home.layoutManager = layoutManager
        rv_home.adapter = homeAdapter
        // endregion
    }

    override fun onItemClick(position: Int) {
        when(position){
            0 -> openNextUI(ViewAnimIntrosActivity::class.java, itemList[position])
            1 -> openNextUI(InterpolationActivity::class.java, itemList[position])
            2 -> openNextUI(AnimInterpolatorActivity::class.java, itemList[position])
        }
    }
}