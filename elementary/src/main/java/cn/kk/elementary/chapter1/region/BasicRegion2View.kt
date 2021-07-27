package cn.kk.elementary.chapter1.region

import android.content.Context
import android.graphics.*
import android.view.View

/**
 * Region
 * 区域相交
 * 1. union() 合并区域
 */
class BasicRegion2View(context: Context?) : BaseRegion(context) {
    val paint = Paint().apply {
        color = Color.BLUE
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 1. union 使用
        val region = Region(10, 10, 200, 100)
        region.union(Rect(10, 10, 50, 300))

        drawRegion(canvas, region, paint)

    }
}