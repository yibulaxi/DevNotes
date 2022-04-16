package cn.kk.customview.fragment

import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import cn.kk.base.UIHelper
import cn.kk.base.fragment.BaseFragment
import cn.kk.customview.R
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
        rvList.adapter = object : BaseQuickAdapter<ItemMore, BaseViewHolder>(R.layout.item_more_list, getItems()){
            override fun convert(holder: BaseViewHolder, item: ItemMore) {
                holder.setText(R.id.tv_name, item.name)
                holder.setVisible(R.id.iv_ok_flag, item.finish)
                holder.getView<CardView>(R.id.rootView).setCardBackgroundColor(UIHelper.generaRandomColor())
            }

        }
    }

    private fun getItems(): MutableList<ItemMore>{
        return  mutableListOf<ItemMore>().apply {
            add(ItemMore("多线程", true))
            add(ItemMore("网络"))
            add(ItemMore("设计模式"))
            add(ItemMore("Activity 的生命周期和启动模式"))
            add(ItemMore("Android 消息机制"))
            add(ItemMore("IPC机制"))
            add(ItemMore("理解 Window 和 WindowManager"))
            add(ItemMore("四大组件工作过程"))
            add(ItemMore("Bitmap 的加载和 Cache"))
            add(ItemMore("事件总线"))
            add(ItemMore("函数响应式编程"))
            add(ItemMore("注解与依赖注入框架"))
            add(ItemMore("Flutter"))
            add(ItemMore("音频"))
            add(ItemMore("视频"))
            add(ItemMore("性能优化"))
            add(ItemMore("Gradle"))
            add(ItemMore("JNI 和 NDK"))
            add(ItemMore("综合技术"))
        }
    }

    class ItemMore(val name: String,val finish: Boolean = false)
}