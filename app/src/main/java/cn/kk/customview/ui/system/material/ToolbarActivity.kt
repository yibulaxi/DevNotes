package cn.kk.customview.ui.system.material

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_toolbar.*

/**
 * 使用 Toolbar
 */
class ToolbarActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)

        setSupportActionBar(toolbar)
//        supportActionBar?.title = null
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.title
        toolbar.setNavigationOnClickListener { finish() }
    }
}