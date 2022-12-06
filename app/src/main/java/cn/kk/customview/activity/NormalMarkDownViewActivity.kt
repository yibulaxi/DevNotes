package cn.kk.customview.activity

import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import com.mukesh.MarkdownView
import kotlinx.android.synthetic.main.activity_normal_markdown_view.*

/**
 * 通用显示 Markdown 文件
 */
class NormalMarkDownViewActivity: BaseActivity() {
    lateinit var markDownView: MarkdownView
    override fun getLayout(): Int {
       return R.layout.activity_normal_markdown_view
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()
        val markDownPath = intent.getStringExtra(INTENT_MARKDOWN_PATH_KEY).toString()
        val local = intent.getBooleanExtra(INTENT_MARKDOWN_LOCAL_KEY, true)

        markDownView = findViewById(R.id.markdown_view)

        markDownView.settings.javaScriptEnabled = true
        markDownView.webChromeClient = WebChromeClient()

        if (local) {
            markDownView.loadMarkdownFromAssets(markDownPath)
        } else {
            markDownView.webViewClient = object : WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    refresh_view?.isRefreshing = false
                }
            }
            markDownView.loadUrl(markDownPath)
            // 延时show 加载，否则显示不出来
            markDownView.postDelayed({ refresh_view.isRefreshing = true }, 50)
        }

        // pull refresh
        refresh_view.setOnRefreshListener {
            if (!local) {
                markDownView.loadUrl(markDownPath)
                refresh_view.isRefreshing = true
            }
        }
    }

    override fun onBackPressed() {
        if (markDownView.canGoBack()) { // 处理网页返回
            markDownView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}