package cn.kk.customview.activity.work

import android.text.method.ScrollingMovementMethod
import cn.kk.base.activity.BaseActivity
import cn.kk.base.utils.IOUtils
import cn.kk.base.utils.TimeHelper
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_save_log.*

class SaveLogActivity: BaseActivity() {

    val filePath by lazy {
        application.filesDir.absolutePath.plus("/logs").plus("/").plus("log_1.txt")
    }

    override fun getLayout(): Int {
        return R.layout.activity_save_log
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        tv_log.movementMethod = ScrollingMovementMethod()

        btn_save_log.setOnClickListener {
           IOUtils.saveData2File("this is a log".plus(" @ ").plus(TimeHelper.getTimeSecond()), filePath)
        }

        btn_read_log.setOnClickListener {
           val log = IOUtils.readFromFile(filePath)
            tv_log.text = log
        }
    }
}