package cn.kk.customview.ui.cool300.chapter8

import android.content.Intent
import android.text.TextUtils
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_simple_intent.*

class SimpleIntentActivity: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_simple_intent
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        btn_share.setOnClickListener { shareText2Wechat() }
    }

    /**
     * 分享文本到微信
     */
    private fun shareText2Wechat(){
        if (TextUtils.isEmpty(et_input.text)) {
            showToast("内容不能为空!")
            return
        }
        val sendIntent = Intent(Intent.ACTION_SEND).apply {
            setPackage("com.tencent.mm")
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, et_input.text.toString())
        }

        // 判断手机是否安装了微信
        try {
            startActivity(sendIntent)
        } catch (e: Exception) {
            showToast(e.toString())
        }
    }
}