package cn.kk.customview.bean

import java.io.Serializable

class BookModel(val title: String, val itemAction: Int, val chapterModelList: MutableList<ItemChapterModel>): Serializable {

    constructor(): this("", -1, mutableListOf())
}