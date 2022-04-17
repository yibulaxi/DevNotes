package cn.kk.customview.activity.arch.mvp

import cn.kk.customview.activity.arch.mvp.callback.HttpCallback

interface NetRequestTask <T, K> {

    fun execute(data: T, callback: HttpCallback<K>)
}