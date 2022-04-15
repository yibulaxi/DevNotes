package cn.kk.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cn.kk.base.UIHelper
import cn.kk.base.bean.ListItemAction

abstract class BaseFragment: Fragment() {

    val TAG = this.javaClass.simpleName
    protected lateinit var rootView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(getLayoutId(), container, false)
        return rootView
    }

    abstract fun getLayoutId(): Int

    open fun getItemActionList(names: Array<String>): MutableList<ListItemAction> {
        val list = mutableListOf<ListItemAction>()
        for (name in names) {
            list.add(ListItemAction(name))
        }
        return list
    }

    protected fun showToast(msg: String){
        if (context == null) return
        UIHelper.toast(msg, context!!)
    }
}