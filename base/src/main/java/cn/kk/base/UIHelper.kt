package cn.kk.base

import android.app.Activity
import android.graphics.Point

object UIHelper {

    fun getScreenSize(activity: Activity): Point {
        return Point(activity.windowManager.currentWindowMetrics.bounds.right, activity.windowManager.currentWindowMetrics.bounds.bottom)
    }
}