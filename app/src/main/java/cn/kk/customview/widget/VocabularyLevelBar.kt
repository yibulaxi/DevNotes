package cn.kk.customview.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.core.content.res.ResourcesCompat
import cn.kk.customview.R
import cn.kk.customview.utils.ValueUtil

/**
 * 单词等级拖动条
 * 1. 绘制背景 ok
 * 2. 绘制单词等级锚点 ok
 * 3. 绘制选中区域背景 ok
 * 4. 绘制选中区域端点. 默认是一星（第一个）ok
 * 5. 支持拖拽
 * 6. 支持放手后修正
 * 7. 支持按下后更新区间，抬起手后修正区间
 */

// 单词等级默认 5个 级别
val DEFAULT_VOCABULARY_LEVEL_COUNT = 5

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

    val paintPressTemp = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
    }


    // 数字参数
    // 1. 单词等级锚点左右间距
    val selectedPointMargin = ValueUtil.dp2px(30f)
    // 2. 单词等级数量
    val levelCount = DEFAULT_VOCABULARY_LEVEL_COUNT
    // 3. 单词等级锚点，半径
    val levelAnchorRadius = ValueUtil.dp2px(5f)
    // 4. 单词等级区间，选中圆环，半径（绘制时的半径）.
    val selectedLevelRingRadius by lazy {
        levelAnchorRadius + (paintAnchorRingSelected.strokeWidth / 2)
    }
    // 5.  单词等级区间，选中圆环，半径（视觉上真实的半径）
    val selectedLevelVersionRealRadius by lazy {
        levelAnchorRadius + paintAnchorRingSelected.strokeWidth
    }

    // 选中的最低等级. 默认是 1星
    var startLevel = 0

    // 选中的最高等级. 默认是 1星
    var endLevel = 0

    // 锚点数组
    val anchorsArray = arrayOfNulls<PointF>(levelCount)

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

        correctLevelRegion()

        if (startLevel != endLevel) {
            canvas.drawPath(Path().apply {
                moveTo(anchorsArray[startLevel]!!.x, 0f)
                lineTo(anchorsArray[endLevel]!!.x, 0f)
                lineTo(anchorsArray[endLevel]!!.x, height.toFloat())
                lineTo(anchorsArray[startLevel]!!.x, height.toFloat())
                close()
            }, paintSelectedBg)
        }

        // 4. 绘制选中锚点区间的端点
        drawSelectAnchor(startLevel, canvas)
        if (startLevel != endLevel) {
            drawSelectAnchor(endLevel, canvas)
        }

        // 5. 绘制临时实心球
        if (pressEvent || moveEvent){
            canvas.drawCircle(currentPressP.x, currentPressP.y,10f,paintPressTemp)
        } else {
            if (closestAnchorIndex != -1) {
                val anchorCenterPWhenUP = getAnchorCenterP(closestAnchorIndex)
                canvas.drawCircle(anchorCenterPWhenUP.x, anchorCenterPWhenUP.y, 10f, paintPressTemp)
            }
        }
        
    }

    /**
     * 修正单词等级范围
     */
    private fun correctLevelRegion() {
        endLevel = Math.max(0, endLevel)
        endLevel = Math.min(endLevel, levelCount - 1)
        startLevel = Math.max(0, startLevel)
        startLevel = Math.min(startLevel, endLevel)
    }

    /**
     * 获取锚点圆心
     * @param index 如果 index 范围超过正常范围，则返回第一个锚点圆心
     */
    private fun getAnchorCenterP(index: Int): PointF{
        if (index < 0 || index >= anchorsArray.size) return anchorsArray[0]!!
        return anchorsArray[index]!!
    }

    /**
     * 按下时，是否可以拖拽选中的锚点
     */
    private fun canDragWhenTouch(selectedLevel: Int, touchX: Float, touchY: Float): Boolean{
        var index = selectedLevel
        if (selectedLevel != startLevel && selectedLevel != endLevel){
            index = startLevel
        }
        val startAnchorCenterP = getAnchorCenterP(index)
        val diffX = Math.abs(touchX - startAnchorCenterP.x)
        val diffY = Math.abs(touchY - startAnchorCenterP.y)
        val distanceSquare = diffX * diffX + diffY * diffY
        if (distanceSquare < selectedLevelVersionRealRadius * selectedLevelVersionRealRadius){
            return true
        }
        return false
    }

    // 是否能腿拽
    var canDraft = false
    var lastTouchX = -1f
    var pressEvent = false
    var moveEvent = false

    // 当前手机按下的点
    var currentPressP = PointF()

    // 手指抬起后，最近的锚点索引
    var closestAnchorIndex = -1

    override fun onTouchEvent(event: MotionEvent?): Boolean {


        // 5. 处理拖拽
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                // 记录按下屏幕的区域
                printLog("按压屏幕：${event.x}, ${event.x}")

                // 判断按下区域，是否在选中锚点区域。
                // 如果按下的点 距离锚点圆心小于，锚点圆环的半径，那么就在选中区域里面, => 就可以拖拽
                val startAnchorCenterP = getAnchorCenterP(startLevel)
                val diffX = Math.abs(event.x - startAnchorCenterP.x)
                val diffY = Math.abs(event.y - startAnchorCenterP.y)
                val distanceSquare = diffX * diffX + diffY * diffY
                if (distanceSquare < selectedLevelVersionRealRadius * selectedLevelVersionRealRadius){
                    canDraft = true
                }

                canDraft = canDragWhenTouch(startLevel, event.x, event.y)

                if (!canDraft && startLevel != endLevel){
                    // 如果上面的不能拖拽，再判断高等级的锚点圆心距离
                    canDraft = canDragWhenTouch(endLevel, event.x, event.y)
                }

                printLog("可拖拽：$canDraft")
                if (canDraft){
                    lastTouchX = event.x
                }

                // 处理按下后，选中圆环的最新位置（临时，手指离开屏幕后需要规正）
                pressEvent = true

                currentPressP.apply {
                    x = event.x
                    y = height / 2f
                }
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                canDraft = false
                pressEvent = false
                moveEvent = false
                // todo 离开屏幕，寻找最近的
                printLog("离开屏幕：${event.x}, ${event.x}")

                closestAnchorIndex = findClosestAnchor(event.x)
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                moveEvent = true
                currentPressP.apply {
                    x = event.x
                    y = height / 2f
                }
                invalidate()

                printLog("拖动：${event.x}, ${event.x}")
                if (!canDraft){
                    return false
                }
                // 计算水平移动距离，屏蔽掉 y 轴的拖动
                val moveDistanceX = event!!.x - lastTouchX
                printLog("水平移动：${moveDistanceX}")
                // 绘制临时圆环
                // 获取触摸点最近的锚点圆环圆心坐标
                val closestRingPoint = getAnchorCenterP(startLevel)
                val tempRingCenterP = PointF().apply {
                    x = closestRingPoint.x + moveDistanceX
                    y = closestRingPoint.y
                }
//                drawSelectAnchor(startLevel,)
            }

        }

        lastTouchX = event!!.x
        return true
    }

    /**
     * 寻找最近的锚点
     */
    private fun findClosestAnchor(x: Float): Int {
        var targetAnchorIndex = 0
        var minDistance = Math.abs(x - anchorsArray[0]!!.x)
        for (index in 1 until anchorsArray.size){
            val tempDistance = Math.abs(x - anchorsArray[index]!!.x)
            if (minDistance > tempDistance){
                minDistance = tempDistance
                targetAnchorIndex = index
            }
        }
        return targetAnchorIndex
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


    /**
     * 打印日志
     */
    fun printLog(info: String){
        Log.d(TAG, "printLog: $info")
    }


}