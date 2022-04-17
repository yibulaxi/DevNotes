package cn.kk.customview.activity.arch.mvp.callback

/**
 * Http 请求回调抽象接口
 */
interface HttpCallback<T> {

    fun onStart()

    fun onSuccess(result: T)

    fun onError(msg: String)
}