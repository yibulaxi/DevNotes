package cn.kk.customview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cn.kk.customview.utils.MyData
import cn.kk.customview.widget.WordInputViewNew
import kotlinx.android.synthetic.main.activity_word.*

val SENTENCES =
    "Android is a mobile operating system based on a modified version of the Linux kernel and other open source software, designed primarily for touchscreen mobile devices such as smartphones and tablets."

class WordActivity : AppCompatActivity(), WordInputViewNew.OnSpellFinishListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)

        inputView.inflateSentence(MyData.SENTENCES)
        inputView.mOnSpellFinishListener = this

    }

    override fun onSuccess() {

    }

    override fun onError(errInput: String) {
    }

    override fun onComplete() {
        showToast("全部完成!")
    }

    fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }

}