package cn.kk.customview.bean

class ItemSectionModel(val title: String): BaseItem() {

    constructor(title: String, finishTag: Boolean): this(title) {
        super.finishTag = finishTag
    }
}