package cn.kk.customview.activity.arch.mvp

interface BaseView <T> {

    fun setPresenter(presenter: T)
}