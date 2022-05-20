package cn.kk.base.utils

import android.app.Service
import android.content.Context
import android.os.Vibrator

object SystemHelper {

    fun getAppInfo(context: Context){
        val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
    }

    /**
     * 震动
     * @param duration 震动时长，单位：ms
     */
    fun vibrate(ctx: Context, duration: Long){
        try {
            val vibrator = ctx.getSystemService(Service.VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrate(duration)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}