package cn.kk.customview.activity.arch.mvp

import cn.kk.customview.activity.arch.mvp.model.LoginInfoModel

interface LoginContract {

    // 登录接口
    interface Presenter {

        fun login(name: String)
    }

    // 登录执行后，与页面交互的接口
    interface View: BaseView<Presenter> {

        fun showLoading()

        fun hideLoading()

        fun showError(msg: String)

        fun isActive(): Boolean

        fun setLoginInfo(loginInfoModel: LoginInfoModel)
    }
}