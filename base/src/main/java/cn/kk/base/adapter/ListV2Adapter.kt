package cn.kk.base.adapter

import android.widget.TextView
import androidx.appcompat.view.menu.ListMenuItemView
import cn.kk.base.R
import cn.kk.base.bean.ListItemAction
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.activity_comment.view.*

/**
 * 使用了开源库：BaseQuickAdapter
 */
class ListV2Adapter( data: MutableList<ListItemAction>): BaseQuickAdapter<ListItemAction, BaseViewHolder>(R.layout.item_list, data) {

    override fun convert(holder: BaseViewHolder, item: ListItemAction) {
        holder.getView<TextView>(R.id.tv_item_home_name).text = item.title
        holder.setVisible(R.id.finishTag, item.finish)
    }
}