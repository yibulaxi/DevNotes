package cn.kk.base

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.Point
import android.view.View
import android.view.WindowInsetsController
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

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

    fun dip2px(context: Context?, dpValue: Double): Int {
        if (context == null) {
            return (dpValue * 2).toInt()
        }
        val scale: Float = context.getResources().getDisplayMetrics().density
        return (dpValue * scale + 0.5f).toInt()
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

    fun isLandscape(context: Context): Boolean {
        return context.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    }


    /**
     * 把颜色转换成 hex 字符串形式
     * @param color
     * @return
     */
    fun color2HexEncoding(color: Int): String? {
        var R: String
        var G: String
        var B: String
        val sb = StringBuffer()
        R = Integer.toHexString(Color.red(color))
        G = Integer.toHexString(Color.green(color))
        B = Integer.toHexString(Color.blue(color))
        //判断获取到的R,G,B值的长度 如果长度等于1 给R,G,B值的前边添0
        R = if (R.length == 1) "0$R" else R
        G = if (G.length == 1) "0$G" else G
        B = if (B.length == 1) "0$B" else B
        sb.append("0x")
        sb.append(R)
        sb.append(G)
        sb.append(B)
        return sb.toString()
    }

    fun color2HexEncodingEasy(color: Int): String{
        return Integer.toHexString(4)
    }

    fun toast(msg: String, context: Context){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    /**
     * 设置状态栏字体颜色为亮色
     */
     fun setStatusBarTextColorLight(context: Activity){
        context.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }

    /**
     * 设置状态栏字体颜色为暗色
     */
     fun setStatusBarTextColorDark(context: Activity){
        context.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }

    /**
     * 最新的，用 WindowInsetsController
     * 使用参考：https://juejin.cn/post/6940048488071856164
     */
    private fun setStatusBarTextColorLightNow(context: Activity){

    }
}