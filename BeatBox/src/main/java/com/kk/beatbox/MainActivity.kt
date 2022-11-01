package com.kk.beatbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kk.beatbox.databinding.ActivityBeatBoxLayoutBinding
import com.kk.beatbox.databinding.ListItemSoundBinding

class MainActivity : AppCompatActivity() {

    private lateinit var beatBox: BeatBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        beatBox = BeatBox(assets)

        val binding: ActivityBeatBoxLayoutBinding = DataBindingUtil.setContentView(this, R.layout.activity_beat_box_layout)

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = SoundAdapter(beatBox.sounds)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        beatBox.release()
    }

    /**
     * RecyclerView item: list_item_sound.xml 的 ViewHolder
     */
     inner class SoundHolder(private val binding: ListItemSoundBinding): RecyclerView.ViewHolder(binding.root){

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

    private inner class SoundAdapter(private val sounds: List<Sound>): RecyclerView.Adapter<SoundHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
            val binding = DataBindingUtil.inflate<ListItemSoundBinding>(layoutInflater, R.layout.list_item_sound, parent, false)
            return SoundHolder(binding)
        }

        override fun onBindViewHolder(holder: SoundHolder, position: Int) {
            holder.bindData(sounds[position])
        }

        override fun getItemCount(): Int = sounds.size

    }

}