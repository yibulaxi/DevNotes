package cn.kk.customview.bean

/**
 * 课本章节
 */
class BookChapterItem(val bookID: Int, val title: String, val chapterIndex: Int, val bookSectionItemList: MutableList<BookSectionItem>) {
}