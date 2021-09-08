package cn.kk.customview.ui

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import cn.kk.base.activity.BasicActivity
import cn.kk.base.adapter.QuestionFragmentAdapter
import cn.kk.customview.QuestionFragment
import cn.kk.customview.R
import cn.kk.customview.widget.HeaderView
import com.aspsine.swipetoloadlayout.OnRefreshListener
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout
import kotlinx.android.synthetic.main.activity_zhihu.*
import kotlinx.android.synthetic.main.header_view.*

/**
 * 仿知乎问答页面，切换效果
 */
class ZhihuQuestionActivity: BasicActivity(), OnRefreshListener, QuestionFragment.TopStateCallback {
    var curPageIndex = 0
    lateinit var headerView: HeaderView

    val loadPreCallback = object : HeaderView.onLoadPreCallback{
        override fun onLoad() {
            if (curPageIndex > 0){
                headerView.visibility = View.GONE
                viewPager.setCurrentItem(--curPageIndex, true)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zhihu)

        headerView = findViewById(R.id.swipe_refresh_header)
        headerView.onLoadPrepageListener = loadPreCallback
        swipeToLoadLayout.setOnRefreshListener(this@ZhihuQuestionActivity)

//        hideHeader()

        // 初始化 ViewPager
        val fragmentList: MutableList<Fragment> = mutableListOf()
        fragmentList.add(QuestionFragment("one").apply {
            topStateCallback = this@ZhihuQuestionActivity
        })
        fragmentList.add(QuestionFragment("two"))
        fragmentList.add(QuestionFragment("three"))
        fragmentList.add(QuestionFragment("four"))
        fragmentList.add(QuestionFragment("five"))
        fragmentList.add(QuestionFragment("six"))
        viewPager.adapter = QuestionFragmentAdapter(this, fragmentList)

        viewPager.isUserInputEnabled = false
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                curPageIndex = position
            }
        })

        btn_next.setOnClickListener {
            if (curPageIndex == fragmentList.size - 1){
                showToast("没有更多了")
                return@setOnClickListener
            }
            viewPager.setCurrentItem(++curPageIndex, true)
        }
    }

    override fun onRefresh() {
        // 模拟刷新需要 1000ms
        swipeToLoadLayout.postDelayed({ swipeToLoadLayout.isRefreshing = false },600)
    }

    override fun onTop() {
//        enableHeader()
    }

    override fun onNotTop() {
//        hideHeader()
    }

    fun hideHeader(){
        headerView.layoutParams = (headerView.layoutParams as SwipeToLoadLayout.LayoutParams).apply {
            height = 0
         Log.d(TAG, "hide Header: height= ${height}")
        }
    }

    fun enableHeader(){
        headerView.layoutParams = (headerView.layoutParams as SwipeToLoadLayout.LayoutParams).apply {
            height = 270
            Log.d(TAG, "enable Header: height= ${height}")
        }
    }
}