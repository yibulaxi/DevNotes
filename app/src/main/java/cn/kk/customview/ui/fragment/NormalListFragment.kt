package cn.kk.customview.ui.fragment

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.R
import cn.kk.base.activity.BaseActivity
import cn.kk.base.adapter.ListAdapter
import cn.kk.base.fragment.BaseFragment
import cn.kk.customview.chapter.c1.DrawBasicActivity
import cn.kk.customview.chapter.c2.AnimActivity
import cn.kk.customview.chapter.c3.DrawHomeActivity
import cn.kk.customview.chapter.c4.ViewHomeActivity
import cn.kk.customview.config.UIConfig
import cn.kk.customview.ui.HomeActivity
import cn.kk.customview.ui.activity.HomeNewActivity
import cn.kk.customview.ui.system.*
import cn.kk.customview.ui.system.drawable.DrawableSample
import cn.kk.customview.ui.system.material.MaterialActivity

class NormalListFragment: BaseFragment(), ListAdapter.ItemClickListener {

    private val itemList = mutableListOf<String>()
    var partType = -1

    override fun getLayoutId(): Int {
        return R.layout.fragment_normal_list
    }

    fun addItem(item: String): NormalListFragment {
        itemList.add(item)
        return this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvList = view.findViewById<RecyclerView>(R.id.rv_list_in_fragment)

        rvList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ListAdapter(itemList).apply {
                itemClickListener = this@NormalListFragment
            }
        }
    }

    override fun onItemClick(position: Int) {
        // 跳转页面
        val title = itemList[position]
        when(partType){
            UIConfig.PART_SYSTEM_STUDY -> {
                when(position){
                    0 -> startNextUI(DrawBasicActivity::class.java, title)
                    1 -> startNextUI(AnimActivity::class.java, title)
                    2 -> startNextUI(DrawHomeActivity::class.java, title)
                    3 -> startNextUI(ViewHomeActivity::class.java, title)
                }
            }
            UIConfig.PART_SYSTEM_UI -> {
                when(position){
                    0 -> startNextUI(ImageViewActivity::class.java, title)
                    1 -> startNextUI(DialogActivity::class.java, title)
                    2 -> startNextUI(ImmersiveModeActivity::class.java, title)
                    3 -> startNextUI(CoordinatorLayoutActivity::class.java, title)
                    4 -> startNextUI(CoordinatorLayoutAndCollapsingToolbarLayoutActivity::class.java, title)
                    5 -> startNextUI(CustomBehaviorActivity::class.java, title)
                    6 -> startNextUI(StatusBarActivity::class.java, title)
                    7 -> startNextUI(LineHeightActivity::class.java, title)
                    8 -> startNextUI(MaterialActivity::class.java, title)
                    9 -> startNextUI(TextViewWidthEnableChangeActivity::class.java, title)
                    10 ->startNextUI(TextViewWithDrawableActivity::class.java, title)
                    11 ->startNextUI(IgnoreSystemBigFont::class.java, title)
                    12 ->startNextUI(HtmlText::class.java, title)
                    13 ->startNextUI(AppWidgetSample::class.java, title)
                    14 ->startNextUI(DrawableSample::class.java, title)
                }
            }
        }
    }

    fun <T: Activity> startNextUI(targetActivity: Class<T>, title: String){
        (activity as BaseActivity).openNextUI(targetActivity, title)
    }
}