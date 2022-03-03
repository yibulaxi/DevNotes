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
        when(partType){
            UIConfig.PART_SYSTEM_STUDY -> {
                val title = itemList[position]
                when(position){
                    0 -> startNextUI(DrawBasicActivity::class.java, title)
                    1 -> startNextUI(AnimActivity::class.java, title)
                    2 -> startNextUI(DrawHomeActivity::class.java, title)
                    3 -> startNextUI(ViewHomeActivity::class.java, title)
                }
            }
        }
    }

    fun <T: Activity> startNextUI(targetActivity: Class<T>, title: String){
        (activity as BaseActivity).openNextUI(targetActivity, title)
    }
}