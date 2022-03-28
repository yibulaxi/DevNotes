package cn.kk.customview.ui.system.drawable

import cn.kk.base.activity.BaseActivity
import cn.kk.base.bean.ListItemAction
import cn.kk.customview.R
import cn.kk.customview.ui.activity.NormalViewActivity
import cn.kk.customview.ui.cool300.chapter1.Simple_005
import cn.kk.customview.ui.cool300.chapter1.Simple_009
import cn.kk.customview.ui.cool300.chapter1.Simple_010
import cn.kk.customview.ui.cool300.chapter1.Simple_022

/**
 * Html 显示在 TextView 上
 */
class DrawableSample: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_basic
    }

    override fun setListViewID(): Int {
        return R.id.rv_list
    }

    override fun getItemNameList(): MutableList<ListItemAction> {
        return mutableListOf<ListItemAction>().apply {
            add(ListItemAction("BitmapDrawable", true))
            add(ListItemAction("ShapeDrawable", true))
            add(ListItemAction("LayerDrawable", true))
            add(ListItemAction("StateListDrawable", true))
            add(ListItemAction("StateListDrawable", true))
            add(ListItemAction("TransitionDrawable", true))
            add(ListItemAction("InsetDrawable", true))
            add(ListItemAction("ScaleDrawable", true))
            add(ListItemAction("RotateDrawable", true))
            add(ListItemAction("ClipDrawable", true))
            add(ListItemAction("自定义 Drawable", true))
        }
    }

    override fun initAdapter() {
        super.initAdapter()
        listAdapter.setOnItemClickListener { adapter, view, position ->
            when(position){
                0 -> openNextUI(MultiDrawable::class.java, itemList[position].title, MultiDrawable.TYPE_BITMAP_DRAWABLE)
                1 -> openNextUI(MultiDrawable::class.java, itemList[position].title, MultiDrawable.TYPE_SHAPE_DRAWABLE)
                2 -> openNextUI(MultiDrawable::class.java, itemList[position].title, MultiDrawable.TYPE_LAYER_DRAWABLE)
                3 -> openNextUI(MultiDrawable::class.java, itemList[position].title, MultiDrawable.TYPE_STATELIST_DRAWABLE)
                4 -> openNextUI(MultiDrawable::class.java, itemList[position].title, MultiDrawable.TYPE_LEVELLIST_DRAWABLE)
                5 -> openNextUI(MultiDrawable::class.java, itemList[position].title, MultiDrawable.TYPE_TRANSITION_DRAWABLE)
                6 -> openNextUI(MultiDrawable::class.java, itemList[position].title, MultiDrawable.TYPE_INSET_DRAWABLE)
                7 -> openNextUI(MultiDrawable::class.java, itemList[position].title, MultiDrawable.TYPE_SCALE_DRAWABLE)
                8 -> openNextUI(MultiDrawable::class.java, itemList[position].title, MultiDrawable.TYPE_ROTATE_DRAWABLE)
                9 -> openNextUI(MultiDrawable::class.java, itemList[position].title, MultiDrawable.TYPE_Clip_DRAWABLE)
                10 -> openNextUI(NormalViewActivity::class.java, itemList[position].title, NormalViewActivity.VIEW_TYPE_DRAWABLE)
            }
        }
    }
}