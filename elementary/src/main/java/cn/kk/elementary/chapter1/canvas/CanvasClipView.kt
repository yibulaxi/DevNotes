package cn.kk.elementary.chapter1.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.view.View

/**
 * Canvas
 * 裁剪画布：clip
 * 是指利用 clip 系列函数，通过与 Rect、Path、Region 取交、并、差等集合运算来获得最新的画布形状。
 * 除调用 save()、restore() 函数以外，这个操作是不可逆的，一旦 Canvas 被裁剪，就不能恢复
 *
 * 注意：在使用 clip 系列函数时，要禁用硬件加速功能
 * setLayerType(LAYER_TYPE_SOFTWARE, null)
 */
class CanvasClipView(context: Context?) : View(context) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 以 clipRect() 为例
        canvas.drawColor(Color.RED)
        canvas.clipRect(Rect(100, 100, 200, 200))
        canvas.drawColor(Color.GREEN)
    }
}