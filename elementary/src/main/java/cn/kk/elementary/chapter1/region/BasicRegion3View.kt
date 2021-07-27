package cn.kk.elementary.chapter1.region

import android.content.Context
import android.graphics.*
import android.view.View

/**
 * Region
 * 区域操作
 * 1. op()
 */
class BasicRegion3View(context: Context?) : BaseRegion(context) {
    val paintNormal = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
    }
    val paintOp = Paint().apply {
        color = Color.parseColor("#234432")
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

//        opSingle(canvas)

        for (index in 0 until 6){
            opDemo(index, index, canvas)
        }

    }

    fun opSingle(canvas: Canvas){
        // step1. 绘制 2 个矩形
        val rect1 = Rect(200, 300, 300, 600)
        val rect2 = Rect(100, 400, 400, 500)

        canvas.drawRect(rect1, paintNormal)
        canvas.drawRect(rect2, paintNormal)

        // step2. 绘制相交的部分
        val reg1 = Region(rect1)
        val reg2 = Region(rect2)
        reg1.op(reg2, Region.Op.INTERSECT)
        drawRegion(canvas, reg1, paintOp)
    }

    fun opDemo(index: Int, mode: Int, canvas: Canvas){
        val baseLeftVertical = 150
        val baseRightVertical = baseLeftVertical + 100
        val baseTopVertical = 300
        val baseBottomVertical = baseTopVertical + 300

        val cellInterval = 350

        val realLeftVertical = baseLeftVertical + index % 3 * cellInterval
        val realRightVertical = baseRightVertical + index % 3 * cellInterval
        val realTopVertical = baseTopVertical + index / 3 * cellInterval
        val realBottomVertical = baseBottomVertical + index / 3 * cellInterval

        val rectVertical = Rect(realLeftVertical, realTopVertical, realRightVertical, realBottomVertical)

        val baseLeftHorizontal = 50
        val baseRightHorizontal = baseLeftHorizontal + 300
        val baseTopHorizontal = 400
        val baseBottomHorizontal = 500

        val realLeftHorizontal = baseLeftHorizontal + index % 3 * cellInterval
        val realRightHorizontal = baseRightHorizontal + index % 3 * cellInterval
        val realTopHorizontal = baseTopHorizontal + index / 3 * cellInterval
        val realBottomHorizontal = baseBottomHorizontal + index / 3 * cellInterval

        val rectHorizontal = Rect(realLeftHorizontal, realTopHorizontal, realRightHorizontal, realBottomHorizontal)

        canvas.drawRect(rectVertical, paintNormal)
        canvas.drawRect(rectHorizontal, paintNormal)

        val regV = Region(rectVertical)
        val regH = Region(rectHorizontal)
        regV.op(regH, when(mode){
            0 ->  Region.Op.INTERSECT
            2 ->  Region.Op.DIFFERENCE
            3 ->  Region.Op.REPLACE
            4 ->  Region.Op.REVERSE_DIFFERENCE
            5 ->  Region.Op.UNION
            6 ->  Region.Op.XOR
            else -> Region.Op.INTERSECT
        })

        drawRegion(canvas, regV, paintOp)
    }
}