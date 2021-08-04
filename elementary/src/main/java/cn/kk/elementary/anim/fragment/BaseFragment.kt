package cn.kk.elementary.anim.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class BaseFragment(val animName: String): Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        animTitle(animName)
    }

   abstract fun animTitle(title: String)
}