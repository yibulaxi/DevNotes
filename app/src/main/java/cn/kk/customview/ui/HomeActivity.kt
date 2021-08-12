package cn.kk.customview.ui

import android.content.Intent
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.adpater.ListAdapter
import kotlinx.android.synthetic.main.activity_home.*

/**
 * 首页
 */
class HomeActivity: BaseActivity(), ListAdapter.ItemClickListener {

    override fun getLayout(): Int = R.layout.activity_home

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // region 设置适配器
        val homeAdapter = ListAdapter(itemList).apply {
            itemClickListener = this@HomeActivity
        }

        val layoutManager = LinearLayoutManager(this)
        rv_home.layoutManager = layoutManager
        rv_home.adapter = homeAdapter
        // endregion
    }

    override fun getItemNameList(): MutableList<String> {
        return mutableListOf<String>(
            "系统学习",
            "其他练习"
        )
    }

    override fun showTitle() {
        val tvTitle = findViewById<TextView>(R.id.tv_page_title)
        tvTitle.text = getString(R.string.app_name_cn)
    }

    // region Recyclerview 的 item 点击事件
    override fun onItemClick(position: Int) {
        when(position){
            // region 1. 打开「系统学习」
            0 -> openNextUI(BookTutorialActivity::class.java, itemList[position])
            // endregion

            // region 2. 打开「其他练习」
            1 -> showToast(getString(R.string.feature_right_now))
            // endregion
        }
    }
    // endregion
}