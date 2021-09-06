package cn.kk.base.activity

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cn.kk.base.LogHelper

abstract class BasicActivity: AppCompatActivity() {

    val TAG = this.javaClass.simpleName

    /**
     * 输出日志
     */
    protected fun printLog(log: String){
        LogHelper.print(log)
    }

    /**
     * 弹出信息，Toast 方式
     */
    protected fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    protected fun showToastLong(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}