package cn.kk.customview.widget

import android.content.Context
import android.graphics.Color
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import cn.kk.customview.bean.Word
import cn.kk.customview.utils.ParseSentenceUtil
import java.util.*

private const val TAG = "InputView"
val TEXT_SZIE = 26f
val TEXT_COLOR = Color.parseColor("#BBCCBB")
const val STATE_NORMAL = 0
const val STATE_ERROR = 1
const val STATE_CORRECT = 2
const val STATE_HELP = 3

val COLOR_CORRECT = Color.parseColor("#8EC552")
val COLOR_ERROR = Color.parseColor("#D87380")
val COLOR_HELP = Color.parseColor("#C4F7C6")

class InputView(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {

    var inputViewWidth = 0
    var mVerticalSpacing = 0
        set(value) {
            field = value
        }
        get() {
            return field
        }
    var mHorizontalSpacing = 6
        set(value) {
            field = value
        }
        get() {
            return field
        }

    constructor(context: Context?) : this(context, null)

    var mOnSpellFinishListener: OnSpellFinishListener? = null
        set(value) {
            field = value
        }

    // 存放单词的 view 集合
    val wordViewList = mutableListOf<EditText>()

    // 存放单词的集合
    val wordList = mutableListOf<Word>()
    var currentWord: Word? = null
    var currentSpellState = STATE_NORMAL
    var mCurrentUserInput = ""
    var currentFocusEditText: EditText? = null
    var currentFocusKeyWordStr = "" // 当前焦点框的单词答案

    init {
        inputViewWidth = width
        setPadding(16, 10, 16, 0)
    }


    fun inflateSentence(sentence: String) {

        // 解析句子
        val childSentences = ParseSentenceUtil.parse(sentence)

        // 根据解析的句子，动态生成一组 view
        if (childSentences.isEmpty()) {
            return
        }

        wordList.clear()
        for (childSentence in childSentences) {
            Log.d(
                TAG,
                "inflateSentence: childSentence: ${if (childSentence.isWord()) childSentence.spellPart else childSentence.normalPart}"
            )

            if (childSentence.isWord()) {
                wordList.add(childSentence)
                createWordView(childSentence.spellPart!!)
            } else {
                createNormalView(childSentence.normalPart!!)
            }
        }

    }

    /**
     * 创建描述部分区域用的 view
     * 一个单词一个 TextView
     */
    private fun createNormalView(normal: String) {
        for (word in normal.split(" ")) {
            val tv = TextView(context)
            tv.height = dp2px(38)
            tv.textSize = 18f
            tv.text = word + " "
            tv.isClickable = false
            tv.gravity = Gravity.CENTER_VERTICAL

            addView(tv)
        }

    }


    /**
     * 创建 EditView 提供用户拼写单词
     */
    private fun createWordView(word: String) {

        wordViewList.clear()

        val et = EditText(context)
        et.height = dp2px(38)
        et.textSize = 15f
        et.minWidth = (et.paint.measureText("_") * 1.5f * word.length).toInt()
        // 限制最大宽度，不能超过父亲控件
        et.maxWidth = width
        et.gravity = Gravity.BOTTOM
        et.addTextChangedListener(mTextWatcher)
        et.setOnFocusChangeListener(mFocusChangeListener)
        et.setOnEditorActionListener(mOnEditorActionListener)

        et.tag = wordViewList.size
        addView(et)

        wordViewList.add(et)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val myWidth = View.resolveSize(0, widthMeasureSpec)

        val paddingLeft = paddingLeft
        val paddingTop = paddingTop
        val paddingRight = paddingRight
        val paddingBottom = paddingBottom

        var childLeft = paddingLeft
        var childTop = paddingTop

        var lineHeight = 0

        for (i in 0 until childCount) {
            var child = getChildAt(i)
            if (child.visibility != View.GONE) {
                measureChild(child, widthMeasureSpec, heightMeasureSpec)
            } else {
                continue
            }

            lineHeight = Math.max(child.measuredHeight, lineHeight)

            if (childLeft + child.measuredWidth + paddingRight > myWidth) {
                childLeft = paddingLeft
                childTop += mVerticalSpacing + lineHeight
                lineHeight = child.measuredHeight
            } else {
                childLeft += child.measuredWidth + mHorizontalSpacing
            }
        }


        val wantedHeight = childTop + lineHeight + paddingBottom

        setMeasuredDimension(
            myWidth,
            View.resolveSize(wantedHeight, heightMeasureSpec)
        )
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val myWidth = r - l

        val paddingLeft = paddingLeft
        val paddingTop = paddingTop
        val paddingRight = paddingRight

        var childLeft = paddingLeft
        var childTop = paddingTop

        var lineHeight = 0

        for (i in 0 until childCount) {
            val childView = getChildAt(i)

            if (childView.visibility == View.GONE) {
                continue
            }

            val childWidth = childView.measuredWidth
            val childHeight = childView.measuredHeight

            lineHeight = Math.max(childHeight, lineHeight)

            if (childLeft + childWidth + paddingRight > myWidth) {
                childLeft = paddingLeft
                childTop += mVerticalSpacing + lineHeight
                lineHeight = childHeight
            }

            childView.layout(childLeft, childTop, childLeft + childWidth, childTop + childHeight)
            childLeft += childWidth + mHorizontalSpacing
        }
    }

    fun dp2px(dpValue: Int): Int {
        return (dpValue * resources.displayMetrics.density).toInt()
    }

    /**
     * 拼写单词结果监听
     */
    interface OnSpellFinishListener {

        /**
         * 拼写成功
         */
        fun onSuccess()

        /**
         * 拼写错误
         */
        fun onError(errInput: String)

        /**
         * 拼写全部完成
         */
        fun onComplete(): Unit

    }

    val mTextWatcher: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable) {
            // 自动判断输入正确
            if (currentFocusKeyWordStr.length == s.length) {
                if (currentFocusKeyWordStr == s.toString()) {
                    showCorrect()
                }
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    }

    val mFocusChangeListener: OnFocusChangeListener = object : OnFocusChangeListener {
        override fun onFocusChange(v: View, hasFocus: Boolean) {
            val tag = v.getTag()
            if (hasFocus) {
                Log.d(TAG, "onFocusChange: tag=${tag}")
                currentFocusEditText = v as EditText
                currentWord = wordList.get(tag as Int)
                currentFocusKeyWordStr = wordList.get(tag as Int).spellPart!!
            } else {
                // 上一个失去焦点了, 不再提示了
                (v as EditText).setHint("")
            }
        }

    }

    /**
     * 区分切换下一题还是提交答案
     */
    var enableNext = false
    var lastActionTime = 0L
    val mOnEditorActionListener: TextView.OnEditorActionListener =
        object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                //有时候会存在回调两次的情况，直接过滤掉即可

                //有时候会存在回调两次的情况，直接过滤掉即可
                val time = Date().time
                if (time - lastActionTime < 200) {
                    return true
                }
                lastActionTime = time
                //华为输入法会出现EditorInfo.IME_ACTION_DONE 和 EditorInfo.IME_ACTION_NEXT两种情况
                if (actionId == EditorInfo.IME_ACTION_UNSPECIFIED
                    || actionId == EditorInfo.IME_ACTION_DONE
                    || actionId == EditorInfo.IME_ACTION_NEXT
                ) {


                    //用户按回车健，作答完毕.
                    // 不明白为什么这个地方是回车键
                    if (!enableNext) {
                        // 处理回车
                        // 1. 给外部发出监听


                        // 如果一个都没有输入并且不是处于提示状态，则认为是提示，否则认为是输入不正确，用户按下想要个结果
                        if (TextUtils.isEmpty(mCurrentUserInput)) {
                            showHelp()
                        } else {
                            if (currentSpellState != STATE_HELP) {
                                showError()
                            }
                        }
                    } else {
                        //
                    }
                }
                return true
            }

        }

    /**
     * 提示输入错误
     */
    private fun showError() {

    }

    /**
     * 提示当前填空的单词
     */
    fun showHelp() {
        currentFocusEditText?.apply {
            setHint(currentFocusKeyWordStr)
            setHintTextColor(Color.parseColor("#C4F7C6"))
        }
    }

    fun showCorrect() {
        // 输入正确了
        // 1. 显示正确的颜色
        currentFocusEditText?.setTextColor(COLOR_CORRECT)

        // 2. 更新该单词输入状态
        wordList.get(currentWord!!.wordIndex).spellSuccess = true

        // 3. 计算下一个单词位置
        val nextWordIndex = currentWord!!.wordIndex + 1

        // 4. 如果跳到头了，判断是否全部输入正确了
        if (nextWordIndex > wordList.size - 1) {
            // 判断所有单词是否都输入完成了
            var isComplete = true
            for (word in wordList) {
                if (!word.spellSuccess) {
                    isComplete = false
                    break
                }
            }

            if (isComplete) {
                mOnSpellFinishListener?.onComplete()
            }
            return
        }

        // 下一个单词的 view 获取焦点, 并更新当前单词 currentWord
        currentFocusEditText = wordViewList.get(nextWordIndex)
        currentFocusEditText?.requestFocus()
        currentWord = wordList.get(nextWordIndex)

    }
}