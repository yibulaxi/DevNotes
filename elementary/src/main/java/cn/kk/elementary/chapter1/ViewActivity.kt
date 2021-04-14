package cn.kk.elementary.chapter1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.kk.elementary.R

class ViewActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
    }
}