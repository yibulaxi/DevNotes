package cn.kk.base.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cn.kk.base.LogHelper
import cn.kk.base.R

/**
 * Activity 基类
 */
abstract class BaseActivity: AppCompatActivity() {
    protected val INTENT_TITLE_KEY = "title"
    init {
        LogHelper.tag = this.javaClass.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarTrans()
    }

    override fun onStart() {
        super.onStart()
        clickTitleBack()
    }

    protected fun clickTitleBack(){
        findViewById<ImageButton>(R.id.btn_title_back).setOnClickListener {
            finish()
        }
    }

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

    /**
     * 设置状态栏透明，且独自占用空间
     */
    private fun setStatusBarTrans(){
        // 表示让应用主题内容占据系统状态栏的空间
        val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.decorView.systemUiVisibility = option

        // 状态栏透明
        window.statusBarColor = Color.TRANSPARENT
    }
}