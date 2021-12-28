package cn.kk.customview.ui.cool300.chapter1

import cn.kk.base.UIHelper
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.simple_009.*

/**
 * 使用资源创建自定义背景的椭圆按钮
 */
class Simple_009: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.simple_009
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        btn_oval.setOnClickListener { UIHelper.toast("click oval but!", this) }
    }
}