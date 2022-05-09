package cn.kk.customview.bean

/**
 * 卡片 item
 */
class ItemSimpleCard(val title: String, val finish: Boolean = false): BaseItem() {

    var web_url = ""
    var markdown_url = ""
    var markdownLocalFlag = false
}