package cn.kk.customeview.widget

import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import cn.kk.customeview.R

class EditTextWithClear @JvmOverloads constructor(

    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatEditText(context, attrs, defStyleAttr) {
    private var iconDrawable: Drawable? = null;

    init {
        //使用自定义属性
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.EditTextWithClear,
            0,
            0
        ).apply {
            try {
                val iconId = getResourceId(R.styleable.EditTextWithClear_clearIcon,0)
                if (iconId != 0) {
                    iconDrawable = ContextCompat.getDrawable(context,iconId)
                }
            } finally {

            }
        }
    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
        //当内容变化了，就调用这个方法。　判断是否要显示/隐藏图标
        toggleClearIcon()
    }


    override fun onFocusChanged(focused: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect)
        toggleClearIcon()
    }

    private fun toggleClearIcon() {
        val icon = if (text?.isNotEmpty() == true && isFocused) iconDrawable else null;
        setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let { e ->
            iconDrawable?.let {
                if (e.action == MotionEvent.ACTION_UP
                    && e.x > width - it.intrinsicWidth - 10
                    && e.x < width
                    && e.y > height / 2 - it.intrinsicHeight / 2 - 10
                    && e.y < height / 2 + it.intrinsicHeight / 2 + 10
                ) {
                    text?.clear()
                }
            }
        }
        return super.onTouchEvent(event)
    }
}
