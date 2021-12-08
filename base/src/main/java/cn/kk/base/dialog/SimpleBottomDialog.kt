package cn.kk.base.dialog

import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import cn.kk.base.R
import cn.kk.base.activity.BaseActivity

/**
 * 简单的底部弹窗 dialog
 */
class SimpleBottomDialog(val mActivity: BaseActivity): BaseBottomDialog(mActivity) {

    init {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_simple_bottom)



        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)


        findViewById<Button>(R.id.btn_exit)?.setOnClickListener { dismiss() }
    }
}