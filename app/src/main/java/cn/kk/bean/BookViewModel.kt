package cn.kk.bean

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import cn.kk.io.db.Book
import cn.kk.io.db.BookRepository

class BookViewModel: ViewModel() {

    private val bookRepository = BookRepository.getInstance()

    val bookListLiveData = bookRepository.getBooks()

    fun getBook(bookType: Int): LiveData<Book?> {
       return bookRepository.getBook(bookType)
    }
}