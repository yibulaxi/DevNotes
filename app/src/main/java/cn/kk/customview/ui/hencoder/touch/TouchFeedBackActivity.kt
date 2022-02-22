package cn.kk.customview.ui.hencoder.touch

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_system_ui.*

class TouchFeedBackActivity: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_basic
    }

    override fun setListViewID(): Int {
        return R.id.rv_list
    }

    override fun getItemNameList(): MutableList<String> {
        return mutableListOf<String>().apply {
            add("触摸反馈：原理全解析")
            add("双向滑动的 ScalableImageView")
            add("多点触控的原理和写法全解析")
            add("ViewGroup 的触摸反馈")
            add("自定义触摸算法之拖拽 API 详解")
            add("嵌套滑动")
        }
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        initAdapter()

    }
    override fun initAdapter() {
        super.initAdapter()
        listAdapter.setOnItemClickListener { adapter, view, position ->
            when (itemList[position]) {
            }
        }
        rv_list.adapter = listAdapter
    }
}