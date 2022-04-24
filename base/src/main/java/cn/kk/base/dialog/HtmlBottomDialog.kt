package cn.kk.base.dialog

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import cn.kk.base.R
import cn.kk.base.activity.BaseActivity
import cn.kk.base.bean.HtmlWikiModel

class HtmlBottomDialog(mActivity: BaseActivity, val wikiModel: HtmlWikiModel ,theme: Int = R.style.EdgeToEdgeDialogStyle): BaseBottomDialog(mActivity, theme) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_html_wiki_bottom)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        findViewById<View>(R.id.btn_exit)?.setOnClickListener { dismiss() }

        val webView = findViewById<WebView>(R.id.webview_wiki)

        webView?.loadUrl(wikiModel.htmlFilePath)
        webView?.settings?.javaScriptEnabled = true
        webView?.webChromeClient = WebChromeClient()
    }
}