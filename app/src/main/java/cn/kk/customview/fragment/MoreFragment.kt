package cn.kk.customview.fragment

import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import cn.kk.base.UIHelper
import cn.kk.base.fragment.BaseFragment
import cn.kk.customview.R
import cn.kk.customview.activity.more.*
import cn.kk.customview.bean.ItemSimpleCard
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class MoreFragment: BaseFragment() {
    override fun getLayoutId(): Int {
       return R.layout.fragment_more
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val rvList = rootView.findViewById<RecyclerView>(R.id.rv_list_more)
        rvList.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvList.adapter = object : BaseQuickAdapter<ItemSimpleCard, BaseViewHolder>(R.layout.item_card_list, getItems()){
            override fun convert(holder: BaseViewHolder, item: ItemSimpleCard) {
                holder.setText(R.id.tv_name, item.title)
                holder.setText(R.id.tv_index, (holder.layoutPosition + 1).toString())
                holder.setVisible(R.id.iv_ok_flag, item.finish)
                holder.getView<CardView>(R.id.rootView).setCardBackgroundColor(UIHelper.generaRandomColor())
            }
        }.apply {
            setOnItemClickListener { adapter, view, position ->
                val title = data[position].title
                when (data[position].item_action) {
                    ItemSimpleCard.ACTION_MORE_WORK -> startNextUI(WorkActivity::class.java, title)
                    ItemSimpleCard.ACTION_MORE_NET -> startNextUI(NetActivity::class.java, title)
                    ItemSimpleCard.ACTION_MORE_ZONGHE -> startNextUI(ZongHeActivity::class.java, title)
                    ItemSimpleCard.ACTION_MORE_Linux -> startNextUI(LinuxActivity::class.java, title)
                    ItemSimpleCard.ACTION_MORE_MIX_DEV -> startNextUI(MixDevActivity::class.java, title)
                    else -> {
                    }
                }
            }
        }
    }

    private fun getItems(): MutableList<ItemSimpleCard>{
        return  mutableListOf<ItemSimpleCard>().apply {
            add(ItemSimpleCard("工作中汇总", true).apply { item_action = ItemSimpleCard.ACTION_MORE_WORK })
            add(ItemSimpleCard("多线程", true))
            add(ItemSimpleCard("网络", true).apply { item_action = ItemSimpleCard.ACTION_MORE_NET })
            add(ItemSimpleCard("Android Sqlite 数据库使用"))
            add(ItemSimpleCard("设计模式"))
            add(ItemSimpleCard("数据结构和算法"))
            add(ItemSimpleCard("Activity 的生命周期和启动模式"))
            add(ItemSimpleCard("Android 消息机制"))
            add(ItemSimpleCard("IPC机制"))
            add(ItemSimpleCard("理解 Window 和 WindowManager"))
            add(ItemSimpleCard("四大组件工作过程"))
            add(ItemSimpleCard("Bitmap 的加载和 Cache"))
            add(ItemSimpleCard("事件总线"))
            add(ItemSimpleCard("函数响应式编程"))
            add(ItemSimpleCard("注解与依赖注入框架"))
            add(ItemSimpleCard("Flutter"))
            add(ItemSimpleCard("音频"))
            add(ItemSimpleCard("视频"))
            add(ItemSimpleCard("性能优化"))
            add(ItemSimpleCard("热修复"))
            add(ItemSimpleCard("全埋点解决方案"))
            add(ItemSimpleCard("Android 插件化开发指南"))
            add(ItemSimpleCard("Gradle"))
            add(ItemSimpleCard("JNI 和 NDK"))
            add(ItemSimpleCard("C/C++"))
            add(ItemSimpleCard("OpenGL"))
            add(ItemSimpleCard("综合技术", true).apply { item_action = ItemSimpleCard.ACTION_MORE_ZONGHE })
            add(ItemSimpleCard("打包脚本"))
            add(ItemSimpleCard("Git"))
            add(ItemSimpleCard("Linux", true).apply { item_action = ItemSimpleCard.ACTION_MORE_Linux })
            add(ItemSimpleCard("Python"))
            add(ItemSimpleCard("混合开发", true).apply { item_action = ItemSimpleCard.ACTION_MORE_MIX_DEV })
            add(ItemSimpleCard("正则表达式", false))
        }
    }

}