package cn.kk.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cn.kk.base.bean.ListItemAction

abstract class BaseFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(getLayoutId(), container, false)
    }

    abstract fun getLayoutId(): Int

    open fun getItemActionList(names: Array<String>): MutableList<ListItemAction> {
        val list = mutableListOf<ListItemAction>()
        for (name in names) {
            list.add(ListItemAction(name))
        }
        return list
    }
}