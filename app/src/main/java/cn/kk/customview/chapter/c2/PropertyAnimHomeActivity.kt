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
 * 属性动画导航页面
 */
class PropertyAnimHomeActivity: BaseActivity(), ListAdapter.ItemClickListener {
    override fun getLayout(): Int = R.layout.activity_base_home

    override fun getItemNameList(): MutableList<String> {
        return resources.getStringArray(R.array.property_anim_types).toMutableList()
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // region 设置适配器
        val homeAdapter = ListAdapter(itemList).apply {
            itemClickListener = this@PropertyAnimHomeActivity
        }

        val layoutManager = LinearLayoutManager(this)
        rv_home.layoutManager = layoutManager
        rv_home.adapter = homeAdapter
        // endregion
    }

    override fun onItemClick(position: Int) {
        val itemName = itemList[position]
        when(position){
            0 -> openNextUI(ValueAnimationActivity::class.java, itemName)
            1 -> openNextUI(InterpolationActivity::class.java, itemName)
            2 -> openNextUI(EvaluatorActivity::class.java, itemName)
            3 -> openNextUI(ObjectAnimActivity::class.java, itemName)
            4 -> openNextUI(AnimatorSetActivity::class.java, itemName)
        }
    }
}