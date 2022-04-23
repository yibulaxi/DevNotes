package cn.kk.customview.activity.more

import cn.kk.customview.R
import cn.kk.customview.activity.BaseTabActivity
import cn.kk.customview.activity.NormalCardListActivity
import cn.kk.customview.activity.NormalWebViewActivity
import cn.kk.customview.activity.more.audio.AudioBasicActivity
import cn.kk.customview.bean.ItemSimpleCard

/**
 * 音频知识学习
 */
class AudioActivity: NormalCardListActivity() {

    override fun getLayout() = R.layout.activity_normal_list

    override fun getListSpanCount() = 2

    override fun getItemCardList(): MutableList<ItemSimpleCard>{
        return mutableListOf<ItemSimpleCard>().apply {
            add(ItemSimpleCard("音频基础", true).apply { item_action = ItemSimpleCard.ACTION_MORE_AUDIO_BASIC })
            add(ItemSimpleCard("音频降噪", true))
            add(ItemSimpleCard("回声消除", true))
            add(ItemSimpleCard("音频网络传输", true))
            add(ItemSimpleCard("空间音频", true))
            add(ItemSimpleCard("音频特效生成与算法", true))
            add(ItemSimpleCard("选择比努力更重要", true).apply { web_url = "https://time.geekbang.org/column/article/472989" })

        }
    }

    override fun doWhenClickItem(item: ItemSimpleCard) {
        when (item.item_action) {
            ItemSimpleCard.ACTION_MORE_AUDIO_BASIC -> openNextUI(AudioBasicActivity::class.java, item.title)
        }
    }

}