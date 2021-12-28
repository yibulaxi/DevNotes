package cn.kk.customview.ui.cool300.chapter1

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import cn.kk.base.UIHelper
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.simple_009.*
import kotlinx.android.synthetic.main.simple_010.*

/**
 * 使用 ShapeDrawable 创建渐变圆角按钮
 */
class Simple_010: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.simple_010
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // 四个角为圆角
        val shapeDrawable = ShapeDrawable(RoundRectShape(floatArrayOf(100f,100f,100f,100f,100f,100f,100f,100f), null, null))

        // 背景线性渐变
        val btnWidth = btn_1.width
        val linearGradient = LinearGradient(0f, 0f, btnWidth.toFloat(), 0f, Color.RED, Color.GREEN, Shader.TileMode.MIRROR)
        shapeDrawable.paint.setShader(linearGradient)


        btn_1.setOnClickListener { btn_1.background = shapeDrawable }
        btn_2.setOnClickListener { btn_2.background = shapeDrawable }
        btn_3.setOnClickListener { btn_3.background = shapeDrawable }
    }
}