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

    /**
     * 获取 Markdown 文件地址
     * @param bookType 书类型
     * @param item 书的章节信息
     */
    fun getMarkdownURL(bookType: Int, item: BaseItem): String {

       val url = when(bookType) {

            // region cpp
            BaseItem.action_book_c_plus -> {
                when(item.chapter_action) {

                    2 -> { // chapter2
                        when(item.section_action) {
                            // section 1
                            1 ->  "https://gitee.com/kamaihamaiha/study_-for_-cpp/blob/master/doc/chapter_2/section_1.md"
                            2 ->  "https://gitee.com/kamaihamaiha/study_-for_-cpp/blob/master/doc/chapter_2/section_2.md"
                            3 ->  "https://gitee.com/kamaihamaiha/study_-for_-cpp/blob/master/doc/chapter_2/section_3.md"
                            4 ->  "https://gitee.com/kamaihamaiha/study_-for_-cpp/blob/master/doc/chapter_2/section_4.md"
                            5 ->  "https://gitee.com/kamaihamaiha/study_-for_-cpp/blob/master/doc/chapter_2/section_5.md"
                            6 ->  "https://gitee.com/kamaihamaiha/study_-for_-cpp/blob/master/doc/chapter_2/section_6.md"

                            else -> { ""}
                        }

                    }

                    else -> {
                        ""
                    }
                }
            }
            // endregion

           // region FFMpeg
           BaseItem.action_book_ffmpeg -> {
                when(item.chapter_action) {
                    1 -> {
                        when(item.section_action) {
                            in 1..8 -> "https://gitee.com/kamaihamaiha/ffmpeg-note/blob/main/docs/part_1/chapter_1/1.".plus(item.section_action).plus(".md")
                            else -> { "" }
                        }
                    }
                    else ->{ "" }
                }
           }
           // endregion
           else -> { "" }
        }



        return url
    }
}