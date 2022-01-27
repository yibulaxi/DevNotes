package cn.kk.customview.appwidget

import android.content.Context
import android.graphics.Color
import android.widget.RemoteViews
import cn.kk.customview.R

 class KKAppWidgetNight: BaseKKAppWidget() {

    override fun onNightWidget(context: Context): RemoteViews {
        // 构造 RemoteViews 对象
        val views = RemoteViews(context.packageName, R.layout.k_k_app_widget_night)
        val widgetText = context.getString(R.string.appwidget_text_night)
        views.setTextViewText(R.id.appwidget_text, widgetText)
        views.setInt(R.id.container, "setBackgroundResource", Color.BLACK)
        return views
    }
}