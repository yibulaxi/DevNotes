package cn.kk.customview.activity.book

import android.os.Bundle
import androidx.fragment.app.Fragment
import cn.kk.customview.activity.BaseFragmentActivity
import cn.kk.customview.bean.BookModel
import cn.kk.customview.fragment.BookDetailFragment

/**
 * Book 详情页面 - Activity
 */
class BookDetailActivity : BaseFragmentActivity() {

    override fun getFragment(): Fragment = BookDetailFragment().apply {
        arguments = Bundle().apply {
            putSerializable(
                INTENT_MODEL_KEY,
                intent.getSerializableExtra(INTENT_MODEL_KEY) as BookModel
            )
        }
    }
}