package cn.kk.customview.ui

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.ui.work.FlickerActivity
import cn.kk.customview.ui.work.TimeProgressActivity
import kotlinx.android.synthetic.main.activity_work.*

class WorkActivity: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_work
    }

    override fun setListViewID(): Int {
        return R.id.rv_list
    }

    override fun getItemNameList(): MutableList<String> {
        return mutableListOf<String>().apply {
            add("时间水平进度条")
            add("闪烁按钮")
        }
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

    }

    override fun initAdapter() {
        super.initAdapter()
        listAdapter.setOnItemClickListener { adapter, view, position ->
            when (itemList[position]) {
                itemList[0] -> openNextUI(TimeProgressActivity::class.java, itemList[position])
                itemList[1] -> openNextUI(FlickerActivity::class.java, itemList[position])
            }
        }
        rv_list.adapter = listAdapter
    }
}