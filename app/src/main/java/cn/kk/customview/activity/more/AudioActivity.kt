package cn.kk.customview.activity.more

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.activity.more.audio.AudioBasicActivity
import cn.kk.customview.bean.BaseItem
import cn.kk.customview.bean.ItemChapterModel
import cn.kk.customview.bean.ItemSectionModel
import cn.kk.customview.widget.ItemFolderView
import kotlinx.android.synthetic.main.activity_audio.*

/**
 * 音频知识学习
 */
class AudioActivity: BaseActivity() {

    override fun getLayout() = R.layout.activity_audio

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        val parts = resources.getStringArray(R.array.audio_parts).toMutableList()

        // region 音频基础
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
            add(ItemSectionModel(sectionsBasicName[2]).apply { item_action = BaseItem.ACTION_MORE_AUDIO_BASIC_3 })
            add(ItemSectionModel(sectionsBasicName[3]).apply { item_action = BaseItem.ACTION_MORE_AUDIO_BASIC_4 })
        }

        part_basic.setData(ItemChapterModel(parts[0], sectionModelList), true)
        part_basic.sectionClickListener = object : ItemFolderView.SectionClickListener {
            override fun onSectionClick(item: ItemSectionModel) {
                when(item.item_action) {
                    BaseItem.ACTION_MORE_AUDIO_BASIC_1 -> openNextUI(AudioBasicActivity::class.java, item.title, AudioBasicActivity.SECTION_1)
                    BaseItem.ACTION_MORE_AUDIO_BASIC_2 -> openNextUI(AudioBasicActivity::class.java, item.title, AudioBasicActivity.SECTION_2)
                    BaseItem.ACTION_MORE_AUDIO_BASIC_3 -> openNextUI(AudioBasicActivity::class.java, item.title, AudioBasicActivity.SECTION_3)
                    BaseItem.ACTION_MORE_AUDIO_BASIC_4 -> openNextUI(AudioBasicActivity::class.java, item.title, AudioBasicActivity.SECTION_4)
                }
            }
        }
        // endregion

        // region 音频降噪
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

        part_denoise.setData(ItemChapterModel(parts[1], sectionModelDeNoiseList))
        part_denoise.sectionClickListener = object : ItemFolderView.SectionClickListener {
            override fun onSectionClick(item: ItemSectionModel) {
                when(item.item_action) {
                }
            }
        }
        // endregion

        // region 回声消除
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

        part_remove_echo.setData(ItemChapterModel(parts[2], sectionModelRemoveEchoList))
        part_remove_echo.sectionClickListener = object : ItemFolderView.SectionClickListener {
            override fun onSectionClick(item: ItemSectionModel) {
                when(item.item_action) {
                }
            }
        }
        // endregion

        // region 音频网络传输
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

        part_net_trans.setData(ItemChapterModel(parts[3], sectionModelNetTransList))
        part_net_trans.sectionClickListener = object : ItemFolderView.SectionClickListener {
            override fun onSectionClick(item: ItemSectionModel) {
                when(item.item_action) {
                }
            }
        }
        // endregion

        // region 空间音频
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

        part_space.setData(ItemChapterModel(parts[4], sectionModelSpaceList))
        part_space.sectionClickListener = object : ItemFolderView.SectionClickListener {
            override fun onSectionClick(item: ItemSectionModel) {
                when(item.item_action) {
                }
            }
        }
        // endregion

        // region 音频特效生成与算法
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

        part_special_effect.setData(ItemChapterModel(parts[5], sectionModelSpecialEffectList))
        part_special_effect.sectionClickListener = object : ItemFolderView.SectionClickListener {
            override fun onSectionClick(item: ItemSectionModel) {
                when(item.item_action) {
                }
            }
        }
        // endregion

        // region 结束语
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

        part_end.setData(ItemChapterModel(parts[5], sectionModelEndList))
        part_end.sectionClickListener = object : ItemFolderView.SectionClickListener {
            override fun onSectionClick(item: ItemSectionModel) {
                when(item.item_action) {
                }
            }
        }
        // endregion
    }
}