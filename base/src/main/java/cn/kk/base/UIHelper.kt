package cn.kk.base

import android.app.Activity
import android.graphics.Point
import android.widget.EditText

object UIHelper {

    fun getScreenSize(activity: Activity): Point {
        return Point(activity.windowManager.currentWindowMetrics.bounds.right, activity.windowManager.currentWindowMetrics.bounds.bottom)
    }

    fun getEditCursorY(edit: EditText): Int{
        edit.selectionEnd
        val line = edit.layout.getLineForOffset(edit.selectionEnd)
        val baseLine = edit.layout.getLineBaseline(line)
        val ascent = edit.layout.getLineAscent(line)
        val cursorY = baseLine + ascent
        return cursorY
    }

    fun getEditCursorYOnScreen(edit: EditText): Int{
        val point = IntArray(2)
        edit.getLocationOnScreen(point)
        return getEditCursorY(edit) + point[1]
    }
}