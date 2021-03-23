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
        setContentView(myHorizontalViewLayout)


        // 自定义组合控件
        /* my_title_bar.setLeftListener {
             Toast.makeText(this, "left click!", Toast.LENGTH_SHORT).show()
         }

         my_title_bar.setRightListener {
             Toast.makeText(this, "right click", Toast.LENGTH_SHORT).show()
         }*/

        // 初始化 HorizontalView 里面的 ListView
        val nums = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13")
        val letters = arrayOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "G", "H", "I", "J")
        val numEnglish = arrayOf(
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen"
        )

        val firstAdapter: ArrayAdapter<*> =
            ArrayAdapter<Any?>(application, android.R.layout.simple_expandable_list_item_1, nums)
        val secondAdapter: ArrayAdapter<*> =
            ArrayAdapter<Any?>(application, android.R.layout.simple_expandable_list_item_1, letters)
        val thirdAdapter: ArrayAdapter<*> =
            ArrayAdapter<Any?>(application, android.R.layout.simple_expandable_list_item_1, numEnglish)

        list_view_1.adapter = firstAdapter
        list_view_2.adapter = secondAdapter
        list_view_3.adapter = thirdAdapter
    }
}