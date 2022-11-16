package cn.kk.customview.bean

import cn.kk.base.bean.BaseMoreItem
import java.io.Serializable

/**
 * @param itemAction 区分 book
 */
class BookModel(val title: String, val itemAction: Int, val chapterModelList: MutableList<ItemChapterModel>): Serializable {

    constructor(): this("", -1, mutableListOf())

    var bookImgRes: Int = -1
    var expandChapterIndex = 0
    // 更多信息：在页面标题栏上调出
    var moreItemList: MutableList<BaseMoreItem>? = null
}