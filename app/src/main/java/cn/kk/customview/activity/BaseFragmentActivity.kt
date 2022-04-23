package cn.kk.customview.activity

import androidx.fragment.app.Fragment
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R

abstract class BaseFragmentActivity: BaseActivity() {
    override fun getLayout() = R.layout.activity_base_fragment

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, getFragment()).commit()
    }

    abstract fun getFragment(): Fragment
}