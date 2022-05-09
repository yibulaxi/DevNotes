package cn.kk.customview.activity.more

import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.UIHelper
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.activity.BaseMixListActivity
import cn.kk.customview.activity.BaseTabActivity
import cn.kk.customview.activity.NormalWebViewActivity
import cn.kk.customview.bean.BaseItem
import cn.kk.customview.bean.ItemSimpleCard
import cn.kk.customview.factory.BookModelFactory
import cn.kk.customview.fragment.BookDetailFragment
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.activity_normal_list.*

/**
 * Linux 总结
 * 页面说明：
 *  分上下两部分：按照章节的列表、水平滑动的卡片列表
 */
class LinuxActivity : BaseMixListActivity() {

    override fun getBookAction(): Int= BaseItem.action_book_linux


    /**
     * 底部卡片具体信息集合
     */
    override fun getItemCardList(): MutableList<ItemSimpleCard> {
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

    /**
     * 底部卡片点击跳转
     */
    override fun doWhenClickItem(item: ItemSimpleCard) {
        when (item.item_action) {
            BaseItem.ACTION_MORE_LINUX_BETTER_CAT ->
                openNextUI(
                    NormalWebViewActivity::class.java,
                    item.title,
                    BaseTabActivity.TabType.SystemUI.RECYCLER_VIEW_TYPE,
                    item.web_url
                )
            BaseItem.ACTION_MORE_LINUX_MAC_TRANS_LINUX ->
                openNextUI(
                    NormalWebViewActivity::class.java,
                    item.title,
                    BaseTabActivity.TabType.SystemUI.RECYCLER_VIEW_TYPE,
                    item.web_url
                )
        }
    }

}