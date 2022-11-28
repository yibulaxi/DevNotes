package cn.kk.customview.activity.work

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Picture
import android.os.SystemClock
import android.view.MotionEvent
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_webview_scroll_cap.*

class WebViewScrollCapActivity: BaseActivity() {
    val TEST_URL = "http://beta_dict.eudic.net/ting/articlepdf?mediaId=e81d9146-3b99-11ed-80da-005056863753"
    var capState = false
    override fun getLayout(): Int {
        /**
         * 5.0以上可能会显示保存不全，5.0以上进行了优化先渲染一部分，滚动再渲染导致，
         * 解决方案 Activity  setContent()之前设置渲染整个页面.
         *
         * 这么处理是最简单的
         */
        WebView.enableSlowWholeDocumentDraw()
        return R.layout.activity_webview_scroll_cap
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        val webView = findViewById<WebView>(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = object : WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                hideProgressDialog()
            }
        }

        showProgressDialog("loading...")
        webView.loadUrl(TEST_URL)

        btn_cap.setOnClickListener {
            if (capState) {
                iv_cap.visibility = View.INVISIBLE
                btn_cap.text = "截图"
            } else {
                btn_cap.text = "重置"
                val bitmap = captureWebView(webView)
                iv_cap.visibility = View.VISIBLE
                iv_cap.setImageBitmap(bitmap)
            }
            capState = !capState

        }
    }

    private fun capWebView(){
        val bitmap = Bitmap.createBitmap(webView.width, webView.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas()
        canvas.setBitmap(bitmap)
        webView.draw(canvas)

        val motionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
            MotionEvent.ACTION_DOWN, webView.width / 2f, webView.height / 2f, 0)

        webView.postDelayed(object : Runnable{
            override fun run() {
                motionEvent.action = MotionEvent.ACTION_MOVE
                motionEvent.setLocation(motionEvent.x, motionEvent.y - 1)
                webView.dispatchTouchEvent(motionEvent)
                webView.postDelayed(this, 300)
            }

        }, 300)
    }

    private fun captureWebView(webView: WebView): Bitmap? {
        val snapShot: Picture = webView.capturePicture()
        val bitmap = Bitmap.createBitmap(
            snapShot.getWidth(),
            snapShot.getHeight(), Bitmap.Config.ARGB_4444
        )
        val canvas = Canvas(bitmap)
        snapShot.draw(canvas)
        return bitmap
    }
}