package cn.kk.customview.bean

import java.io.Serializable

class ItemSectionModel(val title: String): BaseItem(), Serializable {

    constructor(title: String, finishTag: Boolean): this(title) {
        super.finishTag = finishTag
    }

}