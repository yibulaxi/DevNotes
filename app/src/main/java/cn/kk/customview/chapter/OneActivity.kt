package cn.kk.customview.chapter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import cn.kk.customview.R
import cn.kk.customview.adpater.BasicViewViewPagerAdapter
import cn.kk.elementary.chapter1.*
import cn.kk.elementary.chapter1.path.BasicArcView
import cn.kk.elementary.chapter1.region.BasicRegion1View
import cn.kk.elementary.chapter1.region.BasicRegion2View
import cn.kk.elementary.chapter1.region.BasicRegion3View
import kotlinx.android.synthetic.main.activity_one.*

/**
 * 第一章，
 * 显示第一章的自定义 View 视图
 */
class OneActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)

        val viewList = mutableListOf<View>()
        viewList.add(BasicBackgroundView(this))
        viewList.add(BasicLineView(this))
        viewList.add(BasicRectView(this))
        viewList.add(BasicCircleView(this))
        viewList.add(BasicCircleRingView(this))
        viewList.add(BasicPointView(this))
        viewList.add(BasicArcView(this))
        viewList.add(BasicRegion1View(this))
        viewList.add(BasicRegion2View(this))
        viewList.add(BasicRegion3View(this))

        one_viewpager.apply {
            adapter = BasicViewViewPagerAdapter(viewList)
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }

    }
}