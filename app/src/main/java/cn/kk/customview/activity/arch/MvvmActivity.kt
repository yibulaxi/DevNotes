package cn.kk.customview.activity.arch

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.activity.arch.mvvm.BeatBox
import cn.kk.customview.activity.arch.mvvm.Sound
import cn.kk.customview.activity.arch.mvvm.SoundViewModel
import cn.kk.customview.databinding.ActivityMvvmBinding
import cn.kk.customview.databinding.ListItemSoundBinding

/**
 * 1. kapt plugin & dataBinding in build.gradle
 * 2.
 */
class MvvmActivity: AppCompatActivity() {

    lateinit var beatBox: BeatBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMvvmBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm)

        beatBox = BeatBox(assets)

        binding.rvListSound.apply {
            layoutManager = GridLayoutManager(context, 4)
            adapter = SoundAdapter(beatBox.sounds)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        beatBox.release()
    }


    private inner class SoundAdapter(val sounds: List<Sound>): RecyclerView.Adapter<SoundAdapter.SoundHolder>() {

        inner class SoundHolder(private val binding: ListItemSoundBinding): RecyclerView.ViewHolder(binding.root) {
            init {
                binding.viewModel = SoundViewModel(beatBox)
            }
            fun bindData(sound: Sound){
                binding.apply {
                    viewModel?.sound = sound
                    executePendingBindings()
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
            val binding = DataBindingUtil.inflate<ListItemSoundBinding>(layoutInflater, R.layout.list_item_sound, parent ,false)
            return SoundHolder(binding)
        }

        override fun onBindViewHolder(holder: SoundHolder, position: Int) {
            holder.bindData(sounds[position])
        }

        override fun getItemCount(): Int {
            return sounds.size
        }
    }
}