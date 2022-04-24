package cn.kk.customview.activity.more.audio

import androidx.fragment.app.Fragment
import cn.kk.customview.R
import cn.kk.customview.activity.BaseFragmentActivity
import cn.kk.customview.ui.fragment.NormalViewFragment

class AudioBasicActivity: BaseFragmentActivity() {


    override fun getFragment(): Fragment {
        when (ui_type) {
            SECTION_1 -> return AudioBasic1Fragment().apply { imgRes = R.drawable.bg_audio_1 }
            SECTION_2 -> return AudioBasic2Fragment()
            SECTION_3 -> return AudioBasic1Fragment().apply { imgRes = R.drawable.bg_audio_music }

            else -> {
                return NormalViewFragment()
            }
        }
    }

    companion object {
        val SECTION_1 = 1
        val SECTION_2 = 2
        val SECTION_3 = 3
        val SECTION_4 = 4
    }

}