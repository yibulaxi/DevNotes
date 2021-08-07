package cn.kk.base

import android.content.Context
import android.media.AudioManager
import android.media.SoundPool

/**
 * 媒体帮助类
 */
class MediaHelper(val context: Context) {

    private val soundPoolMap = HashMap<Int, Int>()

    // region 音频池
    private val soundPool: SoundPool by lazy {
        SoundPool(4, AudioManager.STREAM_MUSIC, 100)

    }
    // endregion 音频池

    // region 初始化
    init {
        // 存放音频资源
        soundPoolMap[0] = soundPool.load(context, R.raw.beep_once, 0)
    }
    // endregion 初始化

    // region 对外提供的方法

    fun playBeep(){
        playSoundByID(0, 0)
    }
    // endregion 对外提供的方法

    // region 内部方法

    /**
     * 播放音频
     * @param soundKey 音频资源 key, 就是 soundPoolMap 里面的 key
     * @param loop 播放循环次数
     */
    private fun playSoundByID(soundKey: Int, loop: Int){
        val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val streamVolumeCurrent = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
        val streamVolumeMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        val volume: Float = streamVolumeCurrent / streamVolumeMax.toFloat()

        soundPoolMap[soundKey]?.let { soundPool.play(it, volume, volume, 1, loop, 1f) }
    }

    // endregion 内部方法
}