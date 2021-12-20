package cn.kk.base.dialog

import android.app.Activity
import cn.kk.base.dialog.BaseBottomDialog

class MyDialog(context: Activity, theme: Int) : BaseBottomDialog(context, theme) {
    constructor(contex: Activity) : this(contex, 0) {}
}