package cn.kk.customview.widget

import android.annotation.SuppressLint
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
 * 3. 绘制选中区域端点. 默认是一星（第一个）
 * 4. 绘制选中区域背景
 * 5. 支持拖拽
 * 6. 支持放手后修正
 */
class VocabularyLevelBar(mContext: Context,val attributeSet: AttributeSet?): View(mContext,attributeSet) {
    val TAG = this::class.java.simpleName

    // 未选中背景颜色
    var normalBgColor: Int = ResourcesCompat.getColor(mContext.resources,R.color.grey_c,null)
    // 选中背景颜色
    var selectBgColor: Int = Color.BLUE
    // 未选中的单词等级导航点颜色
    var normalVocabularyAnchorColor: Int = ResourcesCompat.getColor(mContext.resources,R.color.grey_8,null)
    // 选中的单词等级导航点颜色
    var selectedAnchorColor: Int = Color.WHITE
    // 选中的单词等级端点圆环颜色
    var selectedAnchorRingColor: Int = Color.GREEN

    // 画笔
    // 画笔- 背景
    val paintNormalBg = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = normalBgColor }
    // 画笔- 锚点未选中
    val paintAnchorNormal = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = normalVocabularyAnchorColor
        style = Paint.Style.FILL
    }
    // 画笔- 锚点选中
    val paintAnchorSelected = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = selectedAnchorRingColor
        style = Paint.Style.STROKE
    }


    // 数字参数
    // 1. 单词等级锚点左右间距
    val selectedPointMargin = ValueUtil.dp2px(30f)
    // 2. 单词等级数量
    val levelCount = 5
    // 3. 单词等级锚点，半径
    val levelAnchorRadius = ValueUtil.dp2px(8f)
    // 4. 单词等级区间，头和尾圆环，半径
    val selectedLevelRingRadius by lazy {
        height / 2f
    }
    val startLevel = 0

    // 锚点数组
    val anchorsArray = arrayOfNulls<PointF>(5)

    init {


        viewTreeObserver.addOnGlobalLayoutListener {
            paintAnchorSelected.apply {
                strokeWidth = selectedLevelRingRadius - levelAnchorRadius
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

        // 3. 绘制选中区间的端点
        paintAnchorSelected.strokeWidth = (height / 2f - levelAnchorRadius)
        paintAnchorSelected.style = Paint.Style.STROKE
        canvas.drawCircle(anchorFirstP.x, anchorFirstP.y, levelAnchorRadius + (paintAnchorSelected.strokeWidth / 2),paintAnchorSelected)

    }

    /**
     * 获取绘制圆形的区域
     */
    private fun getOvalRegion(anchorFirstP: PointF): RectF {
        val anchorFirstRectF = RectF(
            anchorFirstP.x - levelAnchorRadius / 2f,
            anchorFirstP.y - levelAnchorRadius / 2f,
            anchorFirstP.x + levelAnchorRadius / 2f,
            anchorFirstP.y + levelAnchorRadius / 2f
        )
        return anchorFirstRectF
    }

    private fun getOvalRingRegion(anchorFirstP: PointF): RectF {
        val diffR = (selectedLevelRingRadius - levelAnchorRadius)
        val anchorFirstRectF = RectF(
            anchorFirstP.x - selectedLevelRingRadius + diffR,
            anchorFirstP.y - selectedLevelRingRadius + diffR,
            anchorFirstP.x + selectedLevelRingRadius - diffR ,
            anchorFirstP.y + selectedLevelRingRadius - diffR
        )
        return anchorFirstRectF
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
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
    }

}