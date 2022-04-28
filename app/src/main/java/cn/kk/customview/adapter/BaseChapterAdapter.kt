package cn.kk.customview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import cn.kk.customview.R
import cn.kk.customview.bean.ItemChapterModel
import cn.kk.customview.bean.ItemSectionModel
import cn.kk.customview.widget.ItemFolderView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * 通用章节适配器
 */
class BaseChapterAdapter(chapterData: MutableList<ItemChapterModel>): BaseQuickAdapter<ItemChapterModel, BaseViewHolder>(R.layout.item_chapter_view, chapterData) {
    var mItemSectionClickListener: OnItemSectionClickListener ?= null

    override fun convert(holder: BaseViewHolder, item: ItemChapterModel) {
        val chapterView = holder.getView<ItemFolderView>(R.id.folder_view)
        if (holder.layoutPosition == 0) {
            chapterView.setData(item, true)
        } else {
            chapterView.setData(item)
        }

        chapterView.sectionClickListener = object : ItemFolderView.SectionClickListener {
            override fun onSectionClick(item: ItemSectionModel) {
                mItemSectionClickListener?.onSectionClick(item)
            }

        }
    }

    interface OnItemSectionClickListener {

        fun onSectionClick(item: ItemSectionModel)
    }
}