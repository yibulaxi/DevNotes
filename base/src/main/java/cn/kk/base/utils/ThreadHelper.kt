package cn.kk.base.utils

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executors

object ThreadHelper {

    val executors = Executors.newCachedThreadPool()

    fun runOnUIThread(runnable: Runnable){
        Handler(Looper.getMainLooper()).post(runnable)
    }

    fun runTask(runnable: Runnable) {
        executors.execute(runnable)
    }

}