package cn.kk.customview

import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_anim.*

class AnimActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim)

       btnRight.setOnClickListener {
           playRight()
       }

        btnLeft.setOnClickListener {
            playLeft()
        }


    }

    fun playRight(){
        val trans = resources.getDrawable(R.drawable.trans_1_2) as TransitionDrawable
        iv_anim.setImageDrawable(trans)
        trans.isCrossFadeEnabled = true
        trans.startTransition(800)
    }
    fun playLeft(){
        val trans = resources.getDrawable(R.drawable.trans_2_1) as TransitionDrawable
        iv_anim.setImageDrawable(trans)
        trans.isCrossFadeEnabled = true
        trans.startTransition(800)
    }
}