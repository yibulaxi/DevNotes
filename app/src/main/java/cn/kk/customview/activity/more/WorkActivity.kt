package cn.kk.customview.activity.more

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import cn.kk.base.UIHelper
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.bean.ItemSimpleCard
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.activity_normal_list.*

/**
 * 工作中总结
 */
class WorkActivity: BaseActivity() {

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

        }
    }

    fun getItemCardList(): MutableList<ItemSimpleCard>{
        return mutableListOf<ItemSimpleCard>().apply {
            add(ItemSimpleCard("Intent 序列化传值", true))
            add(ItemSimpleCard("RecyclerView 使用总结", false))
        }
    }
}