package cn.kk.customview.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
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
                    val tv = holder.getView<TextView>(R.id.tv_name)
                    if (item.bookImgRes == -1) { // background 主题色透明度，按压效果水波纹（颜色为主题色）
                        tv.text = item.title
                        holder.getView<CardView>(R.id.root_view).setCardBackgroundColor(ContextCompat.getColor(context, R.color.primary_10))
                        holder.setBackgroundResource(R.id.tv_name, 0)
                        tv.setBackgroundResource(R.drawable.bg_press_ripple_book)
                        holder.itemView.foreground = null

                    } else { // background 为书封面，按压效果封面上加上黑色遮罩
                        holder.setText(R.id.tv_name, "")
                        tv.setBackgroundResource(item.bookImgRes)
                        holder.itemView.foreground = ContextCompat.getDrawable(context, R.drawable.bg_press_dark_selector)
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