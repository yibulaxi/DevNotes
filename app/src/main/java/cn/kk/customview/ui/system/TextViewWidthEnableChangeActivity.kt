package cn.kk.customview.ui.system

import cn.kk.customview.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_textview_enable_change.*

/**
 * view 高度：0.5dp、1dp、2dp
 */
class TextViewWidthEnableChangeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textview_enable_change)


        btn_more.setOnClickListener {
            tv_info.append(".")
        }
    }
}