package cn.kk.av.task_list.task2

import android.media.AudioFormat
import android.media.MediaRecorder

/**
 * 音频配置
 */
class AudioConfig {

    companion object {
        // 采样率
        val SAMPLE_RATE_WITH_HZ = 44100

        // 声道数 CHANNEL_IN_MONO 能保证所有设备可以使用
        val CHANNEL_CONFIG = AudioFormat.CHANNEL_IN_MONO

        // 音频数据格式
        val AUDIO_FORMAT = AudioFormat.ENCODING_PCM_16BIT

        // 音频采集设备来源
        val AUDIO_SOURCE_MIC = MediaRecorder.AudioSource.MIC
    }


}