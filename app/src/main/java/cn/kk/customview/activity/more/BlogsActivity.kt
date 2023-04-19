package cn.kk.customview.activity.more

import cn.kk.customview.R
import cn.kk.customview.activity.BaseTabActivity
import cn.kk.customview.activity.NormalCardListActivity
import cn.kk.customview.activity.NormalWebViewActivity
import cn.kk.customview.bean.ItemSimpleCard

/**
 * 好的博客 整理
 */
class BlogsActivity: NormalCardListActivity() {

    override fun getLayout() = R.layout.activity_normal_list

    override fun getListSpanCount() = 2

    override fun getItemCardList(): MutableList<ItemSimpleCard>{
        return mutableListOf<ItemSimpleCard>().apply {
            add(ItemSimpleCard("fundroid", true).apply { web_url = "https://juejin.cn/user/3931509309842872" })
            add(ItemSimpleCard("AndroidPub", true).apply { web_url = "https://mp.weixin.qq.com/s/cplcerZwkONKXgQZX0BFnA" })
            add(ItemSimpleCard("Jetpack Compose 博物馆", true).apply { web_url = "https://mp.weixin.qq.com/s/hSEULF8XdsbK9XfI9Mv6GA" })
            add(ItemSimpleCard("字节小站", true).apply { web_url = "https://mp.weixin.qq.com/s/DnRQjMJBxwK-YQUXdG5-CQ" })
            add(ItemSimpleCard("Android教授", true).apply { web_url = "https://mp.weixin.qq.com/s/67hayepJ90TIh_CG0c9M2A" })
            add(ItemSimpleCard("小驰笔记", true).apply { web_url = "http://www.xiaochibiji.com/" })
            add(ItemSimpleCard("字节流动", true).apply { web_url = "https://mp.weixin.qq.com/s/vnK0oEGryaPQvljh4PkoxA" })
            add(ItemSimpleCard("字节跳动技术团队", true).apply { web_url = "https://juejin.cn/user/1838039172387262" })
        }
    }

    override fun doWhenClickItem(item: ItemSimpleCard) {
        openNextUI(NormalWebViewActivity::class.java, item.title, BaseTabActivity.TabType.SystemUI.RECYCLER_VIEW_TYPE, item.web_url)
    }

}