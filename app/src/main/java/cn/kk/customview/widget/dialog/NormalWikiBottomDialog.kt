package cn.kk.customview.widget.dialog

import android.os.Bundle
import android.widget.TextView
import cn.kk.base.activity.BaseActivity
import cn.kk.base.dialog.SimpleBottomDialog
import cn.kk.customview.R
import cn.kk.customview.bean.SimpleWikiModel

class NormalWikiBottomDialog(mActivity: BaseActivity,val model: SimpleWikiModel): SimpleBottomDialog(mActivity, R.style.EdgeToEdgeDialogStyle) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_normal_wiki_bottom)

        findViewById<TextView>(R.id.btn_exit)?.setOnClickListener { dismiss() }
        findViewById<TextView>(R.id.tv_title)?.text = model.title
        findViewById<TextView>(R.id.tv_wiki)?.text = model.intro
    }
}