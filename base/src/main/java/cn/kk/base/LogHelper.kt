package cn.kk.base

import android.util.Log

/**
 * 日志帮助类
 */
object LogHelper {

    var tag: String = this.javaClass.simpleName


    fun print(log: String){
        Log.d(tag, log)
    }
}