package cn.kk.customview.ui.cool300.chapter3

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R

/**
 * 常用控件: 菜单
 */
class Menu: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_basic
    }

    override fun setListViewID(): Int {
        return R.id.rv_list
    }

    override fun getItemNameList(): MutableList<String> {
        return mutableListOf<String>().apply {
            add("063. 使用 Toolbar 在工具栏上添加菜单")
        }
    }

    override fun initAdapter() {
        super.initAdapter()
        listAdapter.setOnItemClickListener { adapter, view, position ->
            when(position){
                0 -> openNextUI(Simple_063::class.java, itemList[position])
            }
        }
    }

}