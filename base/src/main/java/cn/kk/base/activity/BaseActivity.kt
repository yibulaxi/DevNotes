package cn.kk.base.activity

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.LogHelper
import cn.kk.base.R
import cn.kk.base.UIHelper
import cn.kk.base.adapter.ListV2Adapter
import cn.kk.base.bean.ListItemAction

/**
 * Activity 基类
 */
abstract class BaseActivity: BasicActivity() {
    protected val INTENT_TITLE_KEY = "title"
    protected val INTENT_TYPE_KEY = "type"

    protected lateinit var mSelf: Activity
    protected var baseToolbar: Toolbar?= null

    private val title by lazy {
        intent.getStringExtra(INTENT_TITLE_KEY)
    }
    protected val ui_type by lazy {
        intent.getIntExtra(INTENT_TYPE_KEY, -1)
    }
    private var slideAnimExit = false

    protected  var rvList: RecyclerView? =null

    /**
     * 具体的子类，要用到的 item 列表
     */
    protected val itemList: MutableList<ListItemAction> by lazy {
        getItemNameList()
    }

    protected val listAdapter: ListV2Adapter by lazy {
        ListV2Adapter(itemList)
    }

    init {
        LogHelper.tag = this.javaClass.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme()
        super.onCreate(savedInstanceState)
        setStatusBarTrans()
        setContentView(getLayout())

        mSelf = this
        baseToolbar = findViewById(R.id.toolBar)

        rvList = findViewById(setListViewID())

        doWhenOnCreate()
    }

    fun setTheme(){
        // 设置主体

        val theme = UIHelper.getCurrentTheme(this)
        super.setTheme(theme)
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

    protected open fun setListViewID(): Int{
        return -1
    }

    /**
     * onCreate() 中的操作
     */
    protected open fun doWhenOnCreate(){
        showTitle()
        initAdapter()
    }

    protected  open fun getItemNameList(): MutableList<ListItemAction>{
        // 如果子类不重写，默认就返回空的集合。
        return mutableListOf()
    }

    open fun getItemActionList(names: Array<String>, finishTag: Boolean = false): MutableList<ListItemAction> {
        val list = mutableListOf<ListItemAction>()
        for (name in names) {
            list.add(ListItemAction(name, finishTag))
        }
        return list
    }

    protected open fun showTitle(){
        val tvTitle = findViewById<TextView>(R.id.tv_page_title)
        tvTitle?.text = title
        tvTitle?.setOnLongClickListener {
            showToast(TAG)
            true
        }

        // long click toolbar
       baseToolbar?.setOnLongClickListener {
           showToast(TAG)
           true
       }
    }

    protected open fun initAdapter(){
        if (rvList == null) {
            return
        }
        rvList!!.layoutManager = LinearLayoutManager(this)

        rvList!!.adapter = listAdapter
    }

    /**
     * 返回按钮点击
     */
    private fun clickTitleBack(){
        findViewById<ImageButton>(R.id.btn_title_back)?.setOnClickListener {
            finish()
        }
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

    /**
     * 打开下一个页面
     */
    open fun <T: Activity> openNextUI(targetActivity: Class<T>, title: String){
        startActivity(Intent(this, targetActivity).apply {
            putExtra(INTENT_TITLE_KEY, title)
        })
        slideAnimEnter()
    }

    /**
     * 打开下一个页面
     */
    open fun <T: Activity> openNextUI(targetActivity: Class<T>, title: String, type: Int){
        startActivity(Intent(this, targetActivity).apply {
            putExtra(INTENT_TITLE_KEY, title)
            putExtra(INTENT_TYPE_KEY, type)
        })
        slideAnimEnter()
    }

    /**
     * 忽略系统字体大小
     * 默认忽略
     */
    protected open fun ignoreSystemFontSize(): Boolean = true

    private fun slideAnimEnter(){
        slideAnimExit = true
        overridePendingTransition(R.anim.in_right, R.anim.out_left)
    }

    override fun getResources(): Resources {
        return if (ignoreSystemFontSize()) createConfigurationContext(Configuration().apply { setToDefaults() }).resources else super.getResources()
    }
}