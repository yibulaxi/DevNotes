package cn.kk.customview.utils

import android.util.Log
import cn.kk.customview.bean.Word


private const val TAG = "ParseSentenceUtil"

object ParseSentenceUtil {

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
            currWordStartIndex = localSentence.indexOf(MyData.PRE_WORD_KEY_STR)
            // 当前最新部分的，第一个 </span> 的 '<' 在的索引
            currWordEndIndex = localSentence.indexOf(MyData.SUFFIX_WORD_KEY_STR)

            var normalWordPart: String = ""
            if (currWordStartIndex == -1 && currWordEndIndex == -1) {
                // 把最后的部分取出来
                normalWordPart = localSentence.substring(moveIndex)
                words.add(Word(normalWordPart, null, (partCount + 1), null, moveIndex, -1,-1))
                Log.d(TAG, "parse: normalWordPart: ${normalWordPart}")
                break
            }



            if (currWordStartIndex > 0) {
                // 切割拼写单词前面的内容
                normalWordPart = localSentence.substring(moveIndex, currWordStartIndex)

            }
            // 切割单词
            val tempWordData = localSentence.substring(
                currWordStartIndex + MyData.PRE_WORD_KEY_STR.length,
                currWordEndIndex
            )

            // 把标签去掉, 先去掉后面的再去掉前面的
            localSentence = localSentence.replaceRange(
                currWordEndIndex,
                currWordEndIndex + MyData.SUFFIX_WORD_KEY_STR.length,
                ""
            )
            localSentence = localSentence.replaceRange(
                currWordStartIndex,
                currWordStartIndex + MyData.PRE_WORD_KEY_STR.length,
                ""
            )

            // 保存解析的单词和非拼写单词部分
            words.add(Word(normalWordPart, null, partCount, null, moveIndex, -1,-1))
            partCount++
            words.add(Word(null, tempWordData, null, partCount, -1, currWordStartIndex,wordCount))
            partCount++
            wordCount++
            moveIndex = currWordStartIndex + tempWordData.length

            Log.d(TAG, "parse: normalWordPart: ${normalWordPart}, tempWordData: ${tempWordData}")

        } while (true)


        return words
    }
}