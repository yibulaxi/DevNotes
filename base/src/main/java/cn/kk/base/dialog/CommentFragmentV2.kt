package cn.kk.base.dialog

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import cn.kk.base.R

class CommentFragmentV2: DialogFragment() {

    companion object{
        fun showDialog(activity: AppCompatActivity): CommentFragmentV2{
            val dialogFragment = CommentFragmentV2()
            dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogTheme2)
            dialogFragment.show(activity.supportFragmentManager, "CommendFragment")
            return dialogFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_simple_bottom, container)

//        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE or WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
//        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(true)

        return view

    }
}