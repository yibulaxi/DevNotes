package cn.kk.customview.ui.system

import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import cn.kk.base.UIHelper
import cn.kk.base.activity.BaseActivity
import cn.kk.base.bean.ListItemAction
import cn.kk.customview.R

/**
 * 参考(https://www.bswen.com/2021/05/others-android-how-to-add-context-menu-to-recyclerview.html)
 */
class RecyclerViewContextMenu: BaseActivity() {

    override fun getLayout(): Int {
        return R.layout.activity_base_list
    }

    override fun setListViewID(): Int {
        return R.id.rv_list
    }

    override fun getItemNameList(): MutableList<ListItemAction> {
        return getItemActionList(arrayOf<String>("one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten", "1", "2", "3", "4", "5", "6", "7", "8"))
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        registerForContextMenu(rvList)
    }

    val DELETE_MENU_TAG = 100
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        // menu.add() or menuInflater.inflate(R.menu.menu_delete, menu)
        menu?.add(Menu.NONE, DELETE_MENU_TAG, Menu.NONE, R.string.delete)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            DELETE_MENU_TAG -> {
                showToast(listAdapter.getSelectItem().title)
            }
        }
        return super.onContextItemSelected(item)
    }
}