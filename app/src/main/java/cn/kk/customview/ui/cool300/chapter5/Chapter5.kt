package cn.kk.customview.ui.cool300.chapter5

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R

/**
 * 常用控件
 */
class Chapter5: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_basic
    }

    override fun setListViewID(): Int {
        return R.id.rv_list
    }

    override fun getItemNameList(): MutableList<String> {
        return mutableListOf<String>().apply {
            add("143. 使用 RippleDrawable 创建波纹扩散动画")
        }
    }

    override fun initAdapter() {
        super.initAdapter()
        listAdapter.setOnItemClickListener { adapter, view, position ->
            when(position){
                0 -> openNextUI(Simple_143::class.java, itemList[position])
            }
        }
    }

}