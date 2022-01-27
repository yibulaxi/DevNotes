package cn.kk.customview.ui.system

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R

/**
 * 桌面小组件，跨进程通信
 */
class AppWidgetSample: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_app_widget
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

    }
}