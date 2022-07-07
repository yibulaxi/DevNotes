package cn.kk.customview.activity

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import cn.kk.base.UIHelper
import cn.kk.base.activity.BaseActivity
import cn.kk.base.utils.DateHelper
import cn.kk.customview.R
import cn.kk.customview.widget.GradientImageView
import cn.kk.customview.widget.VocabularyLevelBar
import cn.kk.customview.widget.work.CheckInWeekView
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

        // about work
        val VIEW_TYPE_CHECKIN_WEEK = 100
        val VIEW_TYPE_TEXTVIEW_HIGHLIGHT = 101 // TextView 高亮特定内容
        val VIEW_TYPE_TEXTVIEW_MARQUEE = 102   // 跑马灯效果
        val VIEW_TYPE_image_view_svg = 103  // svg
        val VIEW_TYPE_EDIT_TEXT_FOCUS_FIXED = 104  // EditText 焦点不跳
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

            // region checkin week
            VIEW_TYPE_CHECKIN_WEEK -> {
                view_container.addView(getCheckinWeekView())
                view_container.postDelayed({
                    val checkInView = ((view_container.getChildAt(0) as ViewGroup).getChildAt(0) as CheckInWeekView)
                    // 显示打卡动画
                    val ivTemp = ((view_container.getChildAt(0) as ViewGroup).getChildAt(1) as ImageView)
                    checkInView.playAnim(ivTemp)

                }, 1000)
            }
            // endregion
            VIEW_TYPE_TEXTVIEW_HIGHLIGHT -> {
                val highLightContainer = getTextViewWithHighLightView()
                view_container.addView(highLightContainer)

               val tvInfo = highLightContainer.findViewById<TextView>(R.id.tv_info)
                tvInfo.text = "#时间 锄禾日当午，\n#辛苦 汗滴禾下土。\n#吃饭 谁知盘中餐？\n#总结 粒粒皆辛苦。";
                UIHelper.highlightTag(tvInfo, ContextCompat.getColor(this, R.color.colorPrimary))
            }
            // region TextView highlight
            VIEW_TYPE_TEXTVIEW_MARQUEE -> view_container.addView(getMarqueeTextView())
            VIEW_TYPE_image_view_svg -> view_container.addView(getImageViewForSVG())
            VIEW_TYPE_EDIT_TEXT_FOCUS_FIXED -> view_container.addView(getEditTextFixFocus())
            // endregion
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

    private fun getCheckinWeekView(): View {
        return layoutInflater.inflate(R.layout.view_at_checkin_week_view_layout, null)
    }

    private fun getTextViewWithHighLightView(): View {
        return layoutInflater.inflate(R.layout.view_at_textview_highlight_layout, null)
    }

    private fun getMarqueeTextView(): View {
        return layoutInflater.inflate(R.layout.view_at_marquee_textview_layout, null)
    }

    private fun getImageViewForSVG(): View {
        return layoutInflater.inflate(R.layout.view_at_image_view_svg_layout, null)
    }

    private fun getEditTextFixFocus(): View {
        return layoutInflater.inflate(R.layout.view_at_fix_focus_edit_text_layout, null)
    }
}