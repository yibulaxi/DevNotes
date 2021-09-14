package cn.kk.customview.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.LinearLayout
import cn.kk.base.UIHelper
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_system_ui.*
import kotlin.math.sign

class SystemUIActivity: BaseActivity() {
    val MIN_RADIO = 0.8f // 最小高宽比
    val MAX_RADIO = 1.2f // 最大高宽比

    val imgsId = arrayOf(R.drawable.bg_1, R.drawable.bg_2, R.drawable.bg_3, R.drawable.bg_portrait_1)
    var index = 0

    override fun getLayout(): Int = R.layout.activity_system_ui

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        btn_next.setOnClickListener {
//            val curDrawable = imgsId[(index++)  % imgsId.size]
//            imageView.setImageDrawable(resources.getDrawable(curDrawable, null))
            showImg(index++)
            if (index == imgsId.size) index = 0
        }
    }

    /**
     * 显示图片
     * 1. 图片宽度充满屏幕
     * 2. 高度若不够，则上下留白
     * 3. 高度若超过控件高度，则从顶部开始显示，下面的则不再显示了
     */
    fun showImg(index: Int){
        // 1. 获取图片尺寸
        val bitmap = BitmapFactory.decodeResource(resources, imgsId[(index % imgsId.size) ])
        val imageAspectRadio = bitmap.height * 1.0f / bitmap.width

        // 2. 计算把图片等比例缩放到宽度与控件宽度相同时，的尺寸

        // 3. 如果缩放后的高度超过控件高度，那么裁剪
        var finalBitmap = bitmap
        if (imageAspectRadio > MAX_RADIO) {
            // 计算裁剪部分大小
            val cropHeight = bitmap.width * MAX_RADIO
          finalBitmap =  Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, cropHeight.toInt())

            // 控件尺寸要调整
            (imageView.layoutParams as LinearLayout.LayoutParams).apply {
                height = (UIHelper.getScreenSize(this@SystemUIActivity).x * MAX_RADIO).toInt()
            }
        }

        // 4. 显示在控件上面
        imageView.setImageBitmap(finalBitmap)
    }
}