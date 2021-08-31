package cn.kk.base.widget

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

/**
 * 加载更多的 RecyclerView
 */
class LoadMoreRecyclerView(context: Context, attrs: AttributeSet?) : RecyclerView(context, attrs) {
    val TAG = "LoadMoreRecyclerView"
    var isSlideUp = false
    var loadListener: LoadListener? = null

    override fun onScrolled(dx: Int, dy: Int) {
        super.onScrolled(dx, dy)
        isSlideUp = dy > 0
    }

    override fun onScrollStateChanged(state: Int) {
        super.onScrollStateChanged(state)
        if (layoutManager is StaggeredGridLayoutManager) {
            val manager = layoutManager as StaggeredGridLayoutManager
            if (state == SCROLL_STATE_IDLE) {
                val lastItemP = manager.findLastCompletelyVisibleItemPositions(IntArray(manager.spanCount))
                if (lastItemP[0] == (manager.itemCount - 1) || lastItemP[1] == (manager.itemCount - 1) && isSlideUp) {
                    // 加载更多
                    loadListener?.loadMore()
                }
            }
        } else if (layoutManager is LinearLayoutManager){
            val manager = layoutManager as LinearLayoutManager
            if (state == SCROLL_STATE_IDLE){
                val lastViewPosition = manager.findLastCompletelyVisibleItemPosition()
                if (lastViewPosition == manager.itemCount - 1){
                    // 加载更多
                    loadListener?.loadMore()
                }
            }
        }
    }

    interface LoadListener {

        fun loadMore();
    }


}