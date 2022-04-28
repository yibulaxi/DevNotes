package cn.kk.customview.ui.system

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.fragment.BaseFragment
import cn.kk.customview.R
import cn.kk.customview.adapter.ListAdapter

/**
 * RecyclerView 下面加 view
 */
class RecyclerViewAddViewDemoFragment: BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.activity_recyclerview_demo
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvList = rootView.findViewById<RecyclerView>(R.id.rv_list)

        rvList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ListAdapter(getItemActionList(arrayOf<String>("one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten", "1", "2", "3", "4", "5", "6")))
        }
    }
}