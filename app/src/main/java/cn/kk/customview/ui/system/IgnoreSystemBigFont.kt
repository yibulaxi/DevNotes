package cn.kk.customview.ui.system

import android.content.res.Configuration
import android.content.res.Resources
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R

/**
 * 忽略系统大字体
 *
 * 系统设置大字体时，如果字体的单位设置为 sp，那么字体也会跟着变换
 */
class IgnoreSystemBigFont: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_ignore_sys_big_font
    }

    override fun ignoreSystemFontSize(): Boolean {
        // 不忽略
        return false
    }
}