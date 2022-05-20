package cn.kk.customview.ui.work

import cn.kk.base.UIHelper
import cn.kk.base.activity.BaseActivity
import cn.kk.base.utils.SystemHelper
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_expand_view_touch.*

/**
 * 扩大 view 点击范围
 */
class ExpandViewTouchDemo: BaseActivity() {
    override fun getLayout(): Int = R.layout.activity_expand_view_touch

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        UIHelper.expendTouchArea(tv_expand_after, UIHelper.dp2px(100f).toInt())

        tv_expand_before.setOnClickListener {
            showToast("click")
            SystemHelper.vibrate(mSelf, 200)
        }
        tv_expand_after.setOnClickListener {
            showToast("click...")
            SystemHelper.vibrate(mSelf, 200)
        }
    }
}