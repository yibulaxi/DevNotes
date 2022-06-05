package cn.kk.io.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Book(@PrimaryKey val bookType: Int,
                var title: String = "",
                var imgRes: Int = -1

)
