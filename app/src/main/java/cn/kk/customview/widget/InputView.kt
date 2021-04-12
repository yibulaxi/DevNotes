package cn.kk.customview.widget

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.text.*
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import android.util.Log
import android.view.*
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import cn.kk.customview.R
import cn.kk.customview.utils.ValueUtil
import java.util.*

private const val TAG = "InputView"
// 要隐藏（默写）的单词标签前半部分
val PRE_WORD_KEY_STR = "<span class=\"key\">"

// 要隐藏（默写）的单词标签后半部分
val SUFFIX_WORD_KEY_STR = "</span>"

val CHILD_VIEW_HEIGHT = ValueUtil.dp2pxInt(35f)
val TEXT_SZIE_OF_NORMAL_WORD = 24f
val TEXT_SZIE_OF_SPACE_WORD = 24f
const val STATE_NORMAL = 0
const val STATE_ERROR = 1
const val STATE_CORRECT = 2
const val STATE_HELP = 3

val WORD_SPACE_PADDING_BOTTOM = ValueUtil.dp2pxInt(1f)
val WORD_NORMAL_PADDING_BOTTOM = ValueUtil.dp2pxInt(1f)

val WORD_SPACE_UNDER_LINE_THIN = ValueUtil.dp2px(1f)

// （拼写正确和拼写错误的颜色透明度都为 0.6, 转化成十六进制：99），且和要获取当前主题下面对应的颜色

val COLOR_CORRECT = Color.parseColor("#9991DC60")
val COLOR_ERROR = Color.parseColor("#99FF897F")
val COLOR_HELP = COLOR_CORRECT

// 这个是跟着主题颜色的，集成到项目里面就在初始化的时候获取主题对应的字体颜色
val COLOR_NORMAL = Color.parseColor("#232323")
val COLOR_SHOW_WORD = Color.parseColor("#987654")
val COLOR_SPACE_WORD = Color.parseColor("#456789")
val COLOR_SPACE_WORD_UNDER_LINE = COLOR_NORMAL
val TEXT_COLOR = COLOR_NORMAL

val DEFAULT_HORIZONTAL_SPACING = 5
val DEFAULT_VERTICAL_SPACING = 5
val DEFAULT_WORD_SPACE_MAX_WIDTH_TIMES = 2 // 挖空单词填空的最大宽度相对于最小宽度的倍数

/**
 * 1. 某个单词输入错误后，重新输入时，首字母是红色的，应显示为黑色（ok）
 * 2. 输入框中字母的高度和普通文本的高度没对齐（ok）
 * 3. 「你的答案」提示框的样式、提示框在边缘时的位置需要和 UI 联调下
 * 4. 单词拼写后，答对答错的提示颜色需要确认是否和 iOS 统一
 */

class InputView(context: Context?, attributeSet: AttributeSet?) : ViewGroup(context, attributeSet) {

    var inputViewWidth = 0
    var mVerticalSpacing = DEFAULT_VERTICAL_SPACING // 行间距
        set(value) {
            field = value
        }
        get() {
            return field
        }

    // 水平方向两个子 view 之间的间距
    var mHorizontalSpacing = DEFAULT_HORIZONTAL_SPACING
        set(value) {
            field = value
        }
        get() {
            return field
        }

