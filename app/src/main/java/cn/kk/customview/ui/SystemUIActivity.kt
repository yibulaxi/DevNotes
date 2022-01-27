package cn.kk.customview.ui

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.ui.system.*
import cn.kk.customview.ui.system.material.MaterialActivity
import kotlinx.android.synthetic.main.activity_system_ui.*

/**
 * 系统 UI 练习
 */
class SystemUIActivity: BaseActivity() {

    override fun getLayout(): Int = R.layout.activity_system_ui

    override fun getItemNameList(): MutableList<String> {
        return mutableListOf<String>().apply {
            add("ImageView")
            add("Dialog")
            add("ImmersiveMode")
            add("CoordinatorLayout")
            add("CoordinatorLayout & CollapsingToolbarLayout")
            add("Custom Behavior")
            add("Status Bar")
            add("Line Height")
            add("Material Design")
            add("约束布局- TextView 长度可变")
            add("TextView with drawable")
            add("忽略系统大字体")
            add("Html Text")
            add("桌面小组件")
        }
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

    }

    override fun setListViewID(): Int {
        return R.id.rv_list
    }


     override fun initAdapter() {
         super.initAdapter()
//        rv_list.layoutManager = LinearLayoutManager(this)
//        val listAdapter = ListV2Adapter(itemList)
        listAdapter.setOnItemClickListener { adapter, view, position ->
            when (itemList[position]) {
                itemList[0] -> openNextUI(ImageViewActivity::class.java, itemList[position])
                itemList[1] -> openNextUI(DialogActivity::class.java, itemList[position])
                itemList[2] -> openNextUI(ImmersiveModeActivity::class.java, itemList[position])
                itemList[3] -> openNextUI(CoordinatorLayoutActivity::class.java, itemList[position])
                itemList[4] -> openNextUI(CoordinatorLayoutAndCollapsingToolbarLayoutActivity::class.java, itemList[position])
                itemList[5] -> openNextUI(CustomBehaviorActivity::class.java, itemList[position])
                itemList[6] -> openNextUI(StatusBarActivity::class.java, itemList[position])
                itemList[7] -> openNextUI(LineHeightActivity::class.java, itemList[position])
                itemList[8] -> openNextUI(MaterialActivity::class.java, itemList[position])
                itemList[9] -> openNextUI(TextViewWidthEnableChangeActivity::class.java, itemList[position])
                itemList[10] -> openNextUI(TextViewWithDrawableActivity::class.java, itemList[position])
                itemList[11] -> openNextUI(IgnoreSystemBigFont::class.java, itemList[position])
                itemList[12] -> openNextUI(HtmlText::class.java, itemList[position])
                itemList[13] -> openNextUI(AppWidgetSample::class.java, itemList[position])
            }
        }
        rv_list.adapter = listAdapter
    }

}