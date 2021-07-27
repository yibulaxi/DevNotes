package cn.kk.elementary.chapter1.region

import android.content.Context
import android.graphics.*
import android.view.View

open class BaseRegion(context: Context?) : View(context) {

    protected fun drawRegion(canvas: Canvas, region: Region, paint: Paint){
        val regionIterator = RegionIterator(region)
        val rect = Rect()
        while(regionIterator.next(rect)){
            canvas.drawRect(rect, paint)
        }
    }
}