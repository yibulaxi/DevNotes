package cn.kk.customview.ui.system.drawable

import android.view.View
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_multi_drawable.*

/**
 * 可显示多种 Drawable
 */
class MultiDrawable: BaseActivity() {

    companion object {
        val TYPE_BITMAP_DRAWABLE = 0
        val TYPE_SHAPE_DRAWABLE = 1
        val TYPE_LAYER_DRAWABLE = 2
        val TYPE_STATELIST_DRAWABLE = 3
        val TYPE_LEVELLIST_DRAWABLE = 4
    }

    override fun getLayout(): Int {
        return R.layout.activity_multi_drawable
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        when (ui_type) {
            // 对应的是 <bitmap> 标签
            TYPE_BITMAP_DRAWABLE -> view_drawable_bg.setBackgroundResource(R.drawable.kk_bitmap_drawable)
            // 对应的是 <shape> 标签
            TYPE_SHAPE_DRAWABLE -> { /* shape drawable 实体是：GradientDrawable*/ view_drawable_bg.setBackgroundResource(R.drawable.kk_shape_drawable) }
            // 对应的是 <layer-list> 标签
            TYPE_LAYER_DRAWABLE -> {  et_input.visibility = View.VISIBLE }
            // 对应的是 <selector> 标签
            TYPE_STATELIST_DRAWABLE -> {  btn_statelist_drawable.visibility = View.VISIBLE }
            // 对应的是 <selector> 标签
            TYPE_LEVELLIST_DRAWABLE -> {  btn_statelist_drawable.visibility = View.VISIBLE }
            else -> {

            }
        }
    }
}