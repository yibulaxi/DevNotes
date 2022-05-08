package cn.kk.customview.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.fragment.BaseFragment
import cn.kk.base.utils.AssetsHelper
import cn.kk.customview.R
import cn.kk.customview.activity.NormalMarkDownViewActivity
import cn.kk.customview.adapter.BaseChapterAdapter
import cn.kk.customview.bean.BaseItem
import cn.kk.customview.bean.BookModel
import cn.kk.customview.bean.ItemSectionModel

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
            adapter = BaseChapterAdapter(bookModel.chapterModelList).apply {
                expandIndex = bookModel.expandChapterIndex
                mItemSectionClickListener = object : BaseChapterAdapter.OnItemSectionClickListener {
                    override fun onSectionClick(bookType: Int, item: ItemSectionModel) {
                        when(bookType) {
                            BaseItem.action_book_c_plus -> {
                                when(item.chapter_action) {
                                    1 -> { // chapter1
                                        when(item.section_action) {
                                            1 -> openNextUIWithMarkdown(NormalMarkDownViewActivity::class.java, item.title, AssetsHelper.getMarkdownFilePath("cpp/chapter_1/section_1.md"))
                                            2 -> openNextUIWithMarkdown(NormalMarkDownViewActivity::class.java, item.title, AssetsHelper.getMarkdownFilePath("cpp/chapter_1/section_2.md"))
                                            3 -> openNextUIWithMarkdown(NormalMarkDownViewActivity::class.java, item.title, AssetsHelper.getMarkdownFilePath("cpp/chapter_1/section_3.md"))
                                            4 -> openNextUIWithMarkdown(NormalMarkDownViewActivity::class.java, item.title, AssetsHelper.getMarkdownFilePath("cpp/chapter_1/section_4.md"))
                                            5 -> openNextUIWithMarkdown(NormalMarkDownViewActivity::class.java, item.title, AssetsHelper.getMarkdownFilePath("cpp/chapter_1/section_5.md"))
                                            6 -> openNextUIWithMarkdown(NormalMarkDownViewActivity::class.java, item.title, AssetsHelper.getMarkdownFilePath("cpp/chapter_1/section_6.md"))
                                        }
                                    }
                                    2 -> {
                                        when(item.section_action) {
                                            1 -> openNextUIWithMarkdown(NormalMarkDownViewActivity::class.java, item.title, AssetsHelper.getMarkdownURL(), false)
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}