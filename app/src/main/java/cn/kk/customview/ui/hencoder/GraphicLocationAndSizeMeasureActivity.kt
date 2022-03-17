package cn.kk.customview.ui.hencoder

import android.view.View
import androidx.fragment.app.Fragment
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.ui.fragment.NormalViewFragment
import cn.kk.elementary.anim.adapter.BaseFragmentAdapter
import com.example.hencoder.draw.DashBoardView
import com.example.hencoder.draw.PieView
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_base_sub_tab_viewpager.tabs
import kotlinx.android.synthetic.main.activity_base_sub_tab_viewpager.viewPager

/**
 * 图形的位置和尺寸测量
 * [DashBoardView] 和 [PieView]
 */
class GraphicLocationAndSizeMeasureActivity: BaseActivity() {
    val tabs_name = arrayOf("刻度盘","饼图")

    override fun getLayout(): Int {
       return R.layout.activity_base_sub_tab_viewpager
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()


        viewPager.adapter = BaseFragmentAdapter(this, mutableListOf<Fragment>().apply {

            add(DashBoardFragment())
            add(PieFragment())
        })

        // bind tabLayout and viewPager
        TabLayoutMediator(tabs, viewPager, true
        ) { tab, position ->
            tab.text =
                tabs_name[position]
        }.attach()
    }

    class DashBoardFragment: NormalViewFragment(){

        override fun getMyView(): View {
            return DashBoardView(requireContext())
        }
    }

    class PieFragment: NormalViewFragment(){
        override fun getMyView(): View {
            return PieView(requireContext())
        }
    }
}