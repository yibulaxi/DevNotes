package cn.kk.customview.ui

import android.view.View
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.elementary.chapter1.TimeProgressbar
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

        btn_rest.visibility = View.INVISIBLE
        timeProgress.progressCallback = object : TimeProgressbar.ProgressCallback{
            override fun onProgress(progress: Long) {
            }

            override fun onFinish() {
                btn_rest.visibility = View.VISIBLE
            }


        }
        btn_rest.setOnClickListener {
            timeProgress.reset()
            timeProgress.start()
            btn_rest.visibility = View.INVISIBLE
        }
    }
}