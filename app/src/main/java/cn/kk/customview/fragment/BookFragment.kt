package cn.kk.customview.fragment

import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.UIHelper
import cn.kk.base.fragment.BaseFragment
import cn.kk.customview.R
import cn.kk.customview.activity.book.BookDetailActivity
import cn.kk.customview.bean.BaseItem
import cn.kk.customview.bean.BookModel
import cn.kk.customview.factory.BookModelFactory
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class BookFragment: BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_book
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvBookList = rootView.findViewById<RecyclerView>(R.id.rv_book)
        // init book data
        val bookList = mutableListOf<BookModel>().apply {
            add(BookModelFactory.createBook(BaseItem.action_book_1))
            add(BookModelFactory.createBook(BaseItem.action_book_2))
            add(BookModelFactory.createBook(BaseItem.action_book_3))
            add(BookModelFactory.createBook(BaseItem.action_book_4))
            add(BookModelFactory.createBook(BaseItem.action_book_5))
            add(BookModelFactory.createBook(BaseItem.action_book_6))
            add(BookModelFactory.createBook(BaseItem.action_book_7))
            add(BookModelFactory.createBook(BaseItem.action_book_8))
            add(BookModelFactory.createBook(BaseItem.action_book_9))
            add(BookModelFactory.createBook(BaseItem.action_book_10))
            add(BookModelFactory.createBook(BaseItem.action_book_11))
            add(BookModelFactory.createBook(BaseItem.action_book_12))
        }

        rvBookList.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = object : BaseQuickAdapter<BookModel, BaseViewHolder>(R.layout.item_book_view, bookList){
                override fun convert(holder: BaseViewHolder, item: BookModel) {
                    if (item.bookImgRes == -1) {
                        holder.setText(R.id.tv_name, item.title)
                        holder.getView<CardView>(R.id.root_view).setCardBackgroundColor(UIHelper.generaRandomColor())
                    } else {
                        holder.setBackgroundResource(R.id.tv_name, item.bookImgRes)
                    }
                }
            }.apply {
                setOnItemClickListener { adapter, view, position ->
                    startNextUI(BookDetailActivity::class.java, data[position].title, data[position])

                    when (data[position].itemAction) {
                        BaseItem.action_book_1 -> {
                        }
                        else -> {
                        }
                    }
                }
            }
        }

    }
}