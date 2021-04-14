package cn.kk.customview.widget;

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.widget.GridView
import android.widget.TextView
import androidx.core.view.setPadding
import cn.kk.customview.utils.ValueUtil

/**
 * description: This is ...
 * Project: CustomeView
 * 创建人: zhangkx(张开旭)
 * 创建时间: 2021-04-12 2:08 AM
 */
private const val TAG = "AlertView"

class AlertView(context: Context?, attrs: AttributeSet?) : TextView(context, attrs) {
    val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val rect: RectF = RectF()
    val roundRX = ValueUtil.dp2px(8f)
    val roundRY = ValueUtil.dp2px(8f)

    constructor(context: Context?) : this(context, null)

    init {
        paint.apply {
            style = Paint.Style.STROKE
            setShadowLayer(10f,8f,8f,Color.BLACK)
        }
        setPadding(ValueUtil.dp2pxInt(10f),ValueUtil.dp2pxInt(12f),ValueUtil.dp2pxInt(10f),ValueUtil.dp2pxInt(4f))
        elevation = ValueUtil.dp2px(20f)
        gravity = Gravity.START
//        setBackgroundColor(Color.WHITE)

    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawARGB(0, 255, 255, 255)

        // 绘制边框形状
        rect.left = 8f
        rect.right = width.toFloat() - 8
        rect.top = ValueUtil.dp2px(10f)
        rect.bottom = height.toFloat() - 8f

        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        canvas.drawRoundRect(rect, roundRX, roundRY, paint)


        // 绘制三角形
        val path = Path()
        val siderSize = ValueUtil.dp2px(16f)

        val startAPX = width / 2f - siderSize / 2f
        val startAPY = rect.top



        path.moveTo(startAPX,startAPY)
        path.lineTo(width / 2f,0f)
        path.lineTo(startAPX + siderSize,startAPY)
        path.close()

        canvas.drawPath(path,paint)



    }
}