package cn.kk.customview

import android.app.Application
import cn.kk.customview.io.NetOkHttpHelper

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()

        // init Net okhttp helper
        NetOkHttpHelper.init(this)
    }
}