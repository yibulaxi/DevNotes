package cn.kk.io.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Chapter(@PrimaryKey val id: UUID = UUID.randomUUID(),
                   var book_type: Int,
                   var chapter_title: String,
                   var chapter_order: Int
)
