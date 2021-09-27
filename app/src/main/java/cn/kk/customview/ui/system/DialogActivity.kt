package cn.kk.customview.ui.system

import cn.kk.base.activity.BaseActivity
import cn.kk.base.dialog.CommendFragment
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_dialog.*

class DialogActivity: BaseActivity() {
    override fun getLayout(): Int {
       return R.layout.activity_dialog
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        tv_show_dialog.setOnClickListener { CommendFragment.showDialog(this) }
    }


}