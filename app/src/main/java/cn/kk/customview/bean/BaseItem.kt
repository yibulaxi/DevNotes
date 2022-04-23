package cn.kk.customview.bean

abstract  class BaseItem {
    public  var item_action = 0
    var finishTag = false

    companion object {

        // 更多：工作中总结
        val ACTION_MORE_WORK = 100
        val ACTION_MORE_NET = 103
        val ACTION_MORE_AUDIO = 117 // 音频
        val ACTION_MORE_ZONGHE = 127 // 综合技术
        val ACTION_MORE_Linux = 130
        val ACTION_MORE_MIX_DEV = 132 // 混合开发


        // 更多：工作中总结，细分
        val ACTION_MORE_WORK_INTENT_SERIALIZABLE = 1001
        val ACTION_MORE_WORK_REYCYCLER_VIEW = 1002
        val ACTION_MORE_WORK_MENU = 1003
        val ACTION_MORE_WORK_TEXTVIEW_HIGHLIGHT = 1004

        // 更多：综合技术，细分
        val ACTION_MORE_ZONGHE_NESTEDSCROLLVIEW = 1271
        val ACTION_MORE_ZONGHE_chazhuang = 1272
        val ACTION_MORE_ZONGHE_mock = 1273

        // 更多 音频 笔记
        val ACTION_MORE_AUDIO_BASIC = 1171
        val ACTION_MORE_AUDIO_DENOISE = 1172
        val ACTION_MORE_AUDIO_REMOVE_ECHO = 1173
        val ACTION_MORE_AUDIO_NET_TRANS = 1174
        val ACTION_MORE_AUDIO_SPACE = 1175
        val ACTION_MORE_AUDIO_SPECIAL_EFFECT = 1176

        val ACTION_MORE_AUDIO_BASIC_1 = 11711
        val ACTION_MORE_AUDIO_BASIC_2 = 11712
        val ACTION_MORE_AUDIO_BASIC_3 = 11713
        val ACTION_MORE_AUDIO_BASIC_4 = 11714

        val ACTION_MORE_AUDIO_DENOISE_1 = 11721
        val ACTION_MORE_AUDIO_DENOISE_2 = 11722

        val ACTION_MORE_AUDIO_REMOVE_ECHO_1 = 11731
        val ACTION_MORE_AUDIO_REMOVE_ECHO_2 = 11732

        val ACTION_MORE_AUDIO_NET_TRANS_1 = 11742
        val ACTION_MORE_AUDIO_NET_TRANS_2 = 11742
        val ACTION_MORE_AUDIO_NET_TRANS_3 = 11743

        val ACTION_MORE_AUDIO_SPACE_1 = 11751
        val ACTION_MORE_AUDIO_SPACE_2 = 11752

        val ACTION_MORE_AUDIO_SPECIAL_EFFECT_1 = 11761
        val ACTION_MORE_AUDIO_SPECIAL_EFFECT_2 = 11762
        val ACTION_MORE_AUDIO_SPECIAL_EFFECT_3 = 11763

        // 更多 Linux 笔记
        val ACTION_MORE_LINUX_BETTER_CAT = 1301
        val ACTION_MORE_LINUX_MAC_TRANS_LINUX = 1302

        // 更多混合开发笔记
        val ACTION_MORE_MIX_DEV_WEBVIEW = 1321
    }
}