package cn.kk.av.task_list.task15

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import com.kk.ffmpegdemo.NativeFFmpegDemo
import kotlinx.android.synthetic.main.activity_task15_simple_player.*

class Task15SimplePlayer: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_task15_simple_player
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        val ffmpegDemo = NativeFFmpegDemo()

        tv_info.text = ffmpegDemo.fFmpegInfo
    }
}