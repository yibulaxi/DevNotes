package cn.kk.customview.appwidget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.widget.RemoteViews
import cn.kk.base.UIHelper
import cn.kk.customview.R
import cn.kk.customview.utils.SystemUtil

/**
 * Implementation of App Widget functionality.
 */
 open class KKAppWidget : AppWidgetProvider() {
    private  val TAG = "KKAppWidget"

    val ACTION_CONFIGURATION_CHANGED = "CONFIGURATION_CHANGED"
    val ACTION_UPDATE = "android.appwidget.action.APPWIDGET_UPDATE_OPTIONS"

    var darkMode: Boolean = false

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action.equals(ACTION_UPDATE)){
            Log.d(TAG, "onReceive: configuration changed. .. 1 ..")
            darkMode = UIHelper.isSystemDarkModeOpened(context)

            AppWidgetManager.getInstance(context).updateAppWidget(
                ComponentName(context, KKAppWidget::class.java),
                setColors(context)
            )
        } else {
            Log.d(TAG, "onReceive: action: ${intent.action}")
        }
        super.onReceive(context, intent)
    }

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

    protected open fun setColors(context: Context): RemoteViews{
        val views = RemoteViews(context.packageName, R.layout.kk_app_widget)
        val themeBgColor = if (darkMode) Color.BLACK else Color.WHITE
        val widgetText = context.getString(R.string.appwidget_text).plus(if(darkMode) "- black" else "- white")
        views.setTextViewText(R.id.appwidget_text, widgetText)
        views.setTextViewText(R.id.tv_info, "是否支持MIUI widget: ${SystemUtil.isMiuiWidgetSupported(context)}\n 是否是 Pad: ${SystemUtil.checkTablet(context)}")

        views.setInt(R.id.container, "setBackgroundColor", themeBgColor)

        return views
    }

    private fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {

        Log.d(TAG, "updateAppWidget: ...")
        val remoteViews = setColors(context)

        // 指示小部件管理器更新小部件
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews)
    }

}
