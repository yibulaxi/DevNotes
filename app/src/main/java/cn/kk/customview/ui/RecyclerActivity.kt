package cn.kk.customview.ui

import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.adpater.ListAdapter
import kotlinx.android.synthetic.main.activity_recycler.*

/**
 * 列表页面
 */
class RecyclerActivity: BaseActivity() {
    override fun getLayout(): Int {
       return R.layout.activity_recycler
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        val dataList: MutableList<String> = mutableListOf()
        for (i in 0..18){
            dataList.add(i.toString())
        }
        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.adapter = ListAdapter(dataList)
    }

}