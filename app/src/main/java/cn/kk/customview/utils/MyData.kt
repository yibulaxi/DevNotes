package cn.kk.customview.utils

object MyData {
    // 要隐藏（默写）的单词标签前半部分
    val PRE_WORD_KEY_STR = "<span class=\"key\">"

    // 要隐藏（默写）的单词标签后半部分
    val SUFFIX_WORD_KEY_STR = "</span>"

    val EMPTY_WORD_SPACE_STR = ' '


    val SENTENCES_HUMAN =
        "Android is a mobile operating system based on a modified version of the Linux kernel and other open source software, designed primarily for touchscreen mobile devices such as smartphones and tablets."

    val SENTENCES =
        "Android is a operating system based on " + PRE_WORD_KEY_STR +
                "mobile" + SUFFIX_WORD_KEY_STR +
                " operating system based on a modified version of the " + PRE_WORD_KEY_STR +
                "Linux" + SUFFIX_WORD_KEY_STR +
                " kernel and other open source software, designed primarily for touchscreen " + PRE_WORD_KEY_STR +
                "mobile" + SUFFIX_WORD_KEY_STR +
                " devices such as " + PRE_WORD_KEY_STR +
                "smartphones" + SUFFIX_WORD_KEY_STR +
                " and tablets."

}