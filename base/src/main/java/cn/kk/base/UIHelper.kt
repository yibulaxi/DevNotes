package cn.kk.base

import android.app.Activity
import android.content.res.Configuration
import android.graphics.Point
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

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

    fun getCurrentTheme(activity: AppCompatActivity): Int{
        if ((activity.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES){
           return R.style.Theme_Night
        }
        return R.style.Theme_Default
    }
}