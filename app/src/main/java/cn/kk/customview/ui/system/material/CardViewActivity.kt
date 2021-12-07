package cn.kk.customview.ui.system.material

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R

/**
 * CardView 使用
 *  app:cardCornerRadius="4dp": 圆角半径
 *  app:cardElevation="20dp": 阴影半径
 *  app:cardBackgroundColor="@color/Orange": 背景色
 *
 */
class CardViewActivity: BaseActivity() {

    override fun getLayout(): Int {
        return R.layout.activity_card_view
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()


    }
}