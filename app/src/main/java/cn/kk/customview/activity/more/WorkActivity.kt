package cn.kk.customview.activity.more

import cn.kk.customview.R
import cn.kk.customview.activity.BaseTabActivity
import cn.kk.customview.activity.NormalCardListActivity
import cn.kk.customview.bean.ItemSimpleCard
import cn.kk.customview.bean.SimpleWikiModel
import cn.kk.customview.ui.work.MenuDemoActivity
import cn.kk.customview.ui.work.RecyclerViewDemoActivity

/**
 * 工作中总结
 */
class WorkActivity: NormalCardListActivity() {

    override fun getLayout() = R.layout.activity_normal_list

    override fun getListSpanCount() = 2

   override fun getItemCardList(): MutableList<ItemSimpleCard>{
        return mutableListOf<ItemSimpleCard>().apply {
            add(ItemSimpleCard("Intent 序列化传值", true).apply { item_action = ItemSimpleCard.ACTION_MORE_WORK_INTENT_SERIALIZABLE })
            add(ItemSimpleCard("RecyclerView 使用总结", true).apply { item_action = ItemSimpleCard.ACTION_MORE_WORK_REYCYCLER_VIEW })
            add(ItemSimpleCard("菜单 使用总结", true).apply { item_action = ItemSimpleCard.ACTION_MORE_WORK_MENU })
        }
    }

    override fun doWhenClickItem(item: ItemSimpleCard) {
        when(item.item_action) {
            ItemSimpleCard.ACTION_MORE_WORK_INTENT_SERIALIZABLE -> showWikiDialog(SimpleWikiModel(item.title, getString(R.string.intent_serial_wiki)))
            ItemSimpleCard.ACTION_MORE_WORK_REYCYCLER_VIEW -> openNextUI(RecyclerViewDemoActivity::class.java, item.title, BaseTabActivity.TabType.SystemUI.RECYCLER_VIEW_TYPE)
            ItemSimpleCard.ACTION_MORE_WORK_MENU -> openNextUI(MenuDemoActivity::class.java, item.title, BaseTabActivity.TabType.SystemUI.MENU_TYPE)
        }
    }

}