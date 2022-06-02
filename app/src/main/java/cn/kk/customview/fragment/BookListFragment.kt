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

class BookListFragment: BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_book
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvBookList = rootView.findViewById<RecyclerView>(R.id.rv_book)
        // init book data
        val bookList = mutableListOf<BookModel>().apply {
            add(BookModelFactory.createBook(BaseItem.ACTION_BOOK_INTERVIEW))
            add(BookModelFactory.createBook(BaseItem.action_book_android_dev_performance))
            add(BookModelFactory.createBook(BaseItem.ACTION_BOOK_AV_DEV))
            add(BookModelFactory.createBook(BaseItem.ACTION_BOOK_NDK))
            add(BookModelFactory.createBook(BaseItem.action_book_android_dev_art))
            add(BookModelFactory.createBook(BaseItem.action_book_linux))
            add(BookModelFactory.createBook(BaseItem.action_book_android_custom_view_elementary))
            add(BookModelFactory.createBook(BaseItem.action_book_android_advance))
            add(BookModelFactory.createBook(BaseItem.action_book_android_programming))
            add(BookModelFactory.createBook(BaseItem.action_book_git))
            add(BookModelFactory.createBook(BaseItem.action_book_android_arch))
            add(BookModelFactory.createBook(BaseItem.action_book__android_plugin))
            add(BookModelFactory.createBook(BaseItem.action_book_android_hot_fix))
            add(BookModelFactory.createBook(BaseItem.action_book_ffmpeg))
            add(BookModelFactory.createBook(BaseItem.action_book_data_arch))
            add(BookModelFactory.createBook(BaseItem.action_book_python))
            add(BookModelFactory.createBook(BaseItem.action_book_http))
            add(BookModelFactory.createBook(BaseItem.action_book_java_easy_coding))
            add(BookModelFactory.createBook(BaseItem.action_book_c_plus))
            add(BookModelFactory.createBook(BaseItem.action_book_c))
            add(BookModelFactory.createBook(BaseItem.action_book_kotlin))
            add(BookModelFactory.createBook(BaseItem.ACTION_BOOK_IDE))
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
                        BaseItem.action_book_android_dev_art -> {
                        }
                        else -> {
                        }
                    }
                }
            }
        }

    }
}