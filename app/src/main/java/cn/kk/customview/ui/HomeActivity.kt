package cn.kk.customview.ui

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.activity.BaseActivity
import cn.kk.base.utils.ViewHelper
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
        showAppInfo()


        tv_app_info.setLayerType(View.LAYER_TYPE_SOFTWARE, null)

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
            "其他练习",
            "系统 UI",
            "页面跳转",
            "temp"
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
            1 -> openNextUI(ZhihuQuestionActivity::class.java, itemList[position])
            // endregion

            2 -> openNextUI(SystemUIActivity::class.java, itemList[position])
            // region 3. 打开「页面跳转」
            3 -> openNextUI(ZhihuQuestionActivity::class.java, itemList[position])
            // endregion

            // region 3. 打开「temp」
            4 -> openNextUI(TempActivity::class.java, itemList[position])
            // endregion
        }
    }
    // endregion

    fun showAppInfo(){
        val packageInfo = packageManager.getPackageInfo(packageName, 0)
        tv_app_info.text = "V".plus(packageInfo.versionName)
        ViewHelper.setShapeDualSemicircle(tv_app_info, Color.BLACK, 0.1f)

        /*// todo 读取 AndroidManifest.xml 的渠道信息
        val appInfo = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
        val channel = appInfo.metaData.getString("MTA_CHANNEL")
        if (channel != null){
            showToast(channel)
        }*/
    }

}