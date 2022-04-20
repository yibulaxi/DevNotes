package cn.kk.customview.activity

import android.webkit.WebChromeClient
import android.webkit.WebView
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R

/**
 * 通用显示网页
 */
class NormalWebViewActivity: BaseActivity() {
    override fun getLayout(): Int {
       return R.layout.activity_normal_webview
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()
        val webUrl = intent.getStringExtra(INTENT_WEB_URL_KEY).toString()
        val webView = findViewById<WebView>(R.id.web_view)

        webView.loadUrl(webUrl)
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = WebChromeClient()
    }

}