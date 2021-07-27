package cn.kk.elementary.chapter1.region

import android.content.Context
import android.graphics.*
import android.view.View

/**
 * Region
 * 1. setPath(@NonNull Path path, @NonNull Region clip): 根据路径的区域与某区域的交集构造出新的区域
 */
class BasicRegion1View(context: Context?) : BaseRegion(context) {
    val paint = Paint().apply {
        color = Color.RED
        style = Paint.Style.FILL
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 水平移动
        val offsetX = 400f
        // 构建椭圆路径
        val ovalPath = Path()
        val rect = RectF(50f, 50f, 200f, 500f)
        val targetLeft = rect.left + offsetX
        val targetRight= rect.right + offsetX
        val targetTop = rect.top
        val targetBottom = rect.bottom
        val rectTarget = RectF(targetLeft, targetTop, targetRight, targetBottom)

        // 添加椭圆路径
        ovalPath.addOval(rectTarget, Path.Direction.CCW)

        // 绘制椭圆参考图形
        canvas.drawPath(Path().apply {
                                     addOval(rect, Path.Direction.CCW)
        }, Paint().apply {
            color = Color.WHITE
            style = Paint.Style.STROKE
        })

        // 绘制矩形参考图形
        val rectSmall = RectF(rect.left, rect.top, rect.right, 200f)
        // 绘制矩形参考图形
        canvas.drawPath(Path().apply {
            addRect(rectSmall, Path.Direction.CCW)
        }, Paint().apply {
            color = Color.GREEN
            style = Paint.Style.STROKE
        })

        // 传入一个比椭圆小的矩形区域，让其取交集. bottom = 200
        val rgn = Region()
        rgn.setPath(ovalPath, Region(targetLeft.toInt(), targetTop.toInt(), targetRight.toInt(), 200))

        // 画出路径
        drawRegion(canvas, rgn, paint)
    }

    /**
     * 绘制区域
     *//*
    private fun drawRegion(canvas: Canvas, rgn: Region, paint: Paint) {
        val regionIterator = RegionIterator(rgn)
        val rect = Rect()
        while(regionIterator.next(rect)){
            canvas.drawRect(rect, paint)
        }
    }*/
}