package cn.kk.customview.activity.more

import android.webkit.WebChromeClient
import android.webkit.WebView
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R

/**
 * 混合开发 总结
 */
class MixDevActivity: BaseActivity() {

    override fun getLayout(): Int {
       return R.layout.activity_mix_dev
    }

    val gitee_hub_url = "https://gitee.com/kamaihamaiha"
    val git_hub_url = "https://github.com/kamaihamaiha"

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        val webView = findViewById<WebView>(R.id.web_view)

        webView.loadUrl(gitee_hub_url)
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = WebChromeClient()
    }

}