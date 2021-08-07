package cn.kk.base.activity

import androidx.appcompat.app.AppCompatActivity
import cn.kk.base.LogHelper

/**
 * Activity 基类
 */
abstract class BaseActivity: AppCompatActivity() {

    init {
        LogHelper.tag = this.javaClass.simpleName
    }


    /**
     * 输出日志
     */
    protected fun printLog(log: String){
        LogHelper.print(log)
    }
}