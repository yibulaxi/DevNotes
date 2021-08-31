package cn.kk.elementary.drawview.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import cn.kk.base.fragment.BaseFragment
import cn.kk.elementary.R
import kotlinx.android.synthetic.main.fragment_hardware_accelerate.*
import kotlinx.android.synthetic.main.fragment_hardware_accelerate.tv_content
import kotlinx.android.synthetic.main.fragment_paint_text.*

/**
 * Paint 文字
 */
class PaintTextFragment: BaseFragment() {
    override fun getLayoutId(): Int = R.layout.fragment_paint_text

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}