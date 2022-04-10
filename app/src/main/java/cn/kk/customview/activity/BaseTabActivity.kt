package cn.kk.customview.activity

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R

abstract class BaseTabActivity: BaseActivity() {

    abstract fun getTabType(): Int

    override fun getItemNamesByType(): MutableList<String> {
        when (getTabType()) {
            TabType.ANIM_TYPE -> {
              return resources.getStringArray(R.array.anim_items).toMutableList()
            }
            TabType.DRAW_TYPE -> {
                return resources.getStringArray(R.array.draw_sections).toMutableList()
            }
            TabType.VIEW_TYPE -> {
                return resources.getStringArray(R.array.view_sections).toMutableList()
            }

            else -> {
            }
        }
        return super.getItemNamesByType()
    }

    /**
     * 用于 TabActivity
     */
  open class TabType {
        companion object {
            // 动画篇
            val ANIM_TYPE = 1
            // 绘图篇
            val DRAW_TYPE = 2
            // 视图篇
            val VIEW_TYPE = 3
        }
    }
}