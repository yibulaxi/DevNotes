package cn.kk.elementary.drawview.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.base.adapter.ListAdapter
import cn.kk.base.fragment.BaseFragment
import cn.kk.elementary.R
import kotlinx.android.synthetic.main.fragment_hardware_accelerate.*
import kotlinx.android.synthetic.main.fragment_hardware_accelerate.tv_content
import kotlinx.android.synthetic.main.fragment_paint_funs.*

/**
 * Paint 常用函数
 */
class PaintFunsFragment: BaseFragment() {

    val funsArray: MutableList<String> by lazy {
        resources.getStringArray(R.array.paint_common_funs).toMutableList()
    }
    override fun getLayoutId(): Int = R.layout.fragment_paint_funs

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_funs.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_funs.adapter = ListAdapter(funsArray)
    }
}