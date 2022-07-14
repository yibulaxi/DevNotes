package cn.kk.customview.fragment

import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import cn.kk.base.fragment.BaseFragment
import cn.kk.customview.R
import cn.kk.customview.adapter.BookExpandableListAdapter
import cn.kk.customview.bean.*

/**
 * Book 详情页面
 * 使用扩展列表
 */
class BookDetailFragmentV2: BaseFragment() {
    override fun getLayoutId(): Int = R.layout.fragment_book_detail_v2_layout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val expandChapterListView = rootView.findViewById<ExpandableListView>(R.id.book_expand_list_view)

        val bookID = 100
        val bookItem = BookItem(bookID, "Temp", mutableListOf<BookChapterItem>().apply {
            addChapter(bookID, "First chapter", this.size, 12)
            addChapter(bookID, "Second chapter", this.size, 5)
            addChapter(bookID, "Third chapter", this.size, 19)
            addChapter(bookID, "Forth chapter", this.size, 2)
            addChapter(bookID, "Fifth chapter", this.size, 12)
            addChapter(bookID, "Sixth chapter", this.size, 9)

        })
        expandChapterListView.setAdapter(BookExpandableListAdapter(bookItem, activity!!))

    }

    private fun MutableList<BookChapterItem>.addChapter(bookID: Int, chapterName: String, chapterIndex: Int ,sectionCount: Int) {
        add(
            BookChapterItem(
                bookID,
                chapterName,
                this.size,
                mutableListOf<BookSectionItem>().apply {
                    for (i in 0 until  sectionCount) {
                        val sectionName = String.format("%d.%d section", chapterIndex + 1, i + 1)
                        add(BookSectionItem(sectionName, false))
                    }
                })
        )
    }

}