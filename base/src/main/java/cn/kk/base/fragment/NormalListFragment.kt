package cn.kk.base.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.R
import cn.kk.base.adapter.ListAdapter

class NormalListFragment: BaseFragment(), ListAdapter.ItemClickListener {

    private val itemList = mutableListOf<String>()

    override fun getLayoutId(): Int {
        return R.layout.fragment_normal_list
    }

    fun addItem(item: String): NormalListFragment{
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

    }
}