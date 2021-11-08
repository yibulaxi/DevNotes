package cn.kk.customview.ui

import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.activity.BaseActivity
import cn.kk.base.adapter.ListV2Adapter
import cn.kk.customview.R
import cn.kk.customview.ui.system.*
import kotlinx.android.synthetic.main.activity_system_ui.*

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
        }
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        initAdapter()


    }

    private fun initAdapter() {
        rv_list.layoutManager = LinearLayoutManager(this)
        val listAdapter = ListV2Adapter(itemList)
        listAdapter.setOnItemClickListener { adapter, view, position ->
            when (itemList[position]) {
                itemList[0] -> openNextUI(ImageViewActivity::class.java, itemList[position])
                itemList[1] -> openNextUI(DialogActivity::class.java, itemList[position])
                itemList[2] -> openNextUI(ImmersiveModeActivity::class.java, itemList[position])
                itemList[3] -> openNextUI(CoordinatorLayoutActivity::class.java, itemList[position])
                itemList[4] -> openNextUI(CoordinatorLayoutAndCollapsingToolbarLayoutActivity::class.java, itemList[position])
                itemList[5] -> openNextUI(CustomBehaviorActivity::class.java, itemList[position])
                itemList[6] -> openNextUI(StatusBarActivity::class.java, itemList[position])
            }
        }
        rv_list.adapter = listAdapter
    }

}