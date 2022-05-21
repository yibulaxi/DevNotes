package cn.kk.customview.bean

import cn.kk.base.utils.AssetsHelper
import java.io.Serializable

class ItemSectionModel(val title: String): BaseItem(), Serializable {

    constructor(title: String, finishTag: Boolean): this(title) {
        super.finishTag = finishTag
    }

    constructor(title: String,  chapterAction: Int = 0, sectionAction: Int = 0, finishTag: Boolean = false):this(title) {
        super.chapter_action = chapterAction
        super.section_action = sectionAction
        super.finishTag = finishTag
    }

    fun getMarkdownFileUrl(bookType: Int): String {
       return AssetsHelper.getMarkdownURL(bookType , this)
    }
}