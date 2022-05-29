package com.kk.opengl

import cn.kk.base.activity.BaseActivity
import com.kk.open_gl_lib.R
import kotlinx.android.synthetic.main.activity_open_gl.*

class OpenGLDemoActivity: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_open_gl
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        val nativeLib = NativeLib()

        tv_open_GL.text = nativeLib.stringFromJNI()
    }
}