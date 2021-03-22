package cn.kk.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_test.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var myEditTextViewLayout = R.layout.activity_main
        var myTextViewAndRectViewLayout = R.layout.activity_test
        var myTitleBarLayout = R.layout.my_titlebar
        setContentView(myTextViewAndRectViewLayout)

        my_title_bar.setLeftListener {
            Toast.makeText(this, "left click!", Toast.LENGTH_SHORT).show()
        }

        my_title_bar.setRightListener {
            Toast.makeText(this, "right click", Toast.LENGTH_SHORT).show()
        }
    }
}