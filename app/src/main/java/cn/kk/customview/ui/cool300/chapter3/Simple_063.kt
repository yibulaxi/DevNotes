package cn.kk.customview.ui.cool300.chapter3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import cn.kk.base.UIHelper
import cn.kk.customview.R

class Simple_063 : AppCompatActivity() {
    lateinit var myToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_simple_063)

        myToolbar = findViewById(R.id.my_tool_bar)
        myToolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary))
        myToolbar.setTitle("simple-063")

        myToolbar.setNavigationIcon(R.drawable.icon_back)
        // 设置右上角菜单
        myToolbar.inflateMenu(R.menu.my_menu)

        // 响应按钮点击
        myToolbar.setNavigationOnClickListener { finish() }
        myToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_china -> {
                    UIHelper.toast("china", this)
                    true
                }
                R.id.menu_america -> {
                    UIHelper.toast("america", this)
                    true
                }
                R.id.menu_russia -> {
                    UIHelper.toast("russia", this)
                    true
                }
                R.id.menu_japan -> {
                    UIHelper.toast("japan", this)
                    true
                }
                else -> {
                    true
                }
            }

        }
    }
}