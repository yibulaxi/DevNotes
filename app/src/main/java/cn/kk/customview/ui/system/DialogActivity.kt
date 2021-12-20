package cn.kk.customview.ui.system

import cn.kk.base.activity.BaseActivity
import cn.kk.base.dialog.CommentFragment
import cn.kk.base.dialog.CommentFragmentV2
import cn.kk.base.dialog.SimpleBottomDialog
import cn.kk.customview.R

class DialogActivity: BaseActivity() {
    override fun getLayout(): Int {
       return R.layout.activity_dialog
    }

    override fun getItemNameList(): MutableList<String> {
        return mutableListOf<String>().apply {
            add("DialogFragment")
            add("BottomSheetDialog")
            add("BottomSheetDialog with theme")
        }
    }

    override fun setListViewID(): Int {
        return R.id.rv_list
    }

    override fun initAdapter() {
        super.initAdapter()
        listAdapter.setOnItemClickListener { adapter, view, position ->
            when(position){
                0 ->  CommentFragment.showDialog(this)
                1 ->  SimpleBottomDialog(this).show()
                2 ->  SimpleBottomDialog(this, R.style.EdgeToEdgeDialogStyle).show()
            }
        }
    }

}