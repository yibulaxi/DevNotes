package cn.kk.customview.activity.more

import cn.kk.customview.R
import cn.kk.customview.activity.BaseTabActivity
import cn.kk.customview.activity.NormalCardListActivity
import cn.kk.customview.activity.NormalWebViewActivity
import cn.kk.customview.bean.ItemSimpleCard

/**
 * 网络 总结
 */
class NetActivity: NormalCardListActivity() {

    override fun getLayout() = R.layout.activity_normal_list

    override fun getListSpanCount() = 2

    override fun getItemCardList(): MutableList<ItemSimpleCard>{
        return mutableListOf<ItemSimpleCard>().apply {
            add(ItemSimpleCard("Android Https 抓包", true).apply {
                web_url = "https://mp.weixin.qq.com/s/M82R5YelhMAbdsjJ29gH9A"
            })
        }
    }

    override fun doWhenClickItem(item: ItemSimpleCard) {
        openNextUI(NormalWebViewActivity::class.java, item.title, BaseTabActivity.TabType.SystemUI.RECYCLER_VIEW_TYPE, item.web_url)
    }

}