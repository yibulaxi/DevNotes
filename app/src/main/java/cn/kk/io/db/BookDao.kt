package cn.kk.io.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface BookDao {

    @Query("SELECT * FROM BOOK")
    fun getBooks(): LiveData<List<Book>>

    @Query("select * from book where bookType=(:bookType)")
    fun getBook(bookType: Int): LiveData<Book?>

    @Update
    fun updateBook(book: Book)

    @Insert
    fun addBook(book: Book)
}