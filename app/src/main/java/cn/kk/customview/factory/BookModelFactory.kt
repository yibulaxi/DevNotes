package cn.kk.customview.factory

import android.content.Context
import cn.kk.base.bean.BaseMoreItem
import cn.kk.base.utils.AssetsHelper
import cn.kk.base.utils.JsonHelper
import cn.kk.customview.R
import cn.kk.customview.bean.BaseItem
import cn.kk.customview.bean.BookModel
import cn.kk.customview.bean.ItemChapterModel
import cn.kk.customview.bean.ItemSectionModel

/**
 * 课本工厂
 */
class BookModelFactory {


    companion object {

        private val mBooks = mutableListOf<BookModel>()
        fun createBookList(ctx: Context): MutableList<BookModel> {
            val bookValueJson = AssetsHelper.getBooksValue(ctx)
            val books = JsonHelper.parseJsonArray(bookValueJson, BookModel::class.java)
            return books
        }

        fun getBookList(ctx: Context): MutableList<BookModel>{
            if (mBooks.isEmpty()) {
                mBooks.addAll(createBookList(ctx))
            }
            return mBooks
        }

        fun getBookByAction(itemAction: Int): BookModel {
            for (book in mBooks) {
                if (book.itemAction == itemAction) {
                    return book
                }
            }
            // 找不到，就默认返回第一个
            return mBooks[0]
        }

        fun createBook(actionBook: Int): BookModel {
            return getBookByAction(actionBook)
        }
    }

}