package cn.kk.customview.ui.system

import cn.kk.customview.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_textview_enable_change.*

/**
 * 可变的 TextView 最后要限制 maxWidth 
 */
class TextViewWidthEnableChangeActivity: AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textview_enable_change)


        btn_more.setOnClickListener {

            if (count % 2 == 0){
                tv_info.append("_")
            } else {
                tv_info.append(".")
            }

            count++
        }
    }
}