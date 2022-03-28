package cn.kk.customview.ui.fragment

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.R
import cn.kk.base.UIHelper
import cn.kk.base.activity.BaseActivity
import cn.kk.base.adapter.ListAdapter
import cn.kk.base.bean.ListItemAction
import cn.kk.base.fragment.BaseFragment
import cn.kk.customview.chapter.c1.DrawBasicActivity
import cn.kk.customview.chapter.c2.AnimActivity
import cn.kk.customview.chapter.c3.DrawHomeActivity
import cn.kk.customview.chapter.c4.ViewHomeActivity
import cn.kk.customview.config.UIConfig
import cn.kk.customview.ui.LottieAnimActivity
import cn.kk.customview.ui.activity.NormalViewActivity
import cn.kk.customview.ui.cool300.chapter1.*
import cn.kk.customview.ui.cool300.chapter3.Simple_063
import cn.kk.customview.ui.cool300.chapter3.Simple_071
import cn.kk.customview.ui.cool300.chapter3.Simple_072
import cn.kk.customview.ui.cool300.chapter5.Simple_143
import cn.kk.customview.ui.hencoder.GraphicLocationAndSizeMeasureActivity
import cn.kk.customview.ui.hencoder.touch.TouchFeedBackActivity
import cn.kk.customview.ui.system.*
import cn.kk.customview.ui.system.drawable.DrawableSample
import cn.kk.customview.ui.system.material.MaterialActivity
import cn.kk.customview.ui.work.FlickerActivity
import cn.kk.customview.ui.work.TimeProgressActivity

/**
 * 普通列表 Fragment
 */
class NormalListFragment: BaseFragment(), ListAdapter.ItemClickListener {

    private val itemList = mutableListOf<String>()
    private val itemActionList = mutableListOf<ListItemAction>()
    var partType = -1

    override fun getLayoutId(): Int {
        return R.layout.fragment_normal_list
    }

    fun addItem(item: String, finishTag: Boolean = false): NormalListFragment {
        itemList.add(item)
        itemActionList.add(ListItemAction(item, finishTag))
        return this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvList = view.findViewById<RecyclerView>(R.id.rv_list_in_fragment)

        rvList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ListAdapter(itemActionList).apply {
                itemClickListener = this@NormalListFragment
            }
        }
    }

    override fun onItemClick(position: Int) {
        // 跳转页面
        val title = itemList[position]
        when(partType){
            UIConfig.PART_SYSTEM_STUDY -> {
                when(position){
                    0 -> startNextUI(DrawBasicActivity::class.java, title)
                    1 -> startNextUI(AnimActivity::class.java, title)
                    2 -> startNextUI(DrawHomeActivity::class.java, title)
                    3 -> startNextUI(ViewHomeActivity::class.java, title)
                }
            }
            // region system UI
            UIConfig.PART_SYSTEM_UI -> {
                when(position){
                    0 -> startNextUI(ImageViewActivity::class.java, title)
                    1 -> startNextUI(DialogActivity::class.java, title)
                    2 -> startNextUI(ImmersiveModeActivity::class.java, title)
                    3 -> startNextUI(CoordinatorLayoutActivity::class.java, title)
                    4 -> startNextUI(CoordinatorLayoutAndCollapsingToolbarLayoutActivity::class.java, title)
                    5 -> startNextUI(CustomBehaviorActivity::class.java, title)
                    6 -> startNextUI(StatusBarActivity::class.java, title)
                    7 -> startNextUI(LineHeightActivity::class.java, title)
                    8 -> startNextUI(MaterialActivity::class.java, title)
                    9 -> startNextUI(TextViewWidthEnableChangeActivity::class.java, title)
                    10 ->startNextUI(TextViewWithDrawableActivity::class.java, title)
                    11 ->startNextUI(IgnoreSystemBigFont::class.java, title)
                    12 ->startNextUI(HtmlText::class.java, title)
                    13 ->startNextUI(AppWidgetSample::class.java, title)
                    14 ->startNextUI(DrawableSample::class.java, title)
                }
            }
            // endregion

            // region cool 300
            UIConfig.SubConfig.COMMON_VIEW -> {
                when (position) {
                    0 -> startNextUI(Simple_005::class.java, itemList[position])
                    1 -> startNextUI(Simple_009::class.java, itemList[position])
                    2 -> startNextUI(Simple_010::class.java, itemList[position])
                    3 -> startNextUI(Simple_022::class.java, itemList[position])
                }
            }
            UIConfig.SubConfig.MENU_VIEW -> {
                when(position){
                    0 -> startNextUI(Simple_063::class.java, itemList[position])
                    1 -> startNextUI(Simple_071::class.java, itemList[position])
                    2 -> startNextUI(Simple_072::class.java, itemList[position])
                }
            }
            UIConfig.SubConfig.ANIM_VIEW -> {
                when(position){
                    0 -> startNextUI(Simple_143::class.java, itemList[position])
                }
            }
            // endregion
            UIConfig.PART_THIRD -> {
                when(position){
                    0 -> startNextUI(LottieAnimActivity::class.java,title)
                }
            }
            // region Hencoder
            UIConfig.PART_HENCODER -> {
                when(position){
                    0 -> startNextUI(GraphicLocationAndSizeMeasureActivity::class.java, title)
                    1 -> startNextUI(NormalViewActivity::class.java, title, NormalViewActivity.VIEW_TYPE_XFERMODE_AVATARVIEW)
                    2 -> startNextUI(NormalViewActivity::class.java, title, NormalViewActivity.VIEW_TYPE_TEXT_MEAUSRE)
                    3 -> startNextUI(NormalViewActivity::class.java, title, NormalViewActivity.VIEW_TYPE_CLIP_AND_TRANS)
                    5 -> startNextUI(NormalViewActivity::class.java, title, NormalViewActivity.VIEW_TYPE_DRAWABLE)
                    11 -> startNextUI(TouchFeedBackActivity::class.java, title)
                }
            }
            // endregion
            UIConfig.PART_WORK -> {
                when(position){
                    0 -> startNextUI(TimeProgressActivity::class.java, title)
                    1 -> startNextUI(FlickerActivity::class.java, title)
                    2 -> startNextUI(NormalViewActivity::class.java, title, NormalViewActivity.VIEW_TYPE_GRADIENT_IMG)
                }
            }
        }
    }

    fun <T: Activity> startNextUI(targetActivity: Class<T>, title: String){
        (activity as BaseActivity).openNextUI(targetActivity, title)
    }

    fun <T: Activity> startNextUI(targetActivity: Class<T>, title: String, type: Int){
        (activity as BaseActivity).openNextUI(targetActivity, title, type)
    }
}