package cn.kk.customview.ui

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_third_part.*

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