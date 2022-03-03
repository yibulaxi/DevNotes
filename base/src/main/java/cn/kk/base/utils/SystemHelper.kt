package cn.kk.base.utils

import android.content.Context

object SystemHelper {

    fun getAppInfo(context: Context){
        val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
    }
}