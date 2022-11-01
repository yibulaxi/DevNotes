package com.kk.beatbox

import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.SoundPool
import android.util.Log

private const val TAG = "BeatBox"
private const val SOUND_FOLDER = "sample_sounds"
private const val MAX_SOUNDS = 5

/**
 * 资源管理类
 */
class BeatBox(private val assetsManger: AssetManager) {
    val sounds: List<Sound>
    private val soundPool = SoundPool.Builder()
        .setMaxStreams(MAX_SOUNDS)
        .build()
    init {
        sounds = loadSounds()
    }

   private fun loadSounds(): List<Sound>{
        val soundNames: Array<String>
        try {
             soundNames = assetsManger.list(SOUND_FOLDER)!!
            Log.d(TAG, "loadSounds Found: ${soundNames.size} sounds...")
        } catch (e: Exception) {
            return emptyList()
        }

        val sounds = mutableListOf<Sound>()
        soundNames.forEach {
            val assetPath = "$SOUND_FOLDER/$it"
            val sound = Sound(assetPath)
            try {
                load(sound)
                sounds.add(sound)
            } catch (e: Exception) {
                Log.e(TAG, "loadSounds Failed: $it:", e)
            }
        }

        return sounds
    }

    private fun load(sound: Sound){
        val afd: AssetFileDescriptor = assetsManger.openFd(sound.assetPath)
        // 把音频文件载入 SoundPool 待播放
        val soundId = soundPool.load(afd, 1)
        sound.soundId = soundId
    }
    
     fun play(sound: Sound){
        sound.soundId?.let {  // 检查并确保 soundId 不为 null
            soundPool.play(it, 1.0f, 1.0f, 1, 0, 1.0f)
        }
    }

    /**
     * 释放音频资源
     */
    fun release(){
        soundPool.release()
    }

}