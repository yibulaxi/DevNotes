package cn.kk.base.utils

import android.content.Context
import cn.kk.customview.bean.BaseItem

object AssetsHelper {

    fun getHtmlValue(ctx: Context, dirName: String, fileName: String): String {
        return ctx.assets.open(String.format("%s/%s", dirName, fileName)).bufferedReader().use { it.readText() }
    }

    fun getHtmlFilePath(fileName: String): String{
        return "file:android_asset/".plus("html").plus("/").plus(fileName)
    }

    fun getMarkdownFilePath(fileName: String): String {
        return "md/".plus(fileName)
    }

    fun getMarkdownURL(bookType: Int, item: BaseItem): String {

       val url = when(bookType) {
            BaseItem.action_book_c_plus -> {
                when(item.chapter_action) {

                    2 -> { // chapter2
                        when(item.section_action) {
                            // section 1
                            1 ->  "https://gitee.com/kamaihamaiha/study_-for_-cpp/blob/master/doc/chapter_2/section_1.md"
                            2 ->  "https://gitee.com/kamaihamaiha/study_-for_-cpp/blob/master/doc/chapter_2/section_2.md"
                            3 ->  "https://gitee.com/kamaihamaiha/study_-for_-cpp/blob/master/doc/chapter_2/section_3.md"

                            else -> { ""}
                        }

                    }

                    else -> {
                        ""
                    }
                }
            }
           else -> { "" }
        }

        return url
    }
}