package cn.kk.customview.activity.more

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import cn.kk.base.UIHelper
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.activity.BaseTabActivity
import cn.kk.customview.activity.NormalWebViewActivity
import cn.kk.customview.bean.ItemSimpleCard
import cn.kk.customview.bean.SimpleWikiModel
import cn.kk.customview.ui.work.RecyclerViewDemoActivity
import cn.kk.customview.widget.dialog.NormalWikiBottomDialog
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.activity_normal_list.*

/**
 * Linux 总结
 */
class LinuxActivity: BaseActivity() {

    override fun getLayout(): Int {
       return R.layout.activity_normal_list
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        rv_list.layoutManager = GridLayoutManager(this, 2)
        rv_list.adapter = object :  BaseQuickAdapter<ItemSimpleCard, BaseViewHolder>(R.layout.item_card_list, getItemCardList()){
            override fun convert(holder: BaseViewHolder, item: ItemSimpleCard) {
                holder.setText(R.id.tv_name, item.title)
                holder.setVisible(R.id.iv_ok_flag, item.finish)
                holder.getView<CardView>(R.id.rootView).setCardBackgroundColor(UIHelper.generaRandomColor())
            }
        }.apply {
            setOnItemClickListener { adapter, view, position ->
                val title = data[position].title
                when(data[position].item_action) {
                    ItemSimpleCard.ACTION_MORE_LINUX_BETTER_CAT ->
                        openNextUI(NormalWebViewActivity::class.java, title, BaseTabActivity.TabType.SystemUI.RECYCLER_VIEW_TYPE, data[position].web_url)
                }
            }
        }
    }

    fun getItemCardList(): MutableList<ItemSimpleCard>{
        return mutableListOf<ItemSimpleCard>().apply {
            add(ItemSimpleCard("比 cat 更好用的命令", true).apply {
                item_action = ItemSimpleCard.ACTION_MORE_LINUX_BETTER_CAT
                web_url = "https://mp.weixin.qq.com/s/jDYgI-HIuE3ez8K3EA8WoA"
            })
        }
    }

}