package cn.kk.customview.ui.hencoder.touch

import cn.kk.base.activity.BaseActivity
import cn.kk.base.bean.ListItemAction
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_basic.*

/**
 * 触摸反馈系列
 */
class TouchFeedBackActivity: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_basic
    }

    override fun setListViewID(): Int {
        return R.id.rv_list
    }

    override fun getItemNameList(): MutableList<ListItemAction> {
        return mutableListOf<ListItemAction>().apply {
            add(ListItemAction("触摸反馈：原理全解析 119min"))
            add(ListItemAction("双向滑动的 ScalableImageView 180min"))
            add(ListItemAction("多点触控的原理和写法全解析 116min"))
            add(ListItemAction("多点触控的原理和写法全解析 116min"))
            add(ListItemAction("自定义触摸算法之拖拽 API 详解 57min"))
            add(ListItemAction("嵌套滑动 21min"))
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