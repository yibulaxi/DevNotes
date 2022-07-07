package cn.kk.customview.widget

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.VelocityTracker
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.VelocityTrackerCompat
import kotlin.math.abs

class FixFocusEditText(context: Context, attributeSet: AttributeSet) :
    AppCompatEditText(context, attributeSet) {

    private val TAG = "FixFocusEditText--"

    var mVelocityTracker: VelocityTracker?= null
    var curSelectedPos = -1
    var downSelectedPos = -1
    var moveFlag = false
    var clickFlag = false
    var smoothFlag = false
    var touchStamp = -1L

    override fun onTouchEvent(event: MotionEvent): Boolean {

        val pointerId = event.getPointerId(event.actionIndex)

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d(TAG, "onTouchEvent: selectedEnd: ${selectionEnd}")
                downSelectedPos = selectionEnd
                touchStamp = SystemClock.currentThreadTimeMillis()

                if (mVelocityTracker == null) {
                    mVelocityTracker = VelocityTracker.obtain()
                } else {
                    mVelocityTracker?.clear()
                }
            }
            MotionEvent.ACTION_MOVE -> {
                mVelocityTracker?.addMovement(event)
                mVelocityTracker?.computeCurrentVelocity(100)
                val xVelocity = VelocityTrackerCompat.getXVelocity(mVelocityTracker, pointerId)
                val yVelocity = VelocityTrackerCompat.getYVelocity(mVelocityTracker, pointerId)
//                Log.d(TAG, "onTouchEvent: xVelocity: ${xVelocity}, yVelocity: ${yVelocity}")
                moveFlag = abs(yVelocity) > 200

                clickFlag = abs(xVelocity) < 100 && abs(yVelocity) < 100
            }

            MotionEvent.ACTION_UP -> {
                if (clickFlag) {
                    if (SystemClock.currentThreadTimeMillis() - touchStamp < 300) {
                        isCursorVisible = true
                    } else {
                        clickFlag = false
                    }
                }
                smoothFlag = moveFlag
                moveFlag = false
            }

            MotionEvent.ACTION_CANCEL -> {
                mVelocityTracker?.recycle()
            }
            else -> {

            }
        }

        return super.onTouchEvent(event)

    }

    override fun onSelectionChanged(selStart: Int, selEnd: Int) {
        Log.d(TAG, "onSelectionChanged: selectedEnd: ${selectionEnd}")
        if (moveFlag) {
            isCursorVisible = false
            return
        }
        if (smoothFlag) isCursorVisible = false


        super.onSelectionChanged(selStart, selEnd)
    }
}