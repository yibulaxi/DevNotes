package cn.kk.customview.ui.cool300

import android.content.Context
import cn.kk.base.UIHelper
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.ui.cool300.chapter1.Chapter1
import cn.kk.customview.ui.cool300.chapter1.Simple_009

/**
 * Android 炫酷应用 300 例
 */
class Cool300Activity: BaseActivity() {
    val self: Context = this

    override fun getLayout(): Int {
        return R.layout.activity_cool300
    }

    override fun setListViewID(): Int {
        return R.id.rv_list
    }

    override fun getItemNameList(): MutableList<String> {
        return mutableListOf<String>().apply {
            add("1. 常用控件")
            add("2. 通知栏")
            add("3. 菜单")
            add("4. 图形和图像")
            add("5. 动画")
            add("6. 文件和数据")
            add("7. 系统和设备")
            add("8. Intent")
            add("9. 第三方 SDK 开发")
        }
    }

    override fun initAdapter() {
        super.initAdapter()
        listAdapter.setOnItemClickListener { adapter, view, position ->
            when(position){
                0 -> openNextUI(Chapter1::class.java, itemList[position])
                1 -> UIHelper.toast(itemList[position], self)
                2 -> UIHelper.toast(itemList[position], self)
            }
        }
    }
}