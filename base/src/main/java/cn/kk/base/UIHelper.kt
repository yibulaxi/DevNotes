package cn.kk.base

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ForegroundColorSpan
import android.util.TypedValue
import android.view.TouchDelegate
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cn.kk.base.utils.PatternHelper


object UIHelper {

    // region dip px
    fun dip2px(context: Context?, dpValue: Double): Int {
        if (context == null) {
            return (dpValue * 2).toInt()
        }
        val scale: Float = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * 该方法不需要传入上下文
     */
    fun dp2px(value: Float): Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, Resources.getSystem().displayMetrics)
    // endregion

    // region EditText cursor
    fun getEditCursorYOnScreen(edit: EditText): Int{
        val point = IntArray(2)
        edit.getLocationOnScreen(point)
        return getEditCursorY(edit) + point[1]
    }

    fun getEditCursorY(edit: EditText): Int{
        edit.selectionEnd
        val line = edit.layout.getLineForOffset(edit.selectionEnd)
        val baseLine = edit.layout.getLineBaseline(line)
        val ascent = edit.layout.getLineAscent(line)
        val cursorY = baseLine + ascent
        return cursorY
    }
    // endregion

    // region Highlight
    fun highlightTag(textView: TextView, highlightColor: Int) {
        val ss = SpannableString(textView.getText())
        val matcher = PatternHelper.patternTag.matcher(ss)
        while (matcher.find()) {
            if (matcher.start() >= 0 && matcher.end() > matcher.start() + 1) {
                ss.setSpan(
                    ForegroundColorSpan(highlightColor),
                    matcher.start(),
                    matcher.end(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }
        textView.movementMethod = LinkMovementMethod.getInstance()
        textView.text = ss
    }
    // endregion

    // region Theme
    fun getCurrentTheme(activity: AppCompatActivity): Int{
        if ((activity.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES){
           return R.style.Theme_Night
        }
        return R.style.Theme_Default
    }
    // endregion

    // region configuration
    fun isLandscape(context: Context): Boolean {
        return context.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    }

    fun isSystemDarkModeOpened(ctx: Context?): Boolean {
        return if (ctx == null) {
            false
        } else ctx.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    }

    // endregion

    // region Screen

    fun getScreenSize(activity: Activity): Point {
        return Point(activity.windowManager.currentWindowMetrics.bounds.right, activity.windowManager.currentWindowMetrics.bounds.bottom)
    }

    // endregion


    // region Toast
    fun toast(msg: String, context: Context){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
    // endregion

    // region status bar

     fun setStatusBarTrans(ctx: Activity){
        // 表示让应用主题内容占据系统状态栏的空间
        val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
         ctx.window.decorView.systemUiVisibility = option

        // 状态栏透明
         ctx.window.statusBarColor = Color.TRANSPARENT
    }

    fun setStatusBarDark(context: Activity){
        setStatusBarColor(context, Color.BLACK)
        setStatusBarTextColorLight(context)
    }

    fun setStatusBarColor(context: Activity, color: Int){
        context.window.statusBarColor = color
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
    // endregion

    // region color 相关
    fun colorInt2Hex(color: Int): String{
        return String.format("#%06X", (0xFFFFFF and color))
    }

    /**
     * 生成随机颜色
     */
    fun generaRandomColor(): Int {
        val redValue = ValueHelper.getRandomValue(0, 255)
        val greenValue = ValueHelper.getRandomValue(0, 255)
        val blueValue = ValueHelper.getRandomValue(0, 255)
      return  Color.rgb(redValue, greenValue, blueValue)
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

    // endregion

    // region bitmap and drawable
    fun bitmap2Drawable(bitmap: Bitmap, context: Context): Drawable{
        return BitmapDrawable(context.resources, bitmap)
    }

    fun drawable2Bitmap(drawable: Drawable): Bitmap{
        if (drawable is BitmapDrawable) return drawable.bitmap
        if (drawable.intrinsicWidth <= 0 ||drawable.intrinsicHeight <=0){
            return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)
        } else {
            return Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        }
        var bitmap: Bitmap
        val canvas = Canvas(bitmap)
        drawable.apply {
            setBounds(0, 0, canvas.width, canvas.height)
            draw(canvas)
        }
        return bitmap
    }
    // endregion

    // region click

    /**
     * 扩大控件大点击范围
     * @param view
     * @param expendSize
     */
    fun expendTouchArea(view: View?, expendSize: Int) {
        if (view != null) {
            val parentView = view.parent as View
            parentView.post {
                val rect = Rect()
                //如果太早执行本函数，会获取rect失败，因为此时UI界面尚未开始绘制，无法获得正确的坐标
                view.getHitRect(rect)
                rect.left -= expendSize
                rect.top -= expendSize
                rect.right += expendSize
                rect.bottom += expendSize
                parentView.touchDelegate = TouchDelegate(rect, view)
            }
        }
    }

    // endregion

    // anim

    /**
     * 改变展开状态
     */
     fun changeExpandUI(expandState: Boolean, arrowView: View){
        val rotateAnim = RotateAnimation(if (expandState) -90f else 0f, if (expandState) 0f else -90f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f).apply {
            duration = 300
            fillAfter = true
        }
        arrowView.startAnimation(rotateAnim)
    }

    // endregion

}