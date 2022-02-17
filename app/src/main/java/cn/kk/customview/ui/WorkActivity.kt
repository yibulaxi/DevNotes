package cn.kk.customview.ui

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_work.*

class WorkActivity: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_work
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        timeProgress.duration = 3000
        timeProgress.hideWhenFinished = false

        timeProgress.start()
    }
}