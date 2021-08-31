package cn.kk.base.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cn.kk.base.LogHelper
import cn.kk.base.R

/**
 * Activity 基类
 */
abstract class BaseActivity: AppCompatActivity() {
    val TAG = this.javaClass.simpleName
    protected val INTENT_TITLE_KEY = "title"
    private val title by lazy {
        intent.getStringExtra(INTENT_TITLE_KEY)
    }
    private var slideAnimExit = false

    /**
     * 具体的子类，要用到的 item 列表
     */
    protected val itemList: MutableList<String> by lazy {
        getItemNameList()
    }

    init {
        LogHelper.tag = this.javaClass.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarTrans()
        setContentView(getLayout())

        doWhenOnCreate()
    }

    override fun onStart() {
        super.onStart()
        clickTitleBack()
    }

    override fun finish() {
        super.finish()
        if (slideAnimExit){
            overridePendingTransition(R.anim.in_left, R.anim.out_right)
        }
    }

    /**
     * 要加载的布局
     */
    abstract fun getLayout(): Int

    /**
     * onCreate() 中的操作
     */
    protected open fun doWhenOnCreate(){

       showTitle()
    }

    protected  open fun getItemNameList(): MutableList<String>{
        // 如果子类不重写，默认就返回空的集合。
        return mutableListOf()
    }

    protected open fun showTitle(){
        val tvTitle = findViewById<TextView>(R.id.tv_page_title)
        tvTitle.text = title
        tvTitle.setOnLongClickListener(object : View.OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {
               showToast(TAG)
                return true
            }

        })
    }

    /**
     * 返回按钮点击
     */
    private fun clickTitleBack(){
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

    protected fun showToastLong(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
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

    protected fun <T: Activity> openNextUI(targetActivity: Class<T>, title: String){
        startActivity(Intent(this, targetActivity).apply {
            putExtra(INTENT_TITLE_KEY, title)
        })
        slideAnimEnter()
    }

    private fun slideAnimEnter(){
        slideAnimExit = true
        overridePendingTransition(R.anim.in_right, R.anim.out_left)
    }
}