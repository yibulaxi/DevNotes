package cn.kk.customview.appwidget

import android.content.Context
import android.graphics.Color
import android.widget.RemoteViews
import cn.kk.customview.R

open class KKAppWidgetNight: KKAppWidget() {

     override fun setColors(context: Context): RemoteViews{

         val views = RemoteViews(context.packageName, R.layout.kk_app_widget)
         val widgetText = context.getString(R.string.appwidget_text)
         views.setTextViewText(R.id.appwidget_text, widgetText)
         views.setInt(R.id.container, "setBackgroundColor", Color.BLACK)

         return views
     }
}