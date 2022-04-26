package cn.kk.customview.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import cn.kk.base.fragment.BaseFragment
import cn.kk.customview.R

 open class NormalViewFragment: BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_normal_view
    }

     private val childView: View by lazy {
         getMyView()
     }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<FrameLayout>(R.id.rootView).addView(childView)
    }

    protected open fun getMyView(): View {
        return View(context)
    }

     /**
      * 获取实际的 view 填充到跟布局中
      */
    protected open fun getAddViewByInflate(layoutId: Int): View {
        return layoutInflater.inflate(layoutId, null)
     }
}