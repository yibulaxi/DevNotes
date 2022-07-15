package cn.kk.customview.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import cn.kk.customview.R
import cn.kk.customview.bean.BookChapterItem
import cn.kk.customview.bean.BookItem
import cn.kk.customview.bean.BookSectionItem

/**
 * book 扩展列表：
 * 效果就是二级列表
 *
 * 1. child view item context menu
 * 2. child view delete update item
 * 3. decoration
 */
class BookExpandableListAdapter(val bookItem: BookItem, val mActivity: FragmentActivity): BaseExpandableListAdapter() {

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val chapterItem = getGroup(groupPosition) as BookChapterItem
        val chapterView = mActivity.layoutInflater.inflate(R.layout.item_chapter_view_v2, null)

        val titleView = chapterView.findViewById<TextView>(R.id.tv_title)
        val ivArrow = chapterView.findViewById<ImageView>(R.id.iv_arrow)

        titleView.text = chapterItem.title
        ivArrow.rotation = if (isExpanded) 0f else -90f
//        UIHelper.changeExpandUI(isExpanded, ivArrow)

        return chapterView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val sectionItem = getChild(groupPosition, childPosition) as BookSectionItem
        val sectionView = mActivity.layoutInflater.inflate(R.layout.item_book_section, null)
        val sectionTitleView = sectionView.findViewById<TextView>(R.id.tv_item_home_name)

        sectionTitleView.text = sectionItem.title
        sectionView.isLongClickable = true
        return sectionView
    }

    override fun getGroupCount(): Int {
        return bookItem.bookChapterItemList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
       return bookItem.bookChapterItemList[groupPosition].bookSectionItemList.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return bookItem.bookChapterItemList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return bookItem.bookChapterItemList[groupPosition].bookSectionItemList[childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }


}