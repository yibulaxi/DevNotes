package cn.kk.base.dialog

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import cn.kk.base.R

class CommentFragment: DialogFragment() {

    companion object{
        fun showDialog(activity: AppCompatActivity): CommentFragment{
            val dialogFragment = CommentFragment()
            dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogTheme)
            dialogFragment.show(activity.supportFragmentManager, "CommendFragment")
            return dialogFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_comment, container)

        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE or WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(true)

        val etComment = view.findViewById<EditText>(R.id.et_comment)

        etComment?.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
        etComment?.requestFocus()
        return view

    }
}