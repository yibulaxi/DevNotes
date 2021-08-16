package cn.kk.elementary.anim.property.`object`

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.activity.BaseActivity
import cn.kk.base.adapter.ListAdapter
import cn.kk.elementary.R

/**
 * 组合动画——AnimatorSet
 * 常用函数
 * 1. setDuration()
 * 2. setInterpolator()
 * 3. setTarget()
 * 4. setStartDelay()
 */
class AnimatorSetCommonFuncsActivity: BaseActivity(), ListAdapter.ItemClickListener {

    val SET_DURATION_INTRO = "会覆盖单个 ObjectAnimator 中的设置，如果不调用此方法，则以单个 ObjectAnimator 中的设置为准。"
    val SET_INTERPOLATOR_INTRO = "只要通过 AnimatorSet 的 setInterpolator() 函数设置了插值器，那么单个动画中设置的插值器都无效，都以 AnimatorSet 设置的为准"
    val SET_TARGET_INTRO = "只要通过 AnimatorSet 的 setTarget() 函数设置了目标控件，那么单个动画中的控件都以 AnimatorSet 设置的为准"
    val SET_START_DELAY_INTRO = "setTarget() 函数不会覆盖单个动画的延时，而只是针对性地延长 AnimatorSet 的激活时间"

    override fun getLayout(): Int = R.layout.activity_base_list

    override fun getItemNameList(): MutableList<String> {
        return resources.getStringArray(R.array.animator_set_common_funs).toMutableList()
    }
    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // region 设置适配器
        val homeAdapter = ListAdapter(itemList).apply {
            itemClickListener = this@AnimatorSetCommonFuncsActivity
        }
        val layoutManager = LinearLayoutManager(this)
        val rvHome = findViewById<RecyclerView>(R.id.rv_home)
        rvHome.layoutManager = layoutManager
        rvHome.adapter = homeAdapter
        // endregion

    }

    override fun onItemClick(position: Int) {
        val title = itemList[position]
        when(position){
            // region setDuration()
            0 -> showToastLong(SET_DURATION_INTRO)
            // endregion
            // region setInterpolator()
            1 -> showToastLong(SET_INTERPOLATOR_INTRO)
            // endregion
            // region setTarget()
            2 -> showToastLong(SET_TARGET_INTRO)
            // endregion
            // region setStartDelay()
            3 -> showToastLong(SET_START_DELAY_INTRO)
            // endregion
        }
    }
}