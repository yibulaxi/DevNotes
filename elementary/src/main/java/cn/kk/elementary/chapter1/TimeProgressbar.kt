package cn.kk.elementary.chapter1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import cn.kk.base.UIHelper
import cn.kk.base.utils.ThreadHelper
import java.util.*

const val PROGRESS_MAX = 1000
class TimeProgressbar(context: Context, attribute : AttributeSet?): View(context, attribute) {

    constructor(context: Context): this(context, null)

    private var mPaint: Paint = Paint().apply {
        color = Color.BLUE
        isAntiAlias = true
        textSize = UIHelper.dip2px(context, 12.0).toFloat()
    }

    // 时间，格式为：8.8s
    private var timeInfo = ""
    // 进度，0-100
    private var progress: Int = 0
    // 时长，单位:ms
    public var duration: Long = 5000
    // 刷新间隔时长，单位：ms
    private val refreshInterval = 20L
    private val textBottom = UIHelper.dip2px(context, 6.0)
    private val lineThick = UIHelper.dip2px(context, 1.5)
    private var diffProgress = 0
    private var currentDuration = 0L

    public var hideWhenFinished = false
    private var timer: Timer = Timer()


    init {


    }

    fun start(){
        // 计算每次刷新后，新增的进度
        diffProgress = PROGRESS_MAX / (duration / refreshInterval).toInt()
        // 执行定时任务
        timer.schedule(object : TimerTask(){
            override fun run() {
                ThreadHelper.runOnUIThread(Runnable { updateProgress() })
            }

        }, 0, refreshInterval)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val textTop = height - textBottom - lineThick
        var textLeft = 0f
        var textRight = 5f

        val paddingLeft = 0
        val paddingRight = 0
        val completeWidth = (width - paddingLeft - paddingRight) * 1.0 * progress / PROGRESS_MAX

        textLeft = (completeWidth - mPaint.measureText(timeInfo)).toFloat()
        if (textLeft < 0) textLeft = 0f
        if (progress >= PROGRESS_MAX) textLeft -= textRight

        canvas.drawText(timeInfo, textLeft, textTop.toFloat(), mPaint)

        canvas.drawRect(Rect(paddingLeft, height - lineThick, completeWidth.toInt(),  height), mPaint)
    }

    fun updateProgress(){
        if (progress >= PROGRESS_MAX) {
            timer.cancel()
            if (hideWhenFinished){
                visibility = INVISIBLE
            }
            return
        }
        this.progress += diffProgress
        currentDuration += refreshInterval
        if (currentDuration > duration) currentDuration = duration
        val second = currentDuration / 1000
        val hundredMillSecond = currentDuration % 1000 / 100
        timeInfo = String.format("%d.%ds", second, hundredMillSecond)
        invalidate()
    }

}