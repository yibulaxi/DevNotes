package cn.kk.customview.activity.work

import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebView
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R

class WebViewOperaLogsToClientActivity: BaseActivity() {
    val TEST_URL = "http://cn.frdic.com/testlog.html"

    override fun getLayout(): Int {
        return R.layout.activity_support_logs_for_web
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        val webView = findViewById<WebView>(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = WebChromeClient()
        webView.addJavascriptInterface(NativeClientLog(), "print_log")
        webView.loadUrl(TEST_URL)
    }

    class NativeClientLog{

        /**
         * @param userId 目录路径
         * @param logType 文件名
         * @param log 日志
         */
        @JavascriptInterface
        fun writeLog(userId: String, logType: String, log: String){
            // save log to text file
            Log.d("NativeClientLog--", "writeLog: userId: ${userId}, logType: ${logType}, log: ${log}")
        }

        /**
         * @param lineCount  <= 0 全部 , > 0  倒数多少行
         */
        @JavascriptInterface
        fun readLog(userId: String, logType: String, lineCount: Int){

        }
    }
}