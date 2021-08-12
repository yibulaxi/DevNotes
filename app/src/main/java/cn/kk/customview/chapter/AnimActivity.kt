package cn.kk.customview.chapter

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import kotlinx.android.synthetic.main.activity_anim.*

class AnimActivity: BaseActivity() {

    override fun getLayout(): Int = R.layout.activity_anim

    override fun getItemNameList(): MutableList<String> {
        return mutableListOf("视图动画","属性动画","动画进阶")
    }
    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        rv_anim
    }

}