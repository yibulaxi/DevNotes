package cn.kk.customview.ui.system

import android.text.Html
import android.widget.TextView
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_html_text.*

/**
 * Html 显示在 TextView 上
 */
class HtmlText: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_html_text
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        tv_html.setText(Html.fromHtml(getString(R.string.html_demo)))
        tv_html_ting.setText(Html.fromHtml(getString(R.string.html_ting)))

//        tv_recite.text = Html.fromHtml(String.format(getString(R.string.recite_learning_progress_new_word), 3, 9, 2))

        tv_recite.text = String.format("%d%s", 13, "%")
    }
}