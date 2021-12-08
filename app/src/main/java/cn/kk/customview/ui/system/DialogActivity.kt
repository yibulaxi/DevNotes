package cn.kk.customview.ui.system

import android.graphics.Color
import cn.kk.base.activity.BaseActivity
import cn.kk.base.dialog.CommentFragment
import cn.kk.base.dialog.CommentFragmentV2
import cn.kk.base.dialog.SimpleBottomDialog
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_dialog.*

class DialogActivity: BaseActivity() {
    override fun getLayout(): Int {
       return R.layout.activity_dialog
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        tv_show_dialog.setOnClickListener { CommentFragmentV2.showDialog(this) }
        btn_show_simple_dialog.setOnClickListener {
            window?.navigationBarColor = Color.TRANSPARENT
            SimpleBottomDialog(this).show()
        }
    }

}