package cn.kk.elementary.drawview.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * 自定义的文字 View
 *
 * 1. 基线
 *  1. drawText(text, x, y, paint)：x,y 是基线原点坐标
 *  2. Paint -> textAlign: Paint.Align.LEFT、CENTER、RIGHT 用来描述绘制的原点，相对于文字绘制矩形区域的位置。
 *  3. 上面的相对位置是根据所要绘制文字所在的矩形来计算的。
 * 2. 四线格: ascent, descent, top, bottom
 * 3. FontMetrics
 */
class MyTextView(context: Context?, attributeSet: AttributeSet) : View(context, attributeSet) {


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // region 绘制基线和文字
        // 0. 基线原点
        val baseLineX = 0f
        val baseLineY = 200f

        val lineLength = 800f
        val lineHeight = 300f

        // region 1. 绘制文字. 原点在绘制矩形区域的左侧
        val paint = Paint().apply {
            color = Color.GRAY
        }
        // region 1.1 绘制基线
        canvas.drawLine(baseLineX, baseLineY, baseLineX + lineLength, baseLineY, paint)
        // endregion

        // region 1.2 绘制文字
        canvas.drawText("harvic\'s blog", baseLineX, baseLineY, paint.apply {
            textSize = 120f
            textAlign = Paint.Align.LEFT
            color = Color.BLUE })
        // endregion
        // endregion

        // region 2. 原点在绘制矩形区域的正中间。因此少了一半的文字
        canvas.drawLine(baseLineX, baseLineY + lineHeight, baseLineX + lineLength, baseLineY + lineHeight, paint)
        canvas.drawText("harvic\'s blog", baseLineX, baseLineY + lineHeight, paint.apply {
            textSize = 120f
            textAlign = Paint.Align.CENTER
            color = Color.BLUE })
        // endregion

        // region 3. 原点在绘制矩形区域的右侧，文字在矩形绘制区域看不到了。
        canvas.drawLine(baseLineX, baseLineY + lineHeight * 2, baseLineX + lineLength, baseLineY + lineHeight * 2, paint)
        canvas.drawText("harvic\'s blog", baseLineX, baseLineY + 2 * lineHeight, paint.apply {
            textSize = 120f
            textAlign = Paint.Align.RIGHT
            color = Color.BLUE })
        // endregion

        // region 4. 绘制字母：A。只会显示一半内容。
        canvas.drawLine(baseLineX, baseLineY + lineHeight * 3, baseLineX + lineLength, baseLineY + lineHeight * 3, paint)
        canvas.drawText("A", baseLineX, baseLineY + 3 * lineHeight, paint.apply {
            textSize = 120f
            textAlign = Paint.Align.CENTER
            color = Color.BLUE })
        // endregion

        // region 绘制出四线格，和基线
        val baseLineX2 = 0f
        val baseLineY2 = 1600f

        // 1. 绘制基线
        canvas.drawLine(baseLineX2, baseLineY2, baseLineX2 + lineLength, baseLineY2, paint.apply { color = Color.BLACK })

        // 2. 获取 FontMetrics 对象, 然后绘制 4 条线
        val fontMetrics = paint.fontMetrics
        val ascentY = fontMetrics.ascent + baseLineY2
        val descentY = fontMetrics.descent + baseLineY2
        val topY = fontMetrics.top + baseLineY2
        val bottomY = fontMetrics.bottom + baseLineY2
        canvas.drawLine(baseLineX2, ascentY, baseLineX2 + lineLength, ascentY, paint.apply { color = Color.GREEN })
        canvas.drawLine(baseLineX2, descentY, baseLineX2 + lineLength, descentY, paint.apply { color = Color.GREEN })
        canvas.drawLine(baseLineX2, topY, baseLineX2 + lineLength, topY, paint.apply { color = Color.RED })
        canvas.drawLine(baseLineX2, bottomY, baseLineX2 + lineLength, bottomY, paint.apply { color = Color.RED })

        // 3. 绘制文字
        canvas.drawText("harvic\'s blog", baseLineX2, baseLineY2, paint.apply {
            textSize = 120f
            textAlign = Paint.Align.LEFT
            color = Color.BLUE })
        // endregion

    }
}