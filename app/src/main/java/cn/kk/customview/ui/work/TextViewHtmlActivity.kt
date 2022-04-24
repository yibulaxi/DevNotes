package cn.kk.customview.ui.work

import android.text.Html
import cn.kk.base.activity.BaseActivity
import cn.kk.base.utils.AssetsHelper
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_textview_html.*

class TextViewHtmlActivity: BaseActivity() {
    override fun getLayout(): Int = R.layout.activity_textview_html

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        val html = Html.fromHtml(AssetsHelper.getHtmlValue(this, "html", "section_4.html"))
        text_view_html.text = html
    }
}