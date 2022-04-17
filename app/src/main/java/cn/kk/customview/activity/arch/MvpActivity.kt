package cn.kk.customview.activity.arch

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import cn.kk.customview.activity.arch.mvp.LoginFragment
import cn.kk.customview.activity.arch.mvp.LoginPresenter
import cn.kk.customview.activity.arch.mvp.io.LoginNetTask

class MvpActivity: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_mvp
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        val fragment = LoginFragment()
        fragment.setPresenter(LoginPresenter(LoginNetTask(), fragment))

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit()
    }
}