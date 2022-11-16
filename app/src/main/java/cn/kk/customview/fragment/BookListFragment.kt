package cn.kk.customview.fragment

import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.UIHelper
import cn.kk.base.fragment.BaseFragment
import cn.kk.base.utils.AssetsHelper
import cn.kk.base.utils.JsonHelper
import cn.kk.customview.R
import cn.kk.customview.activity.book.BookDetailActivity
import cn.kk.customview.bean.BaseItem
import cn.kk.customview.bean.BookModel
import cn.kk.customview.factory.BookModelFactory
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class BookListFragment: BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_book
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvBookList = rootView.findViewById<RecyclerView>(R.id.rv_book)
        // init book data

        val bookLisJson = AssetsHelper.getBooksValue(context!!)

        val bookListV2 = getBooks(bookLisJson)

        //

        rvBookList.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = object : BaseQuickAdapter<BookModel, BaseViewHolder>(R.layout.item_book_view, bookListV2){
                override fun convert(holder: BaseViewHolder, item: BookModel) {
                    if (item.bookImgRes == -1) {
                        holder.setText(R.id.tv_name, item.title)
                        holder.getView<CardView>(R.id.root_view).setCardBackgroundColor(UIHelper.generaRandomColor())
                        holder.setBackgroundResource(R.id.tv_name, 0)
                    } else {
                        holder.setText(R.id.tv_name, "")
                        holder.setBackgroundResource(R.id.tv_name, item.bookImgRes)
                    }

                }
            }.apply {
                setOnItemClickListener { adapter, view, position ->
                    startNextUI(BookDetailActivity::class.java, data[position].title, data[position])
                }
            }
        }

    }

    private fun getBooks(bookLisJson: String): MutableList<BookModel> {
        val typeToken = object : TypeToken<List<BookModel>>() {}.type

        val bookListV2 = Gson().fromJson<List<BookModel>>(bookLisJson, typeToken).toMutableList()
        return bookListV2
    }
}