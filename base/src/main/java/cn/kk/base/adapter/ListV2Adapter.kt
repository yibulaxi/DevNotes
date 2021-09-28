package cn.kk.base.adapter

import android.widget.TextView
import cn.kk.base.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class ListV2Adapter( data: MutableList<String>): BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_list, data) {

    override fun convert(holder: BaseViewHolder, item: String) {
        holder.getView<TextView>(R.id.tv_item_home_name).text = item
    }
}