package cn.kk.base.adapter

import android.app.Activity
import android.content.Context
import android.widget.TextView
import cn.kk.base.R
import cn.kk.base.bean.CommentModel
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * 评论适配器
 */
class CommentAdapter(val dataList: MutableList<CommentModel>, val mContext: Context): BaseQuickAdapter<CommentModel, BaseViewHolder>(R.layout.item_comment, dataList) {

    override fun convert(holder: BaseViewHolder, itemModle: CommentModel) {
        holder.setText(R.id.tv_comment,itemModle.content)
        holder.setText(R.id.tv_nikename, itemModle.name)
        holder.setText(R.id.tv_like, if(itemModle.like) "like" else "dislike")
        Glide.with(mContext).load(R.drawable.head_portrait_empty).into(holder.getView(R.id.iv_avatar))
    }

    fun refreshLikeState(view: TextView, model: CommentModel){
        view.text = if(model.like) "like" else "dislike"
    }
}