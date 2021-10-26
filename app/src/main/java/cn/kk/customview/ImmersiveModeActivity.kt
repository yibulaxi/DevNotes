package cn.kk.customview

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import androidx.appcompat.app.AppCompatActivity

/**
 * 沉浸式模式
 * [郭霖博客文章](https://mp.weixin.qq.com/s/CjFUKHIz6bQZaKw46Lj7VQ)
 */
class ImmersiveModeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_immersive_mode)
        // 两个 Flag 结合使用，表示让应用主题内容占用系统状态栏的空间
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        // 设置系统状态栏颜色为透明
        window.statusBarColor = Color.TRANSPARENT
    }
}