package cn.kk.customview.ui.activity

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import com.example.hencoder.AvatarView
import kotlinx.android.synthetic.main.activity_normal_view.*

class NormalViewActivity: BaseActivity() {

    companion object {
        val VIEW_TYPE_XFERMODE_AVATARVIEW = 0
    }

    override fun getLayout(): Int {
        return R.layout.activity_normal_view
    }


    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        when (intent.getIntExtra(INTENT_TYPE_KEY, -1)) {
            VIEW_TYPE_XFERMODE_AVATARVIEW -> {
                view_container.addView(AvatarView(this))
            }
            else -> {
            }
        }
    }
}