    val wordUnderLinePaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)


    var mOnSpellFinishListener: OnSpellFinishListener? = null
        set(value) {
            field = value
        }

    val inputView: InputView

    // 存放单词的 view 集合
    val wordViewList = mutableListOf<EditText>()

    // 存放单词的集合
    val wordList = mutableListOf<InputView.Word>()
    var currentWord: Word? = null
    var currentSpellState = STATE_NORMAL
    var mCurrentUserInput = ""
    var currentFocusEditText: EditText? = null
    var mCurrentFocusKeyWordAnswer = "" // 当前焦点框的单词答案
    var lastErrorTip: String = ""
    var alertView: TextView
    var inputmethodmanager: InputMethodManager? = null

    init {
        inputView = this
        inputViewWidth = width
        alertView = TextView(context).apply {
            setBackgroundColor(Color.WHITE)
            elevation = ValueUtil.dp2px(4f)
        }
        wordUnderLinePaint.setColor(COLOR_SPACE_WORD_UNDER_LINE)
        wordUnderLinePaint.strokeWidth = WORD_SPACE_UNDER_LINE_THIN
        // 设置水平方向的 padding 会导致最后几个 view 显示不出来，不知道为什么，因此先不设置 padding
//        setPadding(16, 10, 16, 0)

        // ViewGroup 默认不会调用 onDraw() 所以，调用这个方法，让其调用 onDraw()
        setWillNotDraw(false)

        inputmethodmanager =
            context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    }


    /**
     * 填充句子
     */
    fun inflateSentence(sentence: String) {

        // 解析句子
        val childSentences = parse(sentence)

        // 根据解析的句子，动态生成一组 view
        if (childSentences.isEmpty()) {
            return
        }

        wordList.clear()
        wordViewList.clear()

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
            tv.height = CHILD_VIEW_HEIGHT
            tv.textSize = TEXT_SZIE_OF_NORMAL_WORD
            tv.setTextColor(TEXT_COLOR)
            if (i != elementWord.size - 1) {
                tv.text = elementWord[i].plus(" ")
            } else {
                tv.text = elementWord[i]
            }
            tv.isClickable = false
            tv.gravity = Gravity.BOTTOM

            tv.setPadding(0, 0, 0, WORD_NORMAL_PADDING_BOTTOM)

            addView(tv)
        }

    }


    /**
     * 创建 EditView 提供用户拼写单词
     */
    private fun createWordView(word: String) {
        Log.d(TAG, "createWordView: word: ${word}")

        val et = EditText(context)
        et.height = CHILD_VIEW_HEIGHT
        et.textSize = TEXT_SZIE_OF_SPACE_WORD
        et.setTextColor(TEXT_COLOR)

        // 限制最大和最小宽度(最小宽度就是单词的长度)
        et.minWidth = (et.paint.measureText(word)).toInt()
        et.maxWidth = et.minWidth * DEFAULT_WORD_SPACE_MAX_WIDTH_TIMES
        et.gravity = Gravity.BOTTOM
        et.addTextChangedListener(mTextWatcher)
        et.onFocusChangeListener = mFocusChangeListener
        et.maxLines = 1
        et.setSingleLine()
        et.setOnEditorActionListener(mOnEditorActionListener)
        et.background = null // 不使用系统自带的下划线
        et.setPadding(0, 0, 0, WORD_SPACE_PADDING_BOTTOM) // 设置字体 padding bottom，如果不设置，默认会很大

        // 给单词所在的 EditText 加上 tag，tag 是在 wordViewList 中的索引
        et.tag = wordViewList.size

        addView(et)

        wordViewList.add(et)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val myWidth = View.resolveSize(0, widthMeasureSpec)

        MeasureSpec.UNSPECIFIED
        val paddingLeft = paddingLeft
        val paddingTop = paddingTop
        val paddingRight = paddingRight
        val paddingBottom = paddingBottom

        var containerWidth = paddingLeft // 父容器宽
        var containerHeight = paddingTop // 父容器高

        var lineHeight = 0  // 记录每一行高度
        var lineWidth = 0  // 记录每一行宽度

        var lineCount = 1

        for (i in 0 until childCount) {
            val child = getChildAt(i)
            if (child.visibility != View.GONE) {
                // 测量 子view
                measureChild(child, widthMeasureSpec, heightMeasureSpec)

            } else {
                continue
            }

            val childWidth = child.measuredWidth
            val childHeight = child.measuredHeight

            // 计算出本行最高的 child view 高度
            lineHeight = Math.max(childHeight, lineHeight)

            if (lineWidth + childWidth + paddingRight > myWidth) {
                // 换行
                containerWidth = Math.max(lineWidth, childWidth + paddingLeft)
                containerHeight += mVerticalSpacing + lineHeight
                lineHeight = childHeight
                lineWidth = paddingLeft + childWidth

                lineCount++

                Log.d(TAG, "onMeasure: 换行: ${lineCount}")
            } else {
//                containerWidth += childWidth + mHorizontalSpacing
                lineWidth += childWidth + mHorizontalSpacing
                lineHeight = Math.max(lineHeight, childHeight)
                Log.d(TAG, "onMeasure: childLeft: $containerWidth")
            }

            // 单独处理最后一行
            if (i == childCount - 1) {
                containerHeight += mVerticalSpacing + lineHeight
                containerWidth = Math.max(containerWidth, lineWidth)
            }
        }


        val wantedHeight = containerHeight + lineHeight + paddingBottom

        // 测量完成后，设置给系统
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

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (i in 0 until childCount) {
            if (getChildAt(i) is EditText) {
                val curEditText = getChildAt(i) as EditText
                canvas.drawLine(
                    curEditText.left.toFloat(), curEditText.bottom.toFloat(),
                    curEditText.right.toFloat(), curEditText.bottom.toFloat(), wordUnderLinePaint
                )

                // 查看 padding bottom
                Log.d(TAG, "onDraw: padding bottom: ${curEditText.paddingBottom}")
            }
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
            if (!TextUtils.isEmpty(mCurrentFocusKeyWordAnswer) && mCurrentFocusKeyWordAnswer.length == s.length) {
                if (mCurrentFocusKeyWordAnswer.toLowerCase() == s.toString().toLowerCase()) {
                    // 比较时，忽略大小写
                    if (isNormal()) {
                        showCorrect()
                    }
                }
            } else if (TextUtils.isEmpty(s.toString())) {
                cancelShowHelp()
            } else {

            }
        }


        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            if (isError()) {
                if (mCurrentFocusKeyWordAnswer.equals(currentFocusEditText?.hint.toString())) {
                    lastErrorTip = s.toString()
                    Log.d(TAG, "beforeTextChanged: 输错了，重试=> s: ${lastErrorTip}")
                    resetState()
                }
            }
        }


        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            /*if (isError()) {
                Log.d(TAG, "onTextChanged: isError!")
                if (mCurrentFocusKeyWordAnswer.equals(lastErrorTip)) {
                    // 输错了后，第一次输入内容
                    val inputAfterLastError = s?.subSequence(start, start + count)
                    Log.d(TAG, "onTextChanged: inputAfterLastError: ${inputAfterLastError}")

                    if (TextUtils.isEmpty(inputAfterLastError)) { // 输入错误后，第二次输入，但是没有输入完，切换到其他挖空部分，这个值会是空，所以进行判断
                        return
                    }

                    resetState()
                    // 使得，错误之后第一个输入的字符为正常颜色：COLOR_NORMAL
                    currentFocusEditText?.text = SpannableStringBuilder(inputAfterLastError).apply {
                        setSpan(
                            ForegroundColorSpan(COLOR_NORMAL),
                            0,
                            1,
                            Spannable.SPAN_INCLUSIVE_EXCLUSIVE
                        )
                    }

                    currentFocusEditText?.setSelection(inputAfterLastError!!.length)
                }
            }*/

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
                mCurrentUserInput = currentFocusEditText?.text.toString()
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
        if (isError()) {
            return
        }
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

        currentFocusEditText?.setText("")
        currentFocusEditText?.hint = ssb

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
        postDelayed(object : Runnable {
            override fun run() {
                showAlertView(alertMsg)
            }
        }, 16) // 方式 EditText 跳回到原来位置，而 alertView 直接出现在跳转前的位置

    }

    /**
     * 展示答案提示框
     */
    private fun showAlertView(alertMsg: String) {
        val posX: Float = currentFocusEditText!!.x + currentFocusEditText!!.minWidth / 2
        val posY: Float = currentFocusEditText!!.y + currentFocusEditText!!.height


        ((context as Activity).window.decorView as ViewGroup).addView(alertView.apply {
            val pre_str = "你的答案："
            val alertMsg = "$pre_str${alertMsg}"
            text = SpannableStringBuilder(alertMsg).apply {

                setSpan(
                    ForegroundColorSpan(COLOR_ERROR),
                    pre_str.length,
                    alertMsg.length,
                    Spannable.SPAN_INCLUSIVE_EXCLUSIVE
                )
            }
            val paddingLeft = ValueUtil.dp2px(5f).toInt()
            val paddingRight = ValueUtil.dp2px(5f).toInt()
            val paddingBottom = ValueUtil.dp2px(5f).toInt()
            setPadding(paddingLeft, 0, paddingRight, 0)
            val targetWidth = this.paint.measureText(alertMsg) + paddingLeft + paddingRight
            Log.d(TAG, "onError: targetWidth= ${targetWidth}")

            var alertViewStartX = posX - targetWidth / 2
            // 限制起点坐标左边界
            alertViewStartX = Math.max(0f, alertViewStartX)

            //限制起点坐标右边界: alertViewStartX + targetWidth <= inputView width
            alertViewStartX = Math.min(alertViewStartX, this@InputView.right.toFloat())

            setX(alertViewStartX)
            setY(posY + currentFocusEditText!!.height + ValueUtil.dp2px(10f)) // 不知道为什么高度不够，所以再加一次
//            setBackgroundResource(R.drawable.ic_alert_word_error)
            setBackgroundResource(R.drawable.rectange_corner)
            gravity = Gravity.CENTER_VERTICAL

            val myLayoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            )

            myLayoutParams.height = (lineHeight * 2)

            myLayoutParams.width = targetWidth.toInt()
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
        currentSpellState = STATE_CORRECT
        currentFocusEditText?.setText(mCurrentFocusKeyWordAnswer)
        currentFocusEditText?.setTextColor(COLOR_CORRECT)
//        currentFocusEditText?.hint = mCurrentFocusKeyWordAnswer
//        currentFocusEditText?.setHintTextColor(COLOR_CORRECT)
        Log.d(TAG, "showCorrect: ${currentFocusEditText?.text.toString()}")


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

                // 全部完成后，最后一个单词填空位置，清空焦点 + 不可点击 + 光标不可见 + 不可触摸
                currentFocusEditText?.clearFocus()
                currentFocusEditText?.isClickable = false
                currentFocusEditText?.isCursorVisible = false
                currentFocusEditText?.isFocusableInTouchMode = false
            }
            return
        }

        // 当前的控件设置为不可点击,下一个单词的 view 获取焦点, 并更新当前单词 currentWord
        currentFocusEditText?.isClickable = false
        currentFocusEditText?.isCursorVisible = false
        currentFocusEditText?.isFocusableInTouchMode = false
        postDelayed(object : Runnable {
            override fun run() {
                currentFocusEditText = wordViewList.get(nextWordIndex)
                currentFocusEditText?.requestFocus()
                currentWord = wordList.get(nextWordIndex)
            }
        }, 20)


    }

    fun isError(): Boolean {
        return currentSpellState == STATE_ERROR
    }

    fun isNormal(): Boolean {
        return currentSpellState == STATE_NORMAL
    }

    fun isCorrect(): Boolean {
        return currentSpellState == STATE_CORRECT
    }

    /**
     * 重置状态，
     * 三个地方调用：beforeTextChanged(), 焦点变化时
     */
    fun resetState() {
        if (isError()) {
            removeAlertView()
        }
        if (!mCurrentUserInput.toUpperCase().equals(mCurrentFocusKeyWordAnswer.toUpperCase())) {
            currentFocusEditText?.setTextColor(COLOR_NORMAL)
            currentSpellState = STATE_NORMAL
        } else { // 这里可以连续跳转，凡是拼写正确的都跳过
            showCorrect()
        }
        lastErrorTip = ""
        mCurrentUserInput = currentFocusEditText?.text.toString()
        currentFocusEditText?.hint = ""
    }


    fun removeAlertView() {
        ((context as Activity).window.decorView as ViewGroup).removeView(alertView)
    }

    /**
     * 显示键盘
     * 不生效
     */
    fun showKeyboard() {
        if (!isNormal() && !isError()) {
            return
        }

        if (!currentFocusEditText?.isFocused!!) {
            currentFocusEditText?.isFocusable = true
            currentFocusEditText?.isFocusableInTouchMode = true
            currentFocusEditText?.requestFocus()
            (context as Activity).window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }

    }

    /**
     * 解析句子。
     * 如果句子中没有挖空的单词，
     */
    fun parse(sentence: String): MutableList<Word> {
        // 先找第一个 <span class="key">，如果找到了，记下 index，切割前面的部分

        var localSentence = sentence
        var currWordStartIndex: Int
        var currWordEndIndex: Int
        var words: MutableList<Word> = ArrayList()
        var moveIndex = 0
        var partCount = 0
        var wordCount = 0

        do {
            // 当前最新部分的，第一个 <span class="key"> 的 '<' 在的索引
            currWordStartIndex = localSentence.indexOf(PRE_WORD_KEY_STR)
            // 当前最新部分的，第一个 </span> 的 '<' 在的索引
            currWordEndIndex = localSentence.indexOf(SUFFIX_WORD_KEY_STR)

            var normalWordPart: String = ""
            if (currWordStartIndex == -1 && currWordEndIndex == -1) {
                // 把最后的部分取出来
                normalWordPart = localSentence.substring(moveIndex)
                words.add(
                    Word(
                        normalWordPart,
                        null,
                        (partCount + 1),
                        null,
                        moveIndex,
                        -1,
                        -1
                    )
                )
                break
            }



            if (currWordStartIndex > 0) {
                // 切割拼写单词前面的内容
                normalWordPart = localSentence.substring(moveIndex, currWordStartIndex)

            }
            // 切割单词
            val tempWordData = localSentence.substring(
                currWordStartIndex + PRE_WORD_KEY_STR.length,
                currWordEndIndex
            )

            // 把标签去掉, 先去掉后面的再去掉前面的
            localSentence = localSentence.replaceRange(
                currWordEndIndex,
                currWordEndIndex + SUFFIX_WORD_KEY_STR.length,
                ""
            )
            localSentence = localSentence.replaceRange(
                currWordStartIndex,
                currWordStartIndex + PRE_WORD_KEY_STR.length,
                ""
            )

            // 保存解析的单词和非拼写单词部分
            words.add(
                Word(
                    normalWordPart,
                    null,
                    partCount,
                    null,
                    moveIndex,
                    -1,
                    -1
                )
            )
            partCount++
            words.add(
                Word(
                    null,
                    tempWordData,
                    null,
                    partCount,
                    -1,
                    currWordStartIndex,
                    wordCount
                )
            )
            partCount++
            wordCount++
            moveIndex = currWordStartIndex + tempWordData.length


        } while (true)


        return words
    }

    inner class Word(
        var normalPart: String?,
        var spellPart: String?,
        var normalPartOrder: Int?,
        var spellPartOrder: Int?,
        var normalPartStartIndex: Int,
        var spellPartStartIndex: Int,
        var wordIndex: Int
    ) {

        /**
         * 用户输入内容
         */
        var tempInput: String? = null
            set(value) {
                field = value
            }
            get() {
                return field
            }

        /**
         * 用户输入状态
         */
        var spellSuccess = false
            set(value) {
                field = value
            }
            get() {
                return field
            }

        fun isWord(): Boolean{
            return spellPart != null
        }
    }
}