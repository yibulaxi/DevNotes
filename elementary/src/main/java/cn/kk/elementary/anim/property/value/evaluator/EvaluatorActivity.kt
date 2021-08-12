package cn.kk.elementary.anim.property.value.evaluator

import android.animation.TypeEvaluator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.Button
import cn.kk.base.activity.BaseActivity
import cn.kk.elementary.R
import kotlinx.android.synthetic.main.activity_evaluator.*

/**
 * 自定义 Evaluator
 */
class EvaluatorActivity: BaseActivity() {

    lateinit var btnPlay: Button

    override fun getLayout(): Int = R.layout.activity_evaluator

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()
        btnPlay = findViewById(R.id.btn_play)

        val anim = ValueAnimator.ofObject(LetterEvaluator(), 'A', 'Z').apply {
            duration = 5000
            interpolator = LinearInterpolator()
            addUpdateListener {
                tvLetter.text = animatedValue.toString()
            }
        }
        btnPlay.setOnClickListener {
            anim.start()
        }
    }

    /**
     * 字母 LetterEvaluator
     * 实际上是 ascii 码的字符
     */
    class LetterEvaluator: TypeEvaluator<Char>{
       override fun evaluate(fraction: Float, startValue: Char, endValue: Char): Char {
           val startValueInt = startValue.toInt()
           val endValueInt = endValue.toInt()
           val curChar = startValueInt + fraction * (endValueInt - startValueInt)
           return curChar.toChar()
       }

   }
}