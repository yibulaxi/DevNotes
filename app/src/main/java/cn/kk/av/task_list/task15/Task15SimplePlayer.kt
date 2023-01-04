package cn.kk.av.task_list.task15

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import com.kk.ffmpegdemo.NativeFFmpegDemo
import kotlinx.android.synthetic.main.activity_task15_simple_player.*

class Task15SimplePlayer: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_task15_simple_player
    }

    val videoPath = "/sdcard/av/videos/out.mp4"

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        val nativeFFmpegDemo = NativeFFmpegDemo()
        tv_av_format_info.text = nativeFFmpegDemo.fFmpegAvFormatVersion

        btn_play_video.setOnClickListener {
            ff_video.playVideo(videoPath)
        }
    }
}