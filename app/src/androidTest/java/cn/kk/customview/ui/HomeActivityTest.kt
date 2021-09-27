package cn.kk.customview.ui

import android.widget.TextView
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import cn.kk.customview.R
import org.junit.Test

import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class HomeActivityTest {

    @get:Rule
    val mActivityRunner = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun showTitle() {
        mActivityRunner.activity.runOnUiThread {
            mActivityRunner.activity.findViewById<TextView>(R.id.tv_page_title).text = mActivityRunner.activity.getString(R.string.app_name_cn)
        }
    }
}