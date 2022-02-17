package cn.kk.base.utils

import android.os.Handler
import android.os.Looper

object ThreadHelper {

    fun runOnUIThread(runnable: Runnable){
        Handler(Looper.getMainLooper()).post(runnable)
    }
}