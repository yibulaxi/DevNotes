package cn.kk.customview.activity.more

import cn.kk.customview.R
import cn.kk.customview.activity.BaseTabActivity
import cn.kk.customview.activity.NormalCardListActivity
import cn.kk.customview.activity.NormalWebViewActivity
import cn.kk.customview.bean.BaseItem
import cn.kk.customview.bean.ItemSimpleCard

/**
 * Linux 总结
 */
class LinuxActivity: NormalCardListActivity() {

    override fun getLayout() = R.layout.activity_normal_list

    override fun getListSpanCount() = 3

    override fun getItemCardList(): MutableList<ItemSimpleCard>{
        return mutableListOf<ItemSimpleCard>().apply {
            add(ItemSimpleCard("比 cat 更好用的命令", true).apply {
                item_action = BaseItem.ACTION_MORE_LINUX_BETTER_CAT
                web_url = "https://mp.weixin.qq.com/s/jDYgI-HIuE3ez8K3EA8WoA"
            })
            add(ItemSimpleCard("我为什么从 Mac 转到 Linux", true).apply {
                item_action = BaseItem.ACTION_MORE_LINUX_MAC_TRANS_LINUX
                web_url = "https://mp.weixin.qq.com/s/yMR66tjAM4a3Dkaw-MovVg"
            })
        }
    }

    override fun doWhenClickItem(item: ItemSimpleCard) {
       when(item.item_action) {
           BaseItem.ACTION_MORE_LINUX_BETTER_CAT ->
               openNextUI(NormalWebViewActivity::class.java, item.title, BaseTabActivity.TabType.SystemUI.RECYCLER_VIEW_TYPE, item.web_url)
           BaseItem.ACTION_MORE_LINUX_MAC_TRANS_LINUX ->
               openNextUI(NormalWebViewActivity::class.java, item.title, BaseTabActivity.TabType.SystemUI.RECYCLER_VIEW_TYPE, item.web_url)
       }
    }

}