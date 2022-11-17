package cn.kk.customview.ui.cool300.chapter8

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.text.TextUtils
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_simple_intent.*
import java.io.File

class SimpleIntentActivity: BaseActivity() {
    val TEST_PDF_PATH = "/sdcard/Download/squirrel.pdf/squirrel.pdf"

    companion object {
        val TYPE_OPEN_PDF = 1
    }
    override fun getLayout(): Int {
        return R.layout.activity_simple_intent
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        if (isTypeOpenPDF()) {
            btn_share.text = "Open PDF"
            et_input.hint = "请输入 PDF 文件路径!"
            et_input.setText(TEST_PDF_PATH)
        }

        btn_share.setOnClickListener {
            if (isTypeOpenPDF()) {
                openPDF()
            } else {
                share2WechatV2()
            }
        }
    }

    private fun isTypeOpenPDF(): Boolean {
        return ui_type == TYPE_OPEN_PDF
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

    private fun openPDF(){
        if (TextUtils.isEmpty(et_input.text)) {
            showToast("路径不能为空!")
            return
        }
        val intent = Intent("android.intent.action.VIEW").apply {
            addCategory("android.intent.category.DEFAULT")
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            // Android 7.0 以上不能这么用了：https://www.jianshu.com/p/558f90275c7c
            setDataAndType(Uri.fromFile(File(et_input.text.toString())), "application/pdf")
        }
        startActivity(intent)
    }
}