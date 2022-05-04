package cn.kk.base.utils

import android.content.Context

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
}