package cn.kk.customview.bean

class ItemSimpleCard(val title: String, val finish: Boolean = false) {
    var item_action = 0
    var web_url = ""

    companion object {

        // 更多：工作中总结
        val ACTION_MORE_WORK = 100
        val ACTION_MORE_Linux = 130
        val ACTION_MORE_MIX_DEV = 132 // 混合开发


        // 更多：工作中总结，细分
        val ACTION_MORE_WORK_INTENT_SERIALIZABLE = 1001
        val ACTION_MORE_WORK_INTENT_REYCYCLER_VIEW = 1002

        // 更多 Linux 笔记
        val ACTION_MORE_LINUX_BETTER_CAT = 1301

        // 更多混合开发笔记
        val ACTION_MORE_MIX_DEV_WEBVIEW = 1321
    }
}