package cn.kk.customview.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.kk.customview.R

class ViewPagerAdapter(val simpleList: MutableList<String>): RecyclerView.Adapter<ViewPagerAdapter.SimpleViewHolder>() {

    val colorList = arrayListOf<Int>(
        Color.parseColor("#123456"),
        Color.parseColor("#456456"),
        Color.parseColor("#456789"),
        Color.parseColor("#456123")
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        return SimpleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_simple, null, false).apply {
            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        })
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        holder.tvTitle.text = simpleList[position]
        holder.tvTitle.setBackgroundColor(colorList[position % colorList.size])
    }

    override fun getItemCount(): Int = simpleList.size


    class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.findViewById<TextView>(R.id.item_title)
    }

}