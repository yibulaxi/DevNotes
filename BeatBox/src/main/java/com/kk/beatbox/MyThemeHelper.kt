package com.kk.beatbox

import android.app.Activity
import android.content.res.Resources

object MyThemeHelper {

    fun getThemeColor(activity: Activity): Int{
        val theme: Resources.Theme = activity.theme
        val attrsToFetch = intArrayOf(androidx.appcompat.R.attr.colorAccent)
        val a = theme.obtainStyledAttributes(R.style.Theme_BeatBox, attrsToFetch)
        val accentColor = a.getInt(0, 0)
        a.recycle()
        return accentColor
    }
}