package cn.kk.customview.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import cn.kk.base.UIHelper
import cn.kk.base.fragment.BaseFragment
import cn.kk.customview.R
import kotlinx.android.synthetic.main.fragment_player.*

/**
 * 播放器页面
 * 1. 播放视频 ok
 * 2. status bar 设置为黑色 ok
 * 3. 进度条
 * 4. 控制按钮
 * 5. 时间
 * 6. 全屏切换
 * 7. 音量调整
 * 8. 亮度调整
 */
class PlayerFragment: BaseFragment(), SurfaceHolder.Callback {

    override fun getLayoutId(): Int {
       return R.layout.fragment_player
    }

    val mediaPlayer = MediaPlayer()
    var mediaPrepared = false
    var mediaPauseState = false

    private val mediaPrepareListener = object: MediaPlayer.OnPreparedListener {
        override fun onPrepared(mp: MediaPlayer?) {
            mediaPlayer.start()
            mediaPrepared = true
        }
    }

    private val mediaCompletionListener = object : MediaPlayer.OnCompletionListener {
        override fun onCompletion(mp: MediaPlayer?) {
            mediaPlayer.stop()
            mediaPlayer.reset()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // region step2: status bar 设置为黑色
        UIHelper.setStatusBarDark(activity!!)
        // endregion

        // region step1: play media
        val surfaceView = rootView.findViewById<SurfaceView>(R.id.surface_view)

        surfaceView.holder.addCallback(this)

        // MediaPlayer
        val videoUrl = "https://fs-gateway.esdict.cn/buckets/main/store_knowledge_circle/11cdf583-4aa2-11e7-8f8c-000c29e6fad9/1efda3b5-5cef-11ec-8804-00505686c5e6/028462b0-9e40-4bbf-83fd-538ff27b4721.mp4?shape=1280x720"
        mediaPlayer.setDataSource(videoUrl)
        mediaPlayer.setOnPreparedListener(mediaPrepareListener)
        mediaPlayer.setOnCompletionListener(mediaCompletionListener)
        mediaPlayer.prepareAsync()
        // endregion

        // region step4: 控制按钮
        videoContainer.setOnClickListener {
            // 显示控制按钮，然后 3s 后再隐藏
            if (btn_control_play.visibility != View.VISIBLE) {
                btn_control_play.visibility = View.VISIBLE
                btn_control_play.postDelayed(object : Runnable {
                    override fun run() {
                        if (mediaPlayer.isPlaying) {
                            btn_control_play.visibility = View.INVISIBLE
                        }
                    }

                }, 3000)
            }
        }

        btn_control_play.setOnClickListener {
            // play or pause
            playOrPause()
        }
        // endregion
    }

    fun playOrPause(){
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            mediaPauseState = true
        } else {
            mediaPlayer.start()
            mediaPauseState = false
        }
        updatePlayControlBtnState(!mediaPauseState)
    }

    fun updatePlayControlBtnState(play: Boolean){
        btn_control_play.setImageResource(if (play) R.drawable.icon_pause else R.drawable.icon_play)
    }

    // region surface callback
    override fun surfaceCreated(holder: SurfaceHolder) {
        mediaPlayer.setDisplay(holder)
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {

    }
    // endregion
}