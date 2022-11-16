package cn.kk.customview.ui.cool300.chapter8

import android.content.ComponentName
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

        btn_share.setOnClickListener { share2WechatV2() }
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

    /**
     * 分享直接抵达微信
     * 参考: https://blog.huati365.com/3578179733077f16
     */
    private fun share2WechatV2(){
        if (TextUtils.isEmpty(et_input.text)) {
            showToast("内容不能为空!")
            return
        }
        val intent = Intent()
        val wxFriend = "com.tencent.mm.ui.tools.ShareImgUI" // 微信联系人
        val wxCircleUI = "com.tencent.mm.ui.tools.ShareToTimeLineUI" // 朋友圈
        val comp = ComponentName("com.tencent.mm", wxFriend)
        intent.component = comp
        intent.action = Intent.ACTION_SEND
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, et_input.text.toString())

        startActivity(intent)
    }
}