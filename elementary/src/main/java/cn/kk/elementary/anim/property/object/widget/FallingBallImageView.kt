package cn.kk.elementary.anim.property.`object`.widget

import android.content.Context
import android.graphics.Point
import android.util.AttributeSet
import android.widget.ImageView

class FallingBallImageView(context: Context, attributes: AttributeSet) : ImageView(context, attributes) {


    fun setFallingPos(pos: Point){
        layout(pos.x, pos.y, pos.x + width, pos.y + height)
    }
}