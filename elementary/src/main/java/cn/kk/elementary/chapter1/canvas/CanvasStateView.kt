package cn.kk.elementary.chapter1.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.view.DragEvent
import android.view.View

/**
 * Canvas 保存与恢复
 */
class CanvasStateView(context: Context?) : View(context) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 绘制颜色
        canvas.drawColor(Color.GRAY)

        // 保存当前画布：大小
        canvas.save()

        // 裁剪画布
        canvas.clipRect(300, 300, 500, 500)
        canvas.drawColor(Color.BLUE)

        // 恢复画布, 然后再绘制颜色：green
        canvas.restore()
        canvas.drawColor(Color.GREEN)
    }
}