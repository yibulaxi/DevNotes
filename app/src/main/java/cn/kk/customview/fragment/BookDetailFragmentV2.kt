package cn.kk.customview.fragment

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ExpandableListView
import cn.kk.base.fragment.BaseFragment
import cn.kk.customview.R
import cn.kk.customview.adapter.BookExpandableListAdapter
import cn.kk.customview.bean.BookChapterItem
import cn.kk.customview.bean.BookItem
import cn.kk.customview.bean.BookSectionItem

/**
 * Book 详情页面
 * 使用扩展列表
 */
class BookDetailFragmentV2: BaseFragment() {
    override fun getLayoutId(): Int = R.layout.fragment_book_detail_v2_layout

    val MENU_ID_MENU_DELETE = 100
    val MENU_ID_MENU_DETAIL = 100

    val bookID = 100

    val bookItem: BookItem by lazy {
        BookItem(bookID, "Temp", mutableListOf<BookChapterItem>().apply {
            addChapter(bookID, "First chapter", this.size, 12)
            addChapter(bookID, "Second chapter", this.size, 5)
            addChapter(bookID, "Third chapter", this.size, 19)
            addChapter(bookID, "Forth chapter", this.size, 2)
            addChapter(bookID, "Fifth chapter", this.size, 12)
            addChapter(bookID, "Sixth chapter", this.size, 9)

        })
    }

    val mBookExpandableListAdapter: BookExpandableListAdapter by lazy {
        BookExpandableListAdapter(bookItem, activity!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val expandChapterListView = rootView.findViewById<ExpandableListView>(R.id.book_expand_list_view)

        expandChapterListView.setAdapter(mBookExpandableListAdapter)

        // ExpandableListView menu context
        expandChapterListView.setOnCreateContextMenuListener(this)
    }

    // region context menu
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        val info = menuInfo as ExpandableListView.ExpandableListContextMenuInfo
        if (info != null) {
            val type = ExpandableListView.getPackedPositionType(info.packedPosition)
            if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
                menu.add(Menu.NONE, MENU_ID_MENU_DETAIL, Menu.NONE, R.string.menu_detail)
                menu.add(Menu.NONE, MENU_ID_MENU_DELETE, Menu.NONE, R.string.menu_delete)
            }
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            MENU_ID_MENU_DELETE -> {
                val info = item.menuInfo as ExpandableListView.ExpandableListContextMenuInfo
                val type = ExpandableListView.getPackedPositionType(info.packedPosition)
                var groupPos = 0
                var childPos = 0
                if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
                    groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition)
                    childPos = ExpandableListView.getPackedPositionChild(info.packedPosition)

                    showToast("delete: ${groupPos}->${childPos}")

                    // delete
                    bookItem.bookChapterItemList[groupPos].bookSectionItemList.removeAt(childPos)
                    mBookExpandableListAdapter.notifyDataSetChanged()
                }
            }
            MENU_ID_MENU_DETAIL -> {
                val info = item.menuInfo as ExpandableListView.ExpandableListContextMenuInfo
                val type = ExpandableListView.getPackedPositionType(info.packedPosition)
                var groupPos = 0
                var childPos = 0
                if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
                    groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition)
                    childPos = ExpandableListView.getPackedPositionChild(info.packedPosition)

                    showToast("detail: ${groupPos}->${childPos}")
                }
            }
        }
        return super.onContextItemSelected(item)
    }

    // endregion

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