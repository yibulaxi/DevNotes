package cn.kk.customview.adpater

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.kk.customview.R

/**
 * 绘图基础
 * 自定义 view 的适配器
 */
class BasicViewViewPagerAdapter(val viewList: MutableList<View>): RecyclerView.Adapter<BasicViewViewPagerAdapter.ViewHolder>() {
    val TAG = this.javaClass.simpleName
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val root = itemView.findViewById<RelativeLayout>(R.id.rl_item_basic_view_root)
        val title = itemView.findViewById<TextView>(R.id.tv_item_view_title)
        val index = itemView.findViewById<TextView>(R.id.tv_item_view_index)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_basic_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder.root.childCount == 0){
            holder.root.addView(viewList[position])
        } else {
            holder.root.removeAllViews()
            holder.root.addView(viewList[position])
        }
        holder.title.text = viewList[position].javaClass.simpleName
        holder.index.text = (position + 1).toString()
    }

    override fun getItemCount(): Int = viewList.size
}