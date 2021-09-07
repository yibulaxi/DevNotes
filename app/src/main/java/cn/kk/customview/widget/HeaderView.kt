package cn.kk.customview.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import cn.kk.base.LogHelper
import cn.kk.customview.R
import com.aspsine.swipetoloadlayout.SwipeRefreshHeaderLayout

class HeaderView(context: Context?, attrs: AttributeSet?) :
    SwipeRefreshHeaderLayout(context, attrs) {

    constructor(context: Context?):this(context, null)

    var onLoadPrepageListener: onLoadPreCallback?= null
    val HEADER_STATE_HIDE = -1
    val HEADER_STATE_HALF = 0
    val HEADER_STATE_OVER_HALF = 1
    private var headerState = -HEADER_STATE_HIDE
    lateinit var tvHeader: TextView
    lateinit var ivArrow: ImageView
    var loadPre = false
    override fun onFinishInflate() {
        super.onFinishInflate()
        tvHeader = this.findViewById(R.id.tvRefreshHeader)
        ivArrow = findViewById(R.id.iv_arrow)
    }

    override fun onRelease() {
        // 释放了，因此箭头
        LogHelper.print("onRelease...")
        if (headerState == HEADER_STATE_OVER_HALF){
            loadPre = true
            onLoadPrepageListener?.onLoad()
            Toast.makeText(context, "加载上一页", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onReset() {
    }

    override fun onComplete() {
        LogHelper.print("onComplete...")
        loadPre = false
    }

    override fun onPrepare() {
    }

    override fun onRefresh() {
        LogHelper.print("onRefresh...")
        ivArrow.visibility = View.GONE
    }

    override fun onMove(y: Int, isComplete: Boolean, automatic: Boolean) {
        if (!isComplete) {
            if (y > measuredHeight / 2) {
                if (headerState != HEADER_STATE_OVER_HALF) {
                    headerState = HEADER_STATE_OVER_HALF
                    tvHeader.text = "松开查看"
                    playAnim(ivArrow,true)
                }
            } else {
                if (headerState != HEADER_STATE_HALF) {
                    headerState = HEADER_STATE_HALF
                    tvHeader.text = "下拉查看"
                    playAnim(ivArrow,false)
                }
            }
        } else {
            headerState = HEADER_STATE_HIDE
        }
    }

    fun playAnim(view: View, toUp: Boolean){
        if (loadPre) return
        val anim = RotateAnimation(if(toUp) 0f else 180f, if(toUp) 180f else 0f, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF,0.5f).apply {
            duration = 300
            fillAfter = true
        }
        view.startAnimation(anim)
    }

    interface onLoadPreCallback {
       fun onLoad()
    }
}
