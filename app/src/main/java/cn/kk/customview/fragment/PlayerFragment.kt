package cn.kk.customview.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import cn.kk.base.fragment.BaseFragment
import cn.kk.customview.R

class PlayerFragment: BaseFragment(), SurfaceHolder.Callback {

    override fun getLayoutId(): Int {
       return R.layout.fragment_player
    }

    val mediaPlayer = MediaPlayer()

    private val mediaPrepareListener = object: MediaPlayer.OnPreparedListener {
        override fun onPrepared(mp: MediaPlayer?) {
            mediaPlayer.start()
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

        val surfaceView = rootView.findViewById<SurfaceView>(R.id.surface_view)

        surfaceView.holder.addCallback(this)

        // MediaPlayer
        val videoUrl = "https://fs-gateway.esdict.cn/buckets/main/store_knowledge_circle/11cdf583-4aa2-11e7-8f8c-000c29e6fad9/1efda3b5-5cef-11ec-8804-00505686c5e6/028462b0-9e40-4bbf-83fd-538ff27b4721.mp4?shape=1280x720"
        mediaPlayer.setDataSource(videoUrl)
        mediaPlayer.setOnPreparedListener(mediaPrepareListener)
        mediaPlayer.setOnCompletionListener(mediaCompletionListener)
        mediaPlayer.prepareAsync()


    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        mediaPlayer.setDisplay(holder)
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {

    }

}