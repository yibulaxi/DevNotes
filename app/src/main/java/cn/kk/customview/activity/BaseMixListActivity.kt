package cn.kk.customview.activity

import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.UIHelper
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.activity.BaseTabActivity
import cn.kk.customview.activity.NormalWebViewActivity
import cn.kk.customview.bean.BaseItem
import cn.kk.customview.bean.ItemSimpleCard
import cn.kk.customview.factory.BookModelFactory
import cn.kk.customview.fragment.BookDetailFragment
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.activity_normal_list.*

/**
 * 页面说明：
 *  分上下两部分：按照章节的列表、水平滑动的卡片列表
 */
abstract class BaseMixListActivity : BaseActivity() {

    override fun getLayout() = R.layout.activity_mix_list

    /**
     * 获取 book action
     */
    abstract fun getBookAction(): Int

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // region book detail part
        supportFragmentManager.beginTransaction().add(
            R.id.fragment_container,
            BookDetailFragment().apply {
                arguments = Bundle().apply { putSerializable(INTENT_MODEL_KEY, BookModelFactory.createBook(getBookAction())) }
            }).commit()

        // endregion

        // region bottom Card item
        rv_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_list.adapter = object : BaseQuickAdapter<ItemSimpleCard, BaseViewHolder>(
            R.layout.item_card_list_horzontal,
            getItemCardList()
        ) {
            override fun convert(holder: BaseViewHolder, item: ItemSimpleCard) {
                holder.setText(R.id.tv_name, item.title)
                holder.setVisible(R.id.iv_ok_flag, item.finish)
                holder.getView<CardView>(R.id.rootView)
                    .setCardBackgroundColor(UIHelper.generaRandomColor())
            }
        }.apply {
            setOnItemClickListener { adapter, view, position ->
                doWhenClickItem(data[position])

            }
        }

        // endregion
    }

    /**
     * 底部卡片具体信息集合
     */
    abstract fun getItemCardList(): MutableList<ItemSimpleCard>

    /**
     * 底部卡片点击跳转
     */
    abstract fun doWhenClickItem(item: ItemSimpleCard)

}