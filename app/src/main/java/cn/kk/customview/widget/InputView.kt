package cn.kk.customview.widget

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.text.*
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import cn.kk.customview.R
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
val COLOR_NORMAL = Color.parseColor("#232323")

val DEFAULT_HORIZONTAL_SPACING = 5
val DEFAULT_VERTICAL_SPACING = 5
val DEFAULT_WORD_SPACE_MAX_WIDTH_TIMES = 2 // 挖空单词填空的最大宽度相对于最小宽度的倍数

class InputView(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {

    var inputViewWidth = 0
    var mVerticalSpacing = DEFAULT_VERTICAL_SPACING
        set(value) {
            field = value
        }
        get() {
            return field
        }

    // 水平方向两个子 view 之间的间隔
    var mHorizontalSpacing = DEFAULT_HORIZONTAL_SPACING
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
    var mCurrentFocusKeyWordAnswer = "" // 当前焦点框的单词答案
    var lastErrorTip: String = ""
    lateinit var alertView: TextView

    init {
        inputViewWidth = width
        alertView = TextView(context).apply {

        }
        // 设置水平方向的 padding 会导致最后几个 view 显示不出来，不知道为什么，因此先不设置 padding
//        setPadding(16, 10, 16, 0)
    }


    /**
     * 填充句子
     */
    fun inflateSentence(sentence: String) {

        // 解析句子
        val childSentences = ParseSentenceUtil.parse(sentence)

        // 根据解析的句子，动态生成一组 view
        if (childSentences.isEmpty()) {
            return
        }

        wordList.clear()
        wordViewList.clear()
        /*for (i in 0 until 5) {
            Log.d(TAG, "inflateSentence: 模拟添加：${i}")
            createNormalView("one two three four five six seven eight nine ten.")
        }*/
        for (childSentence in childSentences) {


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
        Log.d(TAG, "createNormalView: normal: ${normal} =>")
        val elementWord = normal.split(" ")
        for (i in elementWord.indices) {
            val tv = TextView(context)
            tv.height = dp2px(38)
            tv.textSize = 18f
            if (i != elementWord.size - 1) {
                tv.text = elementWord[i].plus(" ")
            } else {
                tv.text = elementWord[i]
            }
            tv.isClickable = false
            tv.gravity = Gravity.CENTER_VERTICAL

            addView(tv)
        }

    }


    /**
     * 创建 EditView 提供用户拼写单词
     */
    private fun createWordView(word: String) {
        Log.d(TAG, "createWordView: word: ${word}")

        val et = EditText(context)
        et.height = dp2px(38)
        et.textSize = 18f

        // 限制最大和最小宽度(最小宽度就是单词的长度)
        et.minWidth = (et.paint.measureText(word)).toInt()
        et.maxWidth = et.minWidth * DEFAULT_WORD_SPACE_MAX_WIDTH_TIMES
        et.gravity = Gravity.BOTTOM
        et.addTextChangedListener(mTextWatcher)
        et.onFocusChangeListener = mFocusChangeListener
        et.setOnEditorActionListener(mOnEditorActionListener)

        // 给单词所在的 EditText 加上 tag，tag 是在 wordViewList 中的索引
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
        var lineCount = 1

        for (i in 0 until childCount) {
            val child = getChildAt(i)
            if (child.visibility != View.GONE) {
                measureChild(child, widthMeasureSpec, heightMeasureSpec)

            } else {
                continue
            }

            val childWidth = child.measuredWidth
            val childHeight = child.measuredHeight

            // 计算出本行最高的 child view 高度
            lineHeight = Math.max(childHeight, lineHeight)

            if (childLeft + childWidth + paddingRight > myWidth) {
                // 换行
                childLeft = paddingLeft
                childTop += mVerticalSpacing + lineHeight
                lineHeight = childHeight

                lineCount++

                Log.d(TAG, "onMeasure: 换行: ${lineCount}")
            } else {
                childLeft += childWidth + mHorizontalSpacing
                Log.d(TAG, "onMeasure: childLeft: $childLeft")
            }
        }


        val wantedHeight = childTop + lineHeight + paddingBottom

        setMeasuredDimension(
            myWidth,
            View.resolveSize(wantedHeight, heightMeasureSpec)
        )

        Log.d(TAG, "onMeasure: lineCount: ${lineCount}")
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
        fun onComplete()

    }

    val mTextWatcher: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable) {

            mCurrentUserInput = s.toString()
            // 自动判断输入正确
            if (mCurrentFocusKeyWordAnswer.length == s.length) {
                if (mCurrentFocusKeyWordAnswer == s.toString()) {
                    if (isNormal()) {
                        showCorrect()
                    }
                }
            } else if (TextUtils.isEmpty(s.toString())) {
                cancelShowHelp()
            }
        }


        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            if (isError()) {
                if (mCurrentFocusKeyWordAnswer.equals(s.toString())) {
                    lastErrorTip = s.toString()
                    Log.d(TAG, "beforeTextChanged: 输错了，重试=> s: ${lastErrorTip}")

                }
            }
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (isError()) {
                if (mCurrentFocusKeyWordAnswer.equals(lastErrorTip)) {
                    // 输错了后，第一次输入内容
                    val inputAfterLastError = s?.subSequence(start, start + count)
                    Log.d(TAG, "onTextChanged: inputAfterLastError: ${inputAfterLastError}")
                    resetState()
                    currentFocusEditText?.setText(SpannableStringBuilder(inputAfterLastError))
                    currentFocusEditText?.setText(inputAfterLastError)
                    currentFocusEditText?.setSelection(inputAfterLastError!!.length)
                }
            }

        }

    }

    val mFocusChangeListener: OnFocusChangeListener = object : OnFocusChangeListener {
        override fun onFocusChange(v: View, hasFocus: Boolean) {
            val tag = v.getTag()
            if (hasFocus) {
                Log.d(TAG, "onFocusChange: tag=${tag}")
                currentFocusEditText = v as EditText
                currentWord = wordList.get(tag as Int)
                mCurrentFocusKeyWordAnswer = wordList.get(tag as Int).spellPart!!
                resetState()
            } else {
                // 上一个失去焦点了, 不再提示了
                (v as EditText).hint = ""
                if (isError()) {
                    // 如果上一个输入错了，又失去焦点了，那么清空
                    v.setText("")
                    resetState()
                }
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
                            showError(currentFocusEditText?.text.toString().trim().toLowerCase())
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
     * 1. 先检查
     * 2. 提示错误
     * 3. 弹出框，提示输入的错误答案
     */
    private fun showError(inputWord: String) {
        Log.d(TAG, "showError: 检查错误")
        currentSpellState = STATE_ERROR
        // 1. 检查
        val checkResult = IntArray(mCurrentFocusKeyWordAnswer.length)
        // 计算比对次数，比对次数最多为答案的长度
        val maxLoop = Math.min(mCurrentUserInput.length, mCurrentFocusKeyWordAnswer.length)
        var index = 0

        val inputChars = mCurrentUserInput.toCharArray()
        val answerChars = mCurrentFocusKeyWordAnswer.toCharArray()
        while (true) {
            if (inputChars[index] == answerChars[index]) {
                // 如果相等，则标记为 1，否则为 0
                checkResult[index] = 1
            }
            index++
            if (index >= maxLoop) break
        }

        // 2. 提示错误
        val ssb = SpannableStringBuilder(mCurrentFocusKeyWordAnswer)
        for (index in checkResult.indices) {

            // 正确
            if (checkResult[index] == 1) {
                ssb.setSpan(
                    ForegroundColorSpan(COLOR_CORRECT),
                    index,
                    index + 1,
                    Spannable.SPAN_INCLUSIVE_EXCLUSIVE
                )
            } else {
                ssb.setSpan(
                    ForegroundColorSpan(COLOR_ERROR),
                    index,
                    index + 1,
                    Spannable.SPAN_INCLUSIVE_EXCLUSIVE
                )
            }
        }

        currentFocusEditText?.text = ssb

        var alertMsg = ""
        if (inputWord.length > mCurrentFocusKeyWordAnswer.length) {
            alertMsg =
                inputWord.substring(0, mCurrentFocusKeyWordAnswer.length - 1).plus("...")
        } else {
            alertMsg = inputWord
        }

        // 3. 弹出框，提示输入的错误答案
        // 计算出 当前输入框的中间点坐标
        // 得到光标点所在的挖空部分的下划线区域中间的坐标（相对于本 EditText，该区域认为是单词的长度，而不是实际填写错误的单词长度）
        val posX: Float = currentFocusEditText!!.x + currentFocusEditText!!.width / 2
        val posY: Float = currentFocusEditText!!.y + currentFocusEditText!!.height


        ((context as Activity).window.decorView as ViewGroup).addView(alertView.apply {
            val alertMsg = "你的答案：${alertMsg}"
            setText(alertMsg)
            val alertViewStartX = posX - paint.textSize * text.length / 2
            setX(alertViewStartX)
            setY(posY + currentFocusEditText!!.height - 20) // 不知道为什么高度不够，所以再加一次
            background = ContextCompat.getDrawable(context!!, R.drawable.ic_alert_word)
            gravity = Gravity.CENTER
            val myLayoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            )
            val targetWidth = (paint.textSize * text.length).toInt()
            Log.d(TAG, "onError: targetWidth= ${targetWidth}")
            myLayoutParams.height = (lineHeight * 2)

            myLayoutParams.width = targetWidth
            maxLines = 1

            layoutParams = myLayoutParams

        })

    }

    /**
     * 提示当前填空的单词
     */
    fun showHelp() {
        currentFocusEditText?.apply {
            setHint(mCurrentFocusKeyWordAnswer)
            setHintTextColor(COLOR_HELP)
        }
    }

    fun cancelShowHelp() {
        currentFocusEditText?.apply {
            setHint("")
        }
    }

    fun showCorrect() {
        // 输入正确了
        // 1. 显示正确的颜色
        currentFocusEditText?.setTextColor(COLOR_CORRECT)
//        currentFocusEditText?.setText(mCurrentFocusKeyWordAnswer)

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

    fun isError(): Boolean {
        return currentSpellState == STATE_ERROR
    }

    fun isNormal(): Boolean {
        return currentSpellState == STATE_NORMAL
    }

    fun resetState() {
        if (isError()) {
            removeAlertView()
        }
        currentSpellState = STATE_NORMAL
        currentFocusEditText?.setTextColor(COLOR_NORMAL)
        lastErrorTip = ""
        mCurrentUserInput = currentFocusEditText?.text.toString()
    }

    fun removeAlertView(){
        ((context as Activity).window.decorView as ViewGroup).removeView(alertView)
    }
}