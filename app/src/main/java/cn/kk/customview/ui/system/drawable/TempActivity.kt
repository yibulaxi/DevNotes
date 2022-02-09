package cn.kk.customview.ui.system.drawable

import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import cn.kk.base.activity.BaseActivity

class TempActivity : BaseActivity(), Toolbar.OnMenuItemClickListener {
    override fun getLayout(): Int {
        return 0
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()
        baseToolbar!!.setOnMenuItemClickListener(this)
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        return false
    }
}