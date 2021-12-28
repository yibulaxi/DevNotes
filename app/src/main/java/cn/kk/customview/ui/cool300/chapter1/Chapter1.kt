package cn.kk.customview.ui.cool300.chapter1

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R

/**
 * 常用控件
 */
class Chapter1: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_basic
    }

    override fun setListViewID(): Int {
        return R.id.rv_list
    }

    override fun getItemNameList(): MutableList<String> {
        return mutableListOf<String>().apply {
            add("009. Drawable shape 作为 btn 背景")
            add("010. Drawable shape 渐变圆角按钮")
        }
    }

    override fun initAdapter() {
        super.initAdapter()
        listAdapter.setOnItemClickListener { adapter, view, position ->
            when(position){
                0 -> openNextUI(Simple_009::class.java, itemList[position])
                1 -> openNextUI(Simple_010::class.java, itemList[position])
            }
        }
    }
}