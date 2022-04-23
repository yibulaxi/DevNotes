package cn.kk.customview.activity.more.audio

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.fragment.BaseFragment
import cn.kk.customview.R
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.fragment_audio_basic2.*

/**
 * 如何量化分析语音喜好
 */
class AudioBasic2Fragment: BaseFragment() {

    override fun getLayoutId(): Int = R.layout.fragment_audio_basic2

    private val imgModelList: MutableList<ImgModel> by lazy {
        mutableListOf<ImgModel>().apply {
            add(ImgModel(R.drawable.bg_audio_human))
            add(ImgModel(R.drawable.bg_audio_1))
            add(ImgModel(R.drawable.bg_audio_2))
            add(ImgModel(R.drawable.bg_audio_3))
            add(ImgModel(R.drawable.bg_audio_4))
            add(ImgModel(R.drawable.bg_audio_5))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_imgs.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_imgs.adapter = object : BaseQuickAdapter<ImgModel, BaseViewHolder>(R.layout.item_img, imgModelList){
            override fun convert(holder: BaseViewHolder, item: ImgModel) {
                Glide.with(context).load(item.imgResId).into(holder.getView(R.id.image_view))
            }

        }
    }

    class ImgModel(val imgResId: Int)
}