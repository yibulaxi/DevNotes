package cn.kk.customview.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import cn.kk.base.activity.BasicActivity
import cn.kk.base.adapter.QuestionFragmentAdapter
import cn.kk.customview.QuestionFragment
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_zhihu.*

/**
 * 仿知乎问答页面，切换效果
 */
class ZhihuQuestionActivity: BasicActivity() {
    var curPageIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zhihu)


        // 初始化 ViewPager
        val fragmentList: MutableList<Fragment> = mutableListOf()
        fragmentList.add(QuestionFragment("first"))
        fragmentList.add(QuestionFragment("second"))
        fragmentList.add(QuestionFragment("third"))
        viewPager.adapter = QuestionFragmentAdapter(this, fragmentList)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                curPageIndex = position
                printLog("curPageIndex: ${curPageIndex}")
            }
        })

        btn_next.setOnClickListener {
            printLog("curPageIndex click: ${curPageIndex}")
            if (curPageIndex == fragmentList.size - 1){
                showToast("没有更多了")
                return@setOnClickListener
            }
            viewPager.setCurrentItem(++curPageIndex, true)
        }
    }
}