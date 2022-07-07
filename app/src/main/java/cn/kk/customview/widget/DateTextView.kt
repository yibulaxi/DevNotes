package cn.kk.customview.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import cn.kk.base.UIHelper

/**
 * 显示日期：左上是月份，右下是日期。中间用斜线分开
 */
class DateTextView(context: Context, attributeSet: AttributeSet): View(context, attributeSet) {
    val paint = Paint().apply { textSize =  UIHelper.dp2px(40f)}
    val paintLine = Paint().apply {
        style = Paint.Style.FILL_AND_STROKE
        strokeWidth = 10f
    }
    val offsetContentY = UIHelper.dp2px(8f) // 字体距离 ascent、descent 线的留白容错空间
    private val fontMetrics = Paint.FontMetrics()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 第一行基线
        val firstBaseLineY = 200f
        paint.getFontMetrics(fontMetrics)

        canvas.drawText("May", 0f, firstBaseLineY, paint)

        // 行高
        val lineHeight = fontMetrics.bottom - fontMetrics.top
        val lineContentHeight = fontMetrics.descent - fontMetrics.ascent

        // 第一行内容顶部线
        val firstAscentLineY = firstBaseLineY + fontMetrics.ascent
        // 第一行内容底部线
        val firstDescentLineY = firstBaseLineY + fontMetrics.descent
        // 第二行基线
        val secondBaseLine = firstBaseLineY + lineHeight
        // 第二行内容顶部线
        val secondAscentLineY = secondBaseLine + fontMetrics.ascent
        // 第二行内容底部线
        val secondDescentLineY = secondBaseLine + fontMetrics.descent

        // 两行的中线
        val midLineY = (firstAscentLineY + secondDescentLineY) / 2

        val firstLineContentWidth = paint.measureText("May")
        val secondLineContentWidth = paint.measureText("24")
        val totalContentWidth = firstLineContentWidth + secondLineContentWidth

        // 总高度
        val totalContentHeight = (fontMetrics.bottom - fontMetrics.top) * 2


        canvas.drawText("24", firstLineContentWidth, secondBaseLine, paint)

        // 画线
//        canvas.drawLine(0f, firstAscentLineY, totalContentWidth, firstAscentLineY, paint)
//        canvas.drawLine(0f, firstDescentLineY, totalContentWidth, firstDescentLineY, paint)
//        canvas.drawLine(0f, midLineY, totalContentWidth + 50, midLineY, paint)
//        canvas.drawLine(0f, secondAscentLineY, totalContentWidth, secondAscentLineY, paint)
//        canvas.drawLine(0f, secondDescentLineY, totalContentWidth, secondDescentLineY, paint)

        canvas.drawLine(totalContentWidth - (lineContentHeight * 2), secondDescentLineY - offsetContentY, totalContentWidth, firstAscentLineY + offsetContentY, paintLine)


    }
}