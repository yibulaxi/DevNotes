package cn.kk.customview.activity

import cn.kk.base.activity.BaseActivity
import cn.kk.base.bean.ListItemAction
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_normal_list.*

/**
 * 普通列表 Activity
 */
class NormalListActivity: BaseActivity() {

    override fun getLayout(): Int = R.layout.activity_normal_list

    override fun getItemNameList(): MutableList<ListItemAction> = getItemActionList(resources.getStringArray(R.array.touch_feed))

    override fun setListViewID(): Int {
        return R.id.rv_list
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        initAdapter()
    }

    override fun initAdapter() {
        super.initAdapter()
        listAdapter.setOnItemClickListener { adapter, view, position ->
            when (position) {

            }
        }
        rv_list.adapter = listAdapter
    }

}