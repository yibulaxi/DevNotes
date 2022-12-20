package cn.kk.io.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Book::class, Chapter::class, Section::class], version = 1, exportSchema = false)
@TypeConverters(BookTypeConverts::class)
abstract class BookDatabase: RoomDatabase() {


    abstract fun bookDao(): BookDao
}
