package cn.kk.customview.activity.book

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.adapter.BaseChapterAdapter
import cn.kk.customview.bean.BookModel

class BookDetailActivity: BaseActivity() {

    override fun getLayout(): Int = R.layout.fragment_book_detail_layout

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        val bookModel = intent.getSerializableExtra(INTENT_MODEL_KEY) as BookModel

        val rvChapter = findViewById<RecyclerView>(R.id.rv_chapter_list)
        rvChapter.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = BaseChapterAdapter(bookModel.chapterModelList).apply { expandIndex = bookModel.expandChapterIndex }
        }
    }
}