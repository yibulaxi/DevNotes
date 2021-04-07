package cn.kk.customview.bean

/**
 */
class Word(
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