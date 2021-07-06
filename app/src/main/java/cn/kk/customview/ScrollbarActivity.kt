package cn.kk.customview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_scrollbar.*

class ScrollbarActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrollbar)

        btn_get_level.setOnClickListener {
            vocab.startLevel

            Toast.makeText(this@ScrollbarActivity,
                vocab.startLevel.toString().plus(" ~ ").plus(vocab.endLevel.toString()),
                Toast.LENGTH_SHORT).show()
        }
    }
}