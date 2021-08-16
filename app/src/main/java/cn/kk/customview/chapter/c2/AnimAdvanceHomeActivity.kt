package cn.kk.customview.chapter.c2

import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.adpater.ListAdapter
import cn.kk.elementary.anim.property.`object`.AnimatorSetActivity
import cn.kk.elementary.anim.property.`object`.ObjectAnimActivity
import cn.kk.elementary.anim.property.value.ValueAnimationActivity
import cn.kk.elementary.anim.property.value.evaluator.EvaluatorActivity
import cn.kk.elementary.anim.property.value.interpolation.InterpolationActivity
import kotlinx.android.synthetic.main.activity_home.*

/**
 * 动画进阶导航页面
 */
class AnimAdvanceHomeActivity: BaseActivity(), ListAdapter.ItemClickListener {
    override fun getLayout(): Int = R.layout.activity_base_list

    override fun getItemNameList(): MutableList<String> {
        return resources.getStringArray(R.array.anim_advance_sections).toMutableList()
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // region 设置适配器
        val homeAdapter = ListAdapter(itemList).apply {
            itemClickListener = this@AnimAdvanceHomeActivity
        }

        val layoutManager = LinearLayoutManager(this)
        rv_home.layoutManager = layoutManager
        rv_home.adapter = homeAdapter
        // endregion
    }

    override fun onItemClick(position: Int) {
        val itemName = itemList[position]
        when(position){
        }
    }
}