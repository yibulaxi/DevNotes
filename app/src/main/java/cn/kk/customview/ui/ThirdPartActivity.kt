package cn.kk.customview.ui

import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.activity.BaseActivity
import cn.kk.base.adapter.ListV2Adapter
import cn.kk.customview.R
import cn.kk.customview.ui.system.DialogActivity
import cn.kk.customview.ui.system.ImageViewActivity
import kotlinx.android.synthetic.main.activity_system_ui.*

class ThirdPartActivity: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_third_part
    }

    override fun setListViewID(): Int {
        return R.id.rv_list
    }

    override fun getItemNameList(): MutableList<String> {
        return mutableListOf<String>().apply {
            add("LottieAnim")
        }
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        initAdapter()

    }
     override fun initAdapter() {
         super.initAdapter()
//        rv_list.layoutManager = LinearLayoutManager(this)
//        val listAdapter = ListV2Adapter(itemList)
        listAdapter.setOnItemClickListener { adapter, view, position ->
            when (itemList[position]) {
                itemList[0] -> openNextUI(LottieAnimActivity::class.java, itemList[position])
            }
        }
        rv_list.adapter = listAdapter
    }
}