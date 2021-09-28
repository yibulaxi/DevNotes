package cn.kk.customview.ui

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.activity.BaseActivity
import cn.kk.base.adapter.ListV2Adapter
import cn.kk.customview.R
import cn.kk.customview.ui.system.DialogActivity
import cn.kk.customview.ui.system.ImageViewActivity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import kotlinx.android.synthetic.main.activity_system_ui.*

class SystemUIActivity: BaseActivity() {

    override fun getLayout(): Int = R.layout.activity_system_ui

    override fun getItemNameList(): MutableList<String> {
        return mutableListOf<String>().apply {
            add("ImageView")
            add("Dialog")
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
            }
        }
        rv_list.adapter = listAdapter
    }

}