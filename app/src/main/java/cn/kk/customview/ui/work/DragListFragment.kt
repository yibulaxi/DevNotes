package cn.kk.customview.ui.work

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.activity.BaseActivity
import cn.kk.base.adapter.ListV3Adapter
import cn.kk.base.bean.ListItemAction
import cn.kk.base.fragment.BaseFragment
import cn.kk.customview.R
import java.util.*

/**
 * RecyclerView item 长按拖拽
 */
class DragListFragment : BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.activity_normal_list
    }

    private lateinit var rvList: RecyclerView
    private val itemList by lazy {
        getItemNameList()
    }
    private val mAdapter by lazy {
        ListV3Adapter(itemList)
    }

    private fun getItemNameList(): MutableList<ListItemAction> {
        return mutableListOf<ListItemAction>().apply {
            add(ListItemAction("一"))
            add(ListItemAction("二"))
            add(ListItemAction("三"))
            add(ListItemAction("四"))
        }
    }

    lateinit var mItemTouchHelper: ItemTouchHelper


    val simpleCallback = object: ItemTouchHelper.SimpleCallback(
        ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END
    , 0) {

        override fun isLongPressDragEnabled(): Boolean {
            return true
        }

        override fun isItemViewSwipeEnabled(): Boolean {
            return false
        }

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            val fromPosition = viewHolder.adapterPosition
            val toPosition = target.adapterPosition

            Collections.swap(itemList, fromPosition, toPosition)
            rvList.adapter?.notifyItemMoved(fromPosition, toPosition)
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {


        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rootView.findViewById<View>(R.id.title).visibility = View.GONE
        rvList = rootView.findViewById<RecyclerView>(R.id.rv_list)
        rvList.layoutManager = LinearLayoutManager(context)
        rvList.adapter = mAdapter.apply {
            addChildClickViewIds(R.id.iv_sort)
            setOnItemChildClickListener { adapter, view, position ->
                if (view.id == R.id.iv_sort) {
                    mItemTouchHelper.startDrag(rvList.findViewHolderForAdapterPosition(position)!!)
                }
            }
        }

        mItemTouchHelper = ItemTouchHelper(simpleCallback)
        mItemTouchHelper.attachToRecyclerView(rvList)
    }

}