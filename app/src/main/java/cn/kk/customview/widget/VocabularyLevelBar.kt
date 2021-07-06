package cn.kk.customview.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat
import cn.kk.customview.R
import cn.kk.customview.utils.ValueUtil

/**
 * 单词等级拖动条
 * 1. 绘制背景 ok
 * 2. 绘制单词等级锚点 ok
 * 3. 绘制选中区域背景
 * 4. 绘制选中区域端点. 默认是一星（第一个）ok
 * 5. 支持拖拽
 * 6. 支持放手后修正
 */
class VocabularyLevelBar(mContext: Context,val attributeSet: AttributeSet?): View(mContext,attributeSet) {
    val TAG = this::class.java.simpleName

    // 未选中背景颜色
    var normalBgColor: Int = ResourcesCompat.getColor(mContext.resources,R.color.grey_c,null)
    // 选中背景颜色
    var selectBgColor: Int = ResourcesCompat.getColor(mContext.resources,R.color.ting_color_alpha20,null)
    // 未选中的单词等级导航点颜色
    var normalVocabularyAnchorColor: Int = ResourcesCompat.getColor(mContext.resources,R.color.grey_8,null)
    // 选中的单词等级导航点颜色
    var selectedAnchorColor: Int = Color.WHITE
    // 选中的单词等级端点圆环颜色
    var selectedAnchorRingColor: Int = ResourcesCompat.getColor(mContext.resources,R.color.ting_color,null)

    // 画笔
    // 画笔- 背景
    val paintNormalBg = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = normalBgColor }
    val paintSelectedBg = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = selectBgColor }
    // 画笔- 锚点未选中
    val paintAnchorNormal = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = normalVocabularyAnchorColor
        style = Paint.Style.FILL
    }
    // 画笔- 锚点选中
    val paintAnchorSelected = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = selectedAnchorColor
        style = Paint.Style.FILL
    }
    // 画笔- 锚点选中圆环
    val paintAnchorRingSelected = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = selectedAnchorRingColor
        style = Paint.Style.STROKE
    }


    // 数字参数
    // 1. 单词等级锚点左右间距
    val selectedPointMargin = ValueUtil.dp2px(30f)
    // 2. 单词等级数量
    val levelCount = 5
    // 3. 单词等级锚点，半径
    val levelAnchorRadius = ValueUtil.dp2px(5f)
    // 4. 单词等级区间，头和尾圆环，半径.
    val selectedLevelRingRadius by lazy {
        levelAnchorRadius + (paintAnchorRingSelected.strokeWidth / 2)
    }
    val startLevel = 0

    // 锚点数组
    val anchorsArray = arrayOfNulls<PointF>(5)

    init {

        viewTreeObserver.addOnGlobalLayoutListener {
            paintAnchorRingSelected.apply { // 初始化圆环画笔的宽度
                strokeWidth = height / 2 - levelAnchorRadius
            }
        }

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 1. 绘制基本背景形状. 两头是半圆的矩形
        val t = 0f
        val b = height.toFloat()
        val l = 0f
        val r = width.toFloat()
        val rectBg = RectF(l, t, r, b)
        val radiusBg: Float = (height / 2).toFloat()
        canvas.drawRoundRect(rectBg,radiusBg,radiusBg,paintNormalBg)

        // 2. 绘制单词等级锚点
        // 2-1 计算所有锚点的圆心
        // 2-1-1 计算第一个锚点的圆心
        val anchorFirstP = PointF(selectedPointMargin,height / 2f)
        anchorsArray[0] = anchorFirstP

        // 2-1-2 计算其他锚点的圆心
        // 计算锚点之间的间隔, 并绘制
        val intervalAnchorMargin = (width - selectedPointMargin * 2) / (levelCount - 1)
        for (index in 1 until levelCount) {
            val curAnchorP = PointF(selectedPointMargin + intervalAnchorMargin * index, height / 2f)
            Log.d(TAG, "onDraw: curAnchorP.x: ${curAnchorP.x}")
            anchorsArray[index] = curAnchorP
            canvas.drawCircle(curAnchorP.x, curAnchorP.y, levelAnchorRadius, paintAnchorNormal)
        }
        canvas.drawCircle(anchorFirstP.x, anchorFirstP.y,levelAnchorRadius,paintAnchorNormal)


        // 3. 绘制选中区域背景
        val selectAreaPath = Path().apply {
            moveTo(anchorsArray[1]!!.x, 0f)
            lineTo(anchorsArray[3]!!.x, 0f)
            lineTo(anchorsArray[3]!!.x,height.toFloat())
            lineTo(anchorsArray[1]!!.x, height.toFloat())
            close()
        }
        canvas.drawPath(selectAreaPath,paintSelectedBg)

        // 4. 绘制选中锚点区间的端点
        drawSelectAnchor(1,canvas)
        drawSelectAnchor(3,canvas)

    }

    /**
     * 绘制选中区域锚点
     * 1. 内部实心圆形：白色
     * 2. 外部是圆环，蓝色，充满了拖动条高度
     * 固定的位置
     */
    fun drawSelectAnchor(index: Int, canvas: Canvas){
        val curP = anchorsArray[index]
        //  绘制圆环
        canvas.drawCircle(curP!!.x, curP!!.y, selectedLevelRingRadius,paintAnchorRingSelected)
        // 3-2 重新绘制小圆
        canvas.drawCircle(curP!!.x, curP!!.y, levelAnchorRadius, paintAnchorSelected)
    }


    /*override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(measureMyWidth(widthMeasureSpec),measureMyHeight(heightMeasureSpec))
    }

   private fun measureMyWidth(measureSpec: Int): Int{
        val specMode = MeasureSpec.getMode(measureSpec)
        val specWidth = MeasureSpec.getSize(measureSpec)

        return when(specMode){
            MeasureSpec.UNSPECIFIED -> specWidth
            MeasureSpec.AT_MOST -> measuredWidth
            MeasureSpec.EXACTLY -> specWidth
            else -> 0
        }
    }
    private fun measureMyHeight(measureSpec: Int): Int{
        val specMode = MeasureSpec.getMode(measureSpec)
        val specWidth = MeasureSpec.getSize(measureSpec)

        return when(specMode){
            MeasureSpec.UNSPECIFIED -> specWidth
            MeasureSpec.AT_MOST -> measuredWidth
            MeasureSpec.EXACTLY -> specWidth
            else -> 0
        }
    }*/

}