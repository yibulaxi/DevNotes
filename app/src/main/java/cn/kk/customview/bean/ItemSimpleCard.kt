package cn.kk.customview.bean

class ItemSimpleCard(val title: String, val finish: Boolean = false) {
    var item_action = 0

    companion object {

        // 更多：工作中总结
        val ACTION_MORE_WORK = 100
    }
}