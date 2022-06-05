package cn.kk.io.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Section(@PrimaryKey val id: UUID = UUID.randomUUID(),
                   var book_type: Int,
                   var chapter_order: Int,
                   var section_title: String,
                   var section_order: Int,
                   var date: Date = Date(),
                   var finishFlag: Boolean = false
)
