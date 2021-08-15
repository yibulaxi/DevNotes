package cn.kk.elementary.anim.evaluator

import android.animation.TypeEvaluator
import android.graphics.Point
import cn.kk.base.LogHelper

/**
 * 球体做抛物线
 * 1. x 水平方向是匀速直线运动
 * 2. y 数值方向是自由落体运动
 */
class FallBallEvaluator: TypeEvaluator<Point> {
    val point = Point()
    override fun evaluate(fraction: Float, startValue: Point, endValue: Point): Point {
        point.x = (startValue.x + fraction * (endValue.x - startValue.x)).toInt()

        // y 计算较为复杂：s = 1/2 * g * t * t
        // 因此，简单的计算
        if (fraction < 0.5f){
            point.y = (startValue.y + fraction * 2 * (endValue.y - startValue.y)).toInt()
        } else {
            point.y = endValue.y
        }
        return point
    }
}