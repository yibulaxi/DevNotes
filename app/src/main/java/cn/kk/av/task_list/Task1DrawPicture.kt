package cn.kk.av.task_list

import android.graphics.BitmapFactory
import android.graphics.Paint
import android.view.SurfaceHolder
import android.view.View
import cn.kk.base.UIHelper
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_draw_picture.*

/**
 * 自定义 view 绘制 bitmap
 * SurfaceView 绘制 bitmap
 */
class Task1DrawPicture: BaseActivity() {

    override fun getLayout(): Int = R.layout.activity_draw_picture

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        val paint = Paint()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.cat)
        surface_view.holder.addCallback(object : SurfaceHolder.Callback{

            override fun surfaceCreated(holder: SurfaceHolder) {
                val canvas = holder.lockCanvas()
                canvas.drawBitmap(bitmap, UIHelper.dp2px(50f), UIHelper.dp2px(50f), paint)
                holder.unlockCanvasAndPost(canvas)
            }

            override fun surfaceChanged(
                holder: SurfaceHolder,
                format: Int,
                width: Int,
                height: Int
            ) {

            }

            override fun surfaceDestroyed(holder: SurfaceHolder) {
            }

        })

        btn_show_mode.setOnClickListener {
            if (surface_view.visibility == View.GONE) {
                surface_view.visibility = View.VISIBLE
                picture_view.visibility = View.GONE

                btn_show_mode.text = "SurfaceView 绘制"
            } else {
                surface_view.visibility = View.GONE
                picture_view.visibility = View.VISIBLE
                btn_show_mode.text = "自定义 view 绘制"
            }
        }
    }
}