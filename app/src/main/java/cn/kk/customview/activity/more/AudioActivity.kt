package cn.kk.customview.activity.more

import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.activity.BaseActivity
import cn.kk.base.utils.AssetsHelper
import cn.kk.customview.R
import cn.kk.customview.activity.NormalWebViewActivity
import cn.kk.customview.activity.more.audio.AudioBasicActivity
import cn.kk.customview.adapter.BaseChapterAdapter
import cn.kk.customview.bean.BaseItem
import cn.kk.customview.bean.ItemChapterModel
import cn.kk.customview.bean.ItemSectionModel
import kotlinx.android.synthetic.main.chapter_list_layout.*

/**
 * 音频知识学习
 */
class AudioActivity: BaseActivity() {

    override fun getLayout() = R.layout.normal_chapter_list_layout

    private fun getSectionDataList(chapterType: Int): MutableList<ItemSectionModel> {
        when(chapterType) {

            // region 音频基础
            BaseItem.ACTION_MORE_AUDIO_BASIC -> {
                val sectionsBasicName = resources.getStringArray(R.array.audio_basic_types).toMutableList()

                val sectionModelList = mutableListOf<ItemSectionModel>().apply {
                    add(ItemSectionModel(sectionsBasicName[0]).apply {
                        item_action = BaseItem.ACTION_MORE_AUDIO_BASIC_1
                        finishTag = true
                    })
                    add(ItemSectionModel(sectionsBasicName[1]).apply {
                        item_action = BaseItem.ACTION_MORE_AUDIO_BASIC_2
                        finishTag = true
                    })
                    add(ItemSectionModel(sectionsBasicName[2]).apply {
                        item_action = BaseItem.ACTION_MORE_AUDIO_BASIC_3
                        finishTag = true
                    })
                    add(ItemSectionModel(sectionsBasicName[3]).apply {
                        item_action = BaseItem.ACTION_MORE_AUDIO_BASIC_4
                        finishTag = true
                    })
                }
                return sectionModelList
            }
            // endregion

            // region 音频降噪
            BaseItem.ACTION_MORE_AUDIO_DENOISE -> {
                val sectionsDeNoiseName = resources.getStringArray(R.array.audio_denoise).toMutableList()

                val sectionModelDeNoiseList = mutableListOf<ItemSectionModel>().apply {
                    add(ItemSectionModel(sectionsDeNoiseName[0]).apply {
                        item_action = BaseItem.ACTION_MORE_AUDIO_DENOISE_1
                        finishTag = false
                    })
                    add(ItemSectionModel(sectionsDeNoiseName[1]).apply {
                        item_action = BaseItem.ACTION_MORE_AUDIO_DENOISE_2
                        finishTag = false
                    })
                }
                return sectionModelDeNoiseList
            }
            // endregion

            // region 回声消除
            BaseItem.ACTION_MORE_AUDIO_REMOVE_ECHO -> {
                val sectionsRemoveEchoName = resources.getStringArray(R.array.audio_remove_echo).toMutableList()

                val sectionModelRemoveEchoList = mutableListOf<ItemSectionModel>().apply {
                    add(ItemSectionModel(sectionsRemoveEchoName[0]).apply {
                        item_action = BaseItem.ACTION_MORE_AUDIO_REMOVE_ECHO_1
                        finishTag = false
                    })
                    add(ItemSectionModel(sectionsRemoveEchoName[1]).apply {
                        item_action = BaseItem.ACTION_MORE_AUDIO_REMOVE_ECHO_2
                        finishTag = false
                    })
                }
                return sectionModelRemoveEchoList
            }

            // endregion

            // region 音频网络传输
            BaseItem.ACTION_MORE_AUDIO_NET_TRANS -> {
                val sectionsNetTransName = resources.getStringArray(R.array.audio_net_trans).toMutableList()

                val sectionModelNetTransList = mutableListOf<ItemSectionModel>().apply {
                    add(ItemSectionModel(sectionsNetTransName[0]).apply {
                        item_action = BaseItem.ACTION_MORE_AUDIO_NET_TRANS_1
                        finishTag = false
                    })
                    add(ItemSectionModel(sectionsNetTransName[1]).apply {
                        item_action = BaseItem.ACTION_MORE_AUDIO_NET_TRANS_2
                        finishTag = false
                    })
                    add(ItemSectionModel(sectionsNetTransName[2]).apply {
                        item_action = BaseItem.ACTION_MORE_AUDIO_NET_TRANS_3
                        finishTag = false
                    })
                }
                return sectionModelNetTransList
            }
            // endregion

            // region 空间音频
            BaseItem.ACTION_MORE_AUDIO_SPACE -> {
                val sectionsSpaceName = resources.getStringArray(R.array.audio_space).toMutableList()

                val sectionModelSpaceList = mutableListOf<ItemSectionModel>().apply {
                    add(ItemSectionModel(sectionsSpaceName[0]).apply {
                        item_action = BaseItem.ACTION_MORE_AUDIO_SPACE_1
                        finishTag = false
                    })
                    add(ItemSectionModel(sectionsSpaceName[1]).apply {
                        item_action = BaseItem.ACTION_MORE_AUDIO_SPACE_2
                        finishTag = false
                    })
                }
                return sectionModelSpaceList
            }
            // endregion

            // region 音频特效生成与算法
            BaseItem.ACTION_MORE_AUDIO_SPECIAL_EFFECT -> {
                val sectionsSpecialEffectName = resources.getStringArray(R.array.audio_special_effect).toMutableList()

                val sectionModelSpecialEffectList = mutableListOf<ItemSectionModel>().apply {
                    add(ItemSectionModel(sectionsSpecialEffectName[0]).apply {
                        item_action = BaseItem.ACTION_MORE_AUDIO_SPECIAL_EFFECT_1
                        finishTag = false
                    })
                    add(ItemSectionModel(sectionsSpecialEffectName[1]).apply {
                        item_action = BaseItem.ACTION_MORE_AUDIO_SPECIAL_EFFECT_1
                        finishTag = false
                    })
                    add(ItemSectionModel(sectionsSpecialEffectName[2]).apply {
                        item_action = BaseItem.ACTION_MORE_AUDIO_SPECIAL_EFFECT_1
                        finishTag = false
                    })
                }
                return sectionModelSpecialEffectList
            }
            // endregion

            // region 结束语
            BaseItem.ACTION_MORE_AUDIO_END -> {
                val sectionsEndName = resources.getStringArray(R.array.audio_end).toMutableList()

                val sectionModelEndList = mutableListOf<ItemSectionModel>().apply {
                    add(ItemSectionModel(sectionsEndName[0]).apply {
                        item_action = BaseItem.ACTION_MORE_AUDIO_END_1
                        finishTag = false
                    })
                    add(ItemSectionModel(sectionsEndName[1]).apply {
                        item_action = BaseItem.ACTION_MORE_AUDIO_END_2
                        finishTag = false
                    })
                }
                return sectionModelEndList
            }
            // endregion

            else -> {
              return  mutableListOf<ItemSectionModel>()
            }
        }
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        val parts = resources.getStringArray(R.array.audio_parts).toMutableList()

        rv_chapter_list.layoutManager = LinearLayoutManager(this)
        rv_chapter_list.adapter = BaseChapterAdapter(mutableListOf<ItemChapterModel>().apply {
            add(ItemChapterModel(parts[0], getSectionDataList(BaseItem.ACTION_MORE_AUDIO_BASIC)))
            add(ItemChapterModel(parts[1], getSectionDataList(BaseItem.ACTION_MORE_AUDIO_DENOISE)))
            add(ItemChapterModel(parts[2], getSectionDataList(BaseItem.ACTION_MORE_AUDIO_REMOVE_ECHO)))
            add(ItemChapterModel(parts[3], getSectionDataList(BaseItem.ACTION_MORE_AUDIO_NET_TRANS)))
            add(ItemChapterModel(parts[4], getSectionDataList(BaseItem.ACTION_MORE_AUDIO_SPACE)))
            add(ItemChapterModel(parts[5], getSectionDataList(BaseItem.ACTION_MORE_AUDIO_SPECIAL_EFFECT)))
            add(ItemChapterModel(parts[6], getSectionDataList(BaseItem.ACTION_MORE_AUDIO_END)))
        }).apply {
            mItemSectionClickListener = object : BaseChapterAdapter.OnItemSectionClickListener {
                override fun onSectionClick(item: ItemSectionModel) {
                    when(item.item_action) {
                        BaseItem.ACTION_MORE_AUDIO_BASIC_1 -> openNextUI(AudioBasicActivity::class.java, item.title, AudioBasicActivity.SECTION_1)
                        BaseItem.ACTION_MORE_AUDIO_BASIC_2 -> openNextUI(AudioBasicActivity::class.java, item.title, AudioBasicActivity.SECTION_2)
                        BaseItem.ACTION_MORE_AUDIO_BASIC_3 -> openNextUI(AudioBasicActivity::class.java, item.title, AudioBasicActivity.SECTION_3)
                        BaseItem.ACTION_MORE_AUDIO_BASIC_4 -> openNextUI(NormalWebViewActivity::class.java, item.title, -1, AssetsHelper.getHtmlFilePath("section_4.html"))
                    }
                }

            }
        }

    }
}