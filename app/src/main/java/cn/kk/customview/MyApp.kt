package cn.kk.customview

import android.app.Application
import cn.kk.customview.io.NetOkHttpHelper
import cn.kk.io.db.BookRepository

class MyApp: Application() {

    companion object {
        lateinit var application: Application
    }

    override fun onCreate() {
        super.onCreate()

        application = this

        // init Net okhttp helper
        NetOkHttpHelper.init(this)

        // init Database
        BookRepository.init(this)
    }
}