package cn.kk.customview.ui.system

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.UIHelper
import cn.kk.base.activity.BaseActivity
import cn.kk.base.adapter.ListV2Adapter
import cn.kk.base.bean.ListItemAction
import cn.kk.base.fragment.BaseFragment
import cn.kk.customview.R

/**
 * RecyclerView item 长按显示 Context Menu
 * 参考(https://www.bswen.com/2021/05/others-android-how-to-add-context-menu-to-recyclerview.html)
 */
class RecyclerViewContextMenuFragment: BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.activity_base_list
    }

    val mAdapter by lazy {
        ListV2Adapter(getItemActionList(arrayOf<String>("one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten", "1", "2", "3", "4", "5", "6", "7", "8")))

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rootView.findViewById<View>(R.id.home_title).visibility = View.GONE
        val rvList = rootView.findViewById<RecyclerView>(R.id.rv_list)
        rvList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvList.adapter = mAdapter

        registerForContextMenu(rvList)
    }

    val DELETE_MENU_TAG = 100
    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        activity?.menuInflater?.inflate(R.menu.menu_delete, menu)
    }



    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            DELETE_MENU_TAG, R.id.delete -> {
                showToast(mAdapter.getSelectItem().title)
            }
        }
        return super.onContextItemSelected(item)
    }
}