package cn.kk.io.db

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import cn.kk.base.utils.ThreadHelper

/**
 * 数据库仓库类
 *
 *  单例模式
 */
class BookRepository private constructor(context: Context){
    private val DATABASE_NAME = "book-db"
    private val database: BookDatabase = Room.databaseBuilder(context.applicationContext, BookDatabase::class.java, DATABASE_NAME).build()

    private val bookDao = database.bookDao()


    companion object {
        private var INSTANCE: BookRepository ?= null

        fun init(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = BookRepository(context)
            }
        }

        fun getInstance(): BookRepository{
            return INSTANCE ?: throw IllegalStateException("数据库要先初始化！")
        }
    }

    fun getBooks(): LiveData<List<Book>> = bookDao.getBooks()

    fun getBook(bookType: Int): LiveData<Book?> = bookDao.getBook(bookType)

    fun updateBook(book: Book) {
        ThreadHelper.runTask { bookDao.updateBook(book) }
    }

    fun addBook(book: Book) {
        ThreadHelper.runTask { bookDao.addBook(book) }
    }
}