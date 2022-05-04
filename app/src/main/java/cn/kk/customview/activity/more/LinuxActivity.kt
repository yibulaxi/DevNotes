package cn.kk.customview.activity.more

import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.UIHelper
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.activity.BaseTabActivity
import cn.kk.customview.activity.NormalCardListActivity
import cn.kk.customview.activity.NormalWebViewActivity
import cn.kk.customview.bean.BaseItem
import cn.kk.customview.bean.BookModel
import cn.kk.customview.bean.ItemSimpleCard
import cn.kk.customview.factory.BookModelFactory
import cn.kk.customview.fragment.BookDetailFragment
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.activity_normal_list.*

/**
 * Linux 总结
 */
class LinuxActivity : BaseActivity() {

    override fun getLayout() = R.layout.activity_linux

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // region book detail part
        supportFragmentManager.beginTransaction().add(
            R.id.fragment_container,
            BookDetailFragment().apply {
                arguments = Bundle().apply { putSerializable(INTENT_MODEL_KEY, BookModelFactory.createBook(BaseItem.action_book_2)) }
            }).commit()
        
        // endregion

        // region bottom Card item
        rv_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_list.adapter = object : BaseQuickAdapter<ItemSimpleCard, BaseViewHolder>(
            R.layout.item_card_list_horzontal,
            getItemCardList()
        ) {
            override fun convert(holder: BaseViewHolder, item: ItemSimpleCard) {
                holder.setText(R.id.tv_name, item.title)
                holder.setVisible(R.id.iv_ok_flag, item.finish)
                holder.getView<CardView>(R.id.rootView)
                    .setCardBackgroundColor(UIHelper.generaRandomColor())
            }
        }.apply {
            setOnItemClickListener { adapter, view, position ->
                doWhenClickItem(data[position])

            }
        }

        // endregion
    }

    /**
     * 底部卡片具体信息集合
     */
    private fun getItemCardList(): MutableList<ItemSimpleCard> {
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
    private fun doWhenClickItem(item: ItemSimpleCard) {
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