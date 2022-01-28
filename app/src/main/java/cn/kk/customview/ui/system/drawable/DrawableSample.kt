package cn.kk.customview.ui.system.drawable

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
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

    override fun getItemNameList(): MutableList<String> {
        return mutableListOf<String>().apply {
            add("BitmapDrawable")
            add("ShapeDrawable")
            add("LayerDrawable")
            add("StateListDrawable")
            add("LevelListDrawable")
            add("TransitionDrawable")
            add("InsetDrawable")
            add("ScaleDrawable")
            add("ClipDrawable")
            add("自定义 Drawable")
        }
    }

    override fun initAdapter() {
        super.initAdapter()
        listAdapter.setOnItemClickListener { adapter, view, position ->
            when(position){
                0 -> openNextUI(MultiDrawable::class.java, itemList[position], MultiDrawable.TYPE_BITMAP_DRAWABLE)
                1 -> openNextUI(MultiDrawable::class.java, itemList[position], MultiDrawable.TYPE_SHAPE_DRAWABLE)
                2 -> openNextUI(MultiDrawable::class.java, itemList[position], MultiDrawable.TYPE_LAYER_DRAWABLE)
                3 -> openNextUI(MultiDrawable::class.java, itemList[position], MultiDrawable.TYPE_STATELIST_DRAWABLE)
            }
        }
    }
}