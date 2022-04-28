package cn.kk.customview.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.fragment.BaseFragment
import cn.kk.customview.R
import cn.kk.customview.adapter.BaseChapterAdapter
import cn.kk.customview.bean.BaseItem
import cn.kk.customview.bean.ItemChapterModel
import cn.kk.customview.bean.ItemSectionModel
import cn.kk.customview.ui.cool300.chapter1.Simple_005
import cn.kk.customview.ui.cool300.chapter1.Simple_009
import cn.kk.customview.ui.cool300.chapter1.Simple_010
import cn.kk.customview.ui.cool300.chapter1.Simple_022
import cn.kk.customview.ui.cool300.chapter3.Simple_063
import cn.kk.customview.ui.cool300.chapter3.Simple_071
import cn.kk.customview.ui.cool300.chapter3.Simple_072
import cn.kk.customview.ui.cool300.chapter5.Simple_143
import kotlinx.android.synthetic.main.chapter_list_layout.*

/**
 * 以章节列表形式显示
 */
class NormalChapterListFragment: BaseFragment() {

    override fun getLayoutId(): Int = R.layout.normal_chapter_list_without_title_layout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val parts = resources.getStringArray(R.array.cool_300).toMutableList()

        rv_chapter_list.layoutManager = LinearLayoutManager(context)
        val chapterModelList = mutableListOf<ItemChapterModel>()

        val baseItemActionValue = BaseItem.ACTION_COOL300
        for (part in parts) {
            val size = chapterModelList.size
            chapterModelList.add(ItemChapterModel(part, getSectionDataList(baseItemActionValue + size + 1)))
        }
        rv_chapter_list.adapter = BaseChapterAdapter(chapterModelList).apply {
            mItemSectionClickListener = object : BaseChapterAdapter.OnItemSectionClickListener {
                override fun onSectionClick(item: ItemSectionModel) {
                    when(item.item_action) {
                        BaseItem.ACTION_COOL300_common_ui_005 -> startNextUI(Simple_005::class.java, item.title)
                        BaseItem.ACTION_COOL300_common_ui_009 -> startNextUI(Simple_009::class.java, item.title)
                        BaseItem.ACTION_COOL300_common_ui_010 -> startNextUI(Simple_010::class.java, item.title)
                        BaseItem.ACTION_COOL300_common_ui_022 -> startNextUI(Simple_022::class.java, item.title)

                        BaseItem.ACTION_COOL300_menu_063 -> startNextUI(Simple_063::class.java, item.title)
                        BaseItem.ACTION_COOL300_menu_071 -> startNextUI(Simple_071::class.java, item.title)
                        BaseItem.ACTION_COOL300_menu_072 -> startNextUI(Simple_072::class.java, item.title)

                        BaseItem.ACTION_COOL300_anim_143-> startNextUI(Simple_143::class.java, item.title)
                    }
                }

            }
        }
    }

    private fun getSectionDataList(chapterType: Int): MutableList<ItemSectionModel> {
        val sectionModelList = mutableListOf<ItemSectionModel>()
        when(chapterType) {
            BaseItem.ACTION_COOL300_common_ui -> {
                sectionModelList.add(ItemSectionModel("005. 自定义 CheckBox 风格", true).apply { item_action = BaseItem.ACTION_COOL300_common_ui_005 })
                sectionModelList.add(ItemSectionModel("009. Drawable shape 作为 btn 背景", true).apply { item_action = BaseItem.ACTION_COOL300_common_ui_009 })
                sectionModelList.add(ItemSectionModel("010. Drawable shape 渐变圆角按钮", true).apply { item_action = BaseItem.ACTION_COOL300_common_ui_010 })
                sectionModelList.add(ItemSectionModel("022. 自定义 selector 以透明前景切换控件", true).apply { item_action = BaseItem.ACTION_COOL300_common_ui_022 })
            }

            BaseItem.ACTION_COOL300_notification -> {

            }
            BaseItem.ACTION_COOL300_menu -> {
                sectionModelList.add(ItemSectionModel("063. 使用 Toolbar 在工具栏上添加菜单", true).apply { item_action = BaseItem.ACTION_COOL300_menu_063 })
                sectionModelList.add(ItemSectionModel("071. 在弹出底部菜单时，主窗口立刻变暗", true).apply { item_action = BaseItem.ACTION_COOL300_menu_071 })
                sectionModelList.add(ItemSectionModel("072. 长按 view 弹出上下文", true).apply { item_action = BaseItem.ACTION_COOL300_menu_072 })
            }
            BaseItem.ACTION_COOL300_graphic_picture -> {

            }
            BaseItem.ACTION_COOL300_anim -> {
                sectionModelList.add(ItemSectionModel("143. 使用 RippleDrawable 创建波纹扩散动画", true).apply { item_action = BaseItem.ACTION_COOL300_anim_143 })
            }
            BaseItem.ACTION_COOL300_file_data -> {

            }
            BaseItem.ACTION_COOL300_sys_device -> {

            }
            BaseItem.ACTION_COOL300_intent -> {

            }
            BaseItem.ACTION_COOL300_third_part_sdk -> {

            }

            else -> { }
        }

        return sectionModelList
    }
}