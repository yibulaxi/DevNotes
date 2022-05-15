package cn.kk.customview.fragment

import android.os.Bundle
import android.view.View
import androidx.core.widget.NestedScrollView
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

    var scrollOrientationListener: ScrollOrientationListener ?= null
    var scrollUp = false
    protected var bottomRvHideState = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bookModel = arguments?.getSerializable(INTENT_MODEL_KEY) as BookModel

        val rvChapter = rootView.findViewById<RecyclerView>(R.id.rv_chapter_list)

        // 滚动方向监听
        val scrollView = rootView.findViewById<NestedScrollView>(R.id.nested_scroll_view)
        scrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            // 向上滑动
            if (oldScrollY < scrollY) { //向上滑动
                if (!scrollUp) { // 方向改变了
                    scrollUp = oldScrollY < scrollY
                    scrollOrientationListener?.onScroll(scrollUp)
                }
            } else {
                if (scrollUp) { // 方向改变了
                    scrollUp = oldScrollY < scrollY
                    scrollOrientationListener?.onScroll(scrollUp)
                }
            }
        }

        rvChapter.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = BaseChapterAdapter(bookModel.chapterModelList).apply {
                expandIndex = bookModel.expandChapterIndex
                mItemSectionClickListener = object : BaseChapterAdapter.OnItemSectionClickListener {
                    override fun onSectionClick(bookType: Int, item: ItemSectionModel) {
                        when(bookType) {
                            // region cpp
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
                                    2, 3 -> { // chapter2 & chapter3
                                        // open markdown from online
                                        openNextUIWithMarkdown(NormalMarkDownViewActivity::class.java, item.title, AssetsHelper.getMarkdownURL(bookType, item), false)
                                    }
                                }
                            }
                            // endregion

                            // region FFMpeg
                            BaseItem.action_book_ffmpeg -> {
                                openNextUIWithMarkdown(NormalMarkDownViewActivity::class.java, item.title, AssetsHelper.getMarkdownURL(bookType, item), false)
                            }
                            // endregion
                        }
                    }

                }
            }
        }
    }

    interface ScrollOrientationListener {

       fun onScroll(up: Boolean)
    }
}