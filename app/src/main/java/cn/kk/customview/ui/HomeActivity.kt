package cn.kk.customview.ui

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.adpater.HomeAdapter
import kotlinx.android.synthetic.main.activity_home.*

/**
 * 首页
 */
class HomeActivity: BaseActivity(), HomeAdapter.ItemClickListener {

    val list = mutableListOf<String>(
        "系统学习",
        "其他练习"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val tvTitle = findViewById<TextView>(R.id.tv_page_title)
        tvTitle.text = getString(R.string.app_name_cn)

        // region 设置适配器
        val homeAdapter = HomeAdapter(list).apply {
            itemClickListener = this@HomeActivity
        }

        val layoutManager = LinearLayoutManager(this)
        rv_home.layoutManager = layoutManager
        rv_home.adapter = homeAdapter
        // endregion
    }

    // region Recyclerview 的 item 点击事件
    override fun onItemClick(position: Int) {
        when(position){
            // region 1. 打开「系统学习」
            0 ->{
                startActivity(Intent(this, BookTutorialActivity::class.java).apply {
                    putExtra(INTENT_TITLE_KEY, list[position])
                })
                overridePendingTransition(R.anim.in_right, R.anim.out_left)
            }
            // endregion
            // region 2. 打开「其他练习」
            1 -> showToast(getString(R.string.feature_right_now))
            // endregion
        }
    }
    // endregion
}