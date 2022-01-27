package cn.kk.customview.appwidget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews

/**
 * Implementation of App Widget functionality.
 */
 abstract class BaseKKAppWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // 可能会有多个处于激活状态的小组件, 因此对他们更新
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for 当第一个小组件创建的时候
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for 当最后一个小组件不可用的时候
    }

    abstract  fun onNightWidget(context: Context): RemoteViews

    private fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {


        val remoteViews = onNightWidget(context)

        // 指示小部件管理器更新小部件
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews)
    }

}
