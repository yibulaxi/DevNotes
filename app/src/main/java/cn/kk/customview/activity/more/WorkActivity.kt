package cn.kk.customview.activity.more

import cn.kk.customview.R
import cn.kk.customview.activity.BaseTabActivity
import cn.kk.customview.activity.NormalCardListActivity
import cn.kk.customview.bean.BaseItem
import cn.kk.customview.bean.ItemSimpleCard
import cn.kk.customview.bean.SimpleWikiModel
import cn.kk.customview.ui.work.MenuDemoActivity
import cn.kk.customview.ui.work.RecyclerViewDemoActivity
import cn.kk.customview.ui.work.TextViewHtmlActivity

/**
 * 工作中总结
 */
class WorkActivity: NormalCardListActivity() {

    override fun getLayout() = R.layout.activity_normal_list

    override fun getListSpanCount() = 2

   override fun getItemCardList(): MutableList<ItemSimpleCard>{
        return mutableListOf<ItemSimpleCard>().apply {
            add(ItemSimpleCard("Intent 序列化传值", true).apply { item_action = BaseItem.ACTION_MORE_WORK_INTENT_SERIALIZABLE })
            add(ItemSimpleCard("RecyclerView 使用总结", true).apply { item_action = BaseItem.ACTION_MORE_WORK_REYCYCLER_VIEW })
            add(ItemSimpleCard("菜单 使用总结", true).apply { item_action = BaseItem.ACTION_MORE_WORK_MENU })
            add(ItemSimpleCard("EditText/TextView 高亮文本").apply { item_action = BaseItem.ACTION_MORE_WORK_TEXTVIEW_HIGHLIGHT })
            add(ItemSimpleCard("TextView 显示 html 格式").apply { item_action = BaseItem.ACTION_MORE_WORK_TEXTVIEW_HTML })
        }
    }

    override fun doWhenClickItem(item: ItemSimpleCard) {
        when(item.item_action) {
            BaseItem.ACTION_MORE_WORK_INTENT_SERIALIZABLE -> showWikiDialog(SimpleWikiModel(item.title, getString(R.string.intent_serial_wiki)))
            BaseItem.ACTION_MORE_WORK_REYCYCLER_VIEW -> openNextUI(RecyclerViewDemoActivity::class.java, item.title, BaseTabActivity.TabType.SystemUI.RECYCLER_VIEW_TYPE)
            BaseItem.ACTION_MORE_WORK_MENU -> openNextUI(MenuDemoActivity::class.java, item.title, BaseTabActivity.TabType.SystemUI.MENU_TYPE)
            BaseItem.ACTION_MORE_WORK_TEXTVIEW_HIGHLIGHT -> showToast(getString(R.string.not_yet))
            BaseItem.ACTION_MORE_WORK_TEXTVIEW_HTML -> openNextUI(TextViewHtmlActivity::class.java, item.title)
        }
    }

}