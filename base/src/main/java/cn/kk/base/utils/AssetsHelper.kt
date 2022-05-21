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

           // region Android 开发高手课
               BaseItem.action_book_android_dev_performance -> {
                   val bookBasePath = "https://gitee.com/kamaihamaiha/custom-view/tree/master/doc/android_dev_performance"
                   val partPath = "/part_${item.chapter_action}"
                   val sectionPath = "/section_${item.section_action}.md"

                   bookBasePath.plus(partPath).plus(sectionPath)
               }
           // endregion

           // region Android 开发艺术探索
           BaseItem.action_book_android_dev_art -> {
               // doc/books/android_dev_art/chapter_15/section_1.md
               val bookBasePath = "https://gitee.com/kamaihamaiha/custom-view/tree/master/doc/books/android_dev_art"
               val partPath = "/chapter_${item.chapter_action}"
               val sectionPath = "/section_${item.section_action}.md"

               bookBasePath.plus(partPath).plus(sectionPath)
           }
           // endregion

            // region cpp
            BaseItem.action_book_c_plus -> {
                val repPreUrl = "https://github.com/kamaihamaiha/StudyForCpp/blob/master/doc/"
                repPreUrl.plus("chapter_${item.chapter_action}/section_${item.section_action}.md")
            }
            // endregion

           // region FFMpeg
           BaseItem.action_book_ffmpeg -> {
                when(item.chapter_action) {
                    1, 2 -> {
                        // https://gitee.com/kamaihamaiha/ffmpeg-note/blob/main/docs/part_1/chapter_2/2.1.md
                        // https://gitee.com/kamaihamaiha/ffmpeg-note/blob/main/docs/part_1/chapter_3/section_1/3.1.md
                        when(item.section_action) {
                            in 1..8 -> ("https://gitee.com/kamaihamaiha/ffmpeg-note/blob/main/docs/part_1" +
                                    "/chapter_" +
                                    "${item.chapter_action}/${item.chapter_action}.").plus(item.section_action).plus(".md")
                            else -> { "" }
                        }
                    }
                    3 -> {
                        "https://gitee.com/kamaihamaiha/ffmpeg-note/blob/main/docs/part_1/chapter_3/section_${item.section_action}/3.${item.section_action}.md"
                    }
                    4 -> {
                        "https://gitee.com/kamaihamaiha/ffmpeg-note/blob/main/docs/part_1/chapter_4/4.${item.section_action}.md"
                    }
                    else ->{ "" }
                }
           }
           // endregion

           // region IDE
           BaseItem.ACTION_BOOK_IDE -> {
               when(item.chapter_action) {
                   1 -> {
                       when(item.section_action) {
                           1 -> "https://gitee.com/kamaihamaiha/custom-view/tree/master/doc/ide/android_studio/android_studio.md"
                           2 -> "https://gitee.com/kamaihamaiha/custom-view/tree/master/doc/ide/android_studio/as_1.md"
                           3 -> "https://gitee.com/kamaihamaiha/custom-view/tree/master/doc/ide/android_studio/as_2.md"

                           else -> ""
                       }
                   }

                   else -> ""
               }
           }
           // endregion

           else -> { "" }
        }



        return url
    }
}