package cn.kk.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.R
import cn.kk.base.bean.ListItemAction

/**
 * 列表适配器
 */
class ListAdapter(val list: MutableList<ListItemAction>): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    var itemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent ,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = list[position].title
        holder.finishTag.visibility = if (list[position].finish) View.VISIBLE else View.INVISIBLE
        holder.root.setOnClickListener {
            itemClickListener?.onItemClick(position)
        }
    }

    override fun getItemCount(): Int = list.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.findViewById<TextView>(R.id.tv_item_home_name)
        val finishTag = itemView.findViewById<View>(R.id.finishTag)
        val root = itemView.findViewById<ConstraintLayout>(R.id.item_home_root)
    }

    /**
     * item 点击事件
     */
    interface ItemClickListener{

        fun onItemClick(position: Int)
    }
}