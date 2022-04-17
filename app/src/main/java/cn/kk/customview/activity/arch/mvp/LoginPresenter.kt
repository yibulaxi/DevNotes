package cn.kk.customview.activity.arch.mvp

import cn.kk.customview.activity.arch.mvp.callback.HttpCallback
import cn.kk.customview.activity.arch.mvp.model.LoginInfoModel

/**
 * 登录具体执行者
 */
class LoginPresenter(val loginTask: NetRequestTask<String, LoginInfoModel>, val view: LoginContract.View): LoginContract.Presenter {

    override fun login(name: String) {

        loginTask.execute(name, object : HttpCallback<LoginInfoModel> {
            override fun onStart() {
                view.showLoading()
            }

            override fun onSuccess(result: LoginInfoModel) {
                view.hideLoading()
                view.setLoginInfo(result)
            }

            override fun onError(msg: String) {
                view.hideLoading()
                view.showError(msg)
            }

        })
    }
}