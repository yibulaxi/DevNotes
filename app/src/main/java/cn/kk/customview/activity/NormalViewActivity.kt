package cn.kk.customview.activity

import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import cn.kk.base.UIHelper
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.widget.GradientImageView
import cn.kk.customview.widget.VocabularyLevelBar
import com.example.hencoder.AvatarView
import com.example.hencoder.CameraView
import com.example.hencoder.MultilineTextView
import com.example.hencoder.draw.SimpleDrawable
import com.example.hencoder.touch.ScalableImageView
import com.example.hencoder.touch.TouchView
import kotlinx.android.synthetic.main.activity_normal_view.*

/**
 * 用来显示单纯的 View(各种自定义的 View) 页面
 */
class NormalViewActivity: BaseActivity() {

    companion object {
        // 混合模式
        val VIEW_TYPE_XFERMODE_AVATARVIEW = 0
        // 文字测量
        val VIEW_TYPE_TEXT_MEAUSRE = 1
        // 范围裁剪和几何变换
        val VIEW_TYPE_CLIP_AND_TRANS = 2
        // 图片渐变
        val VIEW_TYPE_GRADIENT_IMG = 3
        // 区间拖拽
        val VIEW_TYPE_DRAG_LEVEL = 4
        // 自定义 drawable
        val VIEW_TYPE_DRAWABLE = 5

        // 触摸反馈：原理全解析
        val VIEW_TYPE_TOUCH_FEED_1 = 10
        val VIEW_TYPE_TOUCH_FEED_2 = 11 // 双向滑动的 ScalableImageView
    }

    override fun getLayout(): Int {
        return R.layout.activity_normal_view
    }


    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        when (intent.getIntExtra(INTENT_TYPE_KEY, -1)) {
            VIEW_TYPE_XFERMODE_AVATARVIEW -> view_container.addView(AvatarView(this))
            VIEW_TYPE_TEXT_MEAUSRE -> view_container.addView(MultilineTextView(this))
            VIEW_TYPE_CLIP_AND_TRANS -> view_container.addView(CameraView(this))
            VIEW_TYPE_GRADIENT_IMG -> view_container.addView(GradientImageView(this))
            VIEW_TYPE_DRAG_LEVEL -> view_container.addView(VocabularyLevelBar(this).apply {
                layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT).apply {
                    height = UIHelper.dip2px(mSelf, 35.0)
                    setPadding(0, UIHelper.dp2px(10.0f).toInt(), 0, UIHelper.dp2px(10.0f).toInt())
                    setMargins(UIHelper.dp2px(20f).toInt(), 0, UIHelper.dp2px(20.0f).toInt(), 0)
                    gravity = Gravity.CENTER
                }
            })
            VIEW_TYPE_DRAWABLE -> view_container.addView(SimpleDrawable(this))
            VIEW_TYPE_TOUCH_FEED_1 -> view_container.addView(getTouchView().apply {
                /*findViewById<TouchView>(R.id.touchView).setOnClickListener {
                    showToast("click..")
                }*/
            })
            VIEW_TYPE_TOUCH_FEED_2 -> view_container.addView(getScalableImageView())
            else -> {
            }
        }
    }

    /**
     * 获取 TouchView
     * 以填充布局文件的方式
     */
   private fun getTouchView(): View {
       return layoutInflater.inflate(R.layout.view_at_touchview_layout, null)
    }

    private fun getScalableImageView(): View {
        return layoutInflater.inflate(R.layout.view_at_scalable_image_layout, null)
    }
}