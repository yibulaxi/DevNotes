package cn.kk.customview

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_horizontalview.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var myEditTextViewLayout = R.layout.activity_main
        var myTextViewAndRectViewLayout = R.layout.activity_test
        var myTitleBarLayout = R.layout.my_titlebar
        var myImageViewLayout = R.layout.activity_imageview
        var mySurfaceViewLayout = R.layout.activity_surfaceview
        var myHorizontalViewLayout = R.layout.activity_horizontalview
        var weekViewLayout = R.layout.activity_weekview
        setContentView(weekViewLayout)

    }
}