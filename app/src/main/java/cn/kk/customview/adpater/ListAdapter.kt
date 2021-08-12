package cn.kk.customview.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import cn.kk.customview.R

/**
 * 列表适配器
 */
class ListAdapter(val list: MutableList<String>): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    var itemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent ,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = list[position]
        holder.root.setOnClickListener {
            itemClickListener?.onItemClick(position)
        }
    }

    override fun getItemCount(): Int = list.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.findViewById<TextView>(R.id.tv_item_home_name)
        val root = itemView.findViewById<ConstraintLayout>(R.id.item_home_root)
    }

    /**
     * item 点击事件
     */
    interface ItemClickListener{

        fun onItemClick(position: Int)
    }
}