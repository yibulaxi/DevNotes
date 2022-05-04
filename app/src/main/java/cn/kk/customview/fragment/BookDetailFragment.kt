package cn.kk.customview.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.fragment.BaseFragment
import cn.kk.customview.R
import cn.kk.customview.adapter.BaseChapterAdapter
import cn.kk.customview.bean.BookModel

/**
 * Book 详情页面 - Fragment
 */
class BookDetailFragment: BaseFragment() {
    override fun getLayoutId(): Int = R.layout.fragment_book_detail_layout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bookModel = arguments?.getSerializable(INTENT_MODEL_KEY) as BookModel

        val rvChapter = rootView.findViewById<RecyclerView>(R.id.rv_chapter_list)
        rvChapter.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = BaseChapterAdapter(bookModel.chapterModelList).apply { expandIndex = bookModel.expandChapterIndex }
        }
    }
}