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
            else -> {
            }
        }
        return super.getItemNamesByType()
    }

  open class TabType {
        companion object {
            val ANIM_TYPE = 1
        }
    }
}