package cn.kk.customview.ui.system

import cn.kk.base.activity.BaseActivity
import cn.kk.base.bean.ListItemAction
import cn.kk.customview.R

class RecyclerViewDemo: BaseActivity() {

    override fun getLayout(): Int {
        return R.layout.activity_recyclerview_demo
    }

    override fun setListViewID(): Int {
        return R.id.rv_list
    }

    override fun getItemNameList(): MutableList<ListItemAction> {
        return getItemActionList(arrayOf<String>("one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten", "1", "2", "3", "4", "5", "6"))
    }
}