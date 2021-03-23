package cn.kk.customview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Scroller;

/**
 * 项目: CustomView
 * 类描述: 继承自 ViewGroup 的控件，实现左右滑动（为了简单，没有处理 padding 和 子view 的 margin）
 * 创建人: kk
 * 创建时间: 3/23/21
 * <p>
 * 1. onMeasure() 中处理 wrap_content 属性
 * 2. onLayout() 必须要实现，在里面处理 子view 摆放
 * 3. onInterceptTouchEvent() 处理滑动冲突（如果里面是 ListView，则为垂直滑动，会导致滑动冲突。解决办法：如果监测到水平滑动，则让父view 拦截）
 * 4. onTouchEvent() 弹性滑动到其他页面
 * 5. VelocityTracker，用来测试滑动速度。 快速滑动到其他页面
 * 6. 再次触摸屏幕，阻止上次没有完成的滑动
 */
public class HorizontalView extends ViewGroup {
    private static final String TAG = "HorizontalView";
    private int lastInterceptX = -1;
    private int lastInterceptY = -1;
    private int lastTouchX;
    private int lastTouchY;
    private int currentIndex = 0;
    private int childWidth;
    private Scroller mScroller;
    private VelocityTracker mVelocityTracker;
    private int scrollDuration = 1000;

    public HorizontalView(Context context) {
        this(context, null);
    }

    public HorizontalView(Context context, AttributeSet attrs) {
//        super(context, attrs);
        this(context, attrs, 0);
    }

    public HorizontalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mScroller = new Scroller(getContext());
        mVelocityTracker = VelocityTracker.obtain();

        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_expandable_list_item_1);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMode);
        int heightSize = MeasureSpec.getSize(heightMode);

        measureChildren(widthMeasureSpec, heightMeasureSpec);

        // 如果没有 子view，就设置宽高为 0(简化处理，正常应该根据 LayoutParams 中的宽和高来做相应的处理)
        if (getChildCount() == 0) {
            setMeasuredDimension(0, 0);
        } else if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            // 宽和高都是 AT_MOST，宽度设置为所有宽度的和，高度设置为第一个 子view 的高度
            View firstChild = getChildAt(0);
            int firstChildWidth = firstChild.getWidth();
            int firstChildHeight = firstChild.getHeight();
            setMeasuredDimension(firstChildWidth * getChildCount(), firstChildHeight);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            // 宽是 AT_MOST,宽度设置为所有宽度的和
            setMeasuredDimension(getChildAt(0).getWidth() * getChildCount(), heightSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            // 高是 AT_MOST,高度设置为第一个元素的高度
            setMeasuredDimension(widthSize, getChildAt(0).getHeight());
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        View child;
        int childCount = getChildCount();
        int left = 0;
        for (int i = 0; i < childCount; i++) {
            child = getChildAt(i);

            // 如果 子view 不是 GONE，那么就摆放
            if (child.getVisibility() != View.GONE) {
                int width = child.getMeasuredWidth();
                childWidth = width;  // 这个操作看不懂
                // 摆放的高度就是测量的高度
                child.layout(left, 0, left + width, child.getMeasuredHeight());

                // 宽度一直累加，也就是一直往右边摆放
                left += width;
            }
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercept = false;

        int x = (int) ev.getX();
        int y = (int) ev.getY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 如果上次的滑动没有完成，那么也不继续滑动了，停止
                intercept = false;
                if (!mScroller.isFinished()){
                    mScroller.abortAnimation();
                }

                //因为 intercept 为 false，所以 onTouchEvent() 就无法获取 Down 事件了，所以更新lastTouchX 和 lastTouchY
                lastTouchX = x;
                lastTouchY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                if (lastInterceptX != -1 && lastInterceptY != -1) {
                    int moveX = x - lastInterceptX;
                    int moveY = y - lastInterceptY;
                    if (Math.abs(moveX) > Math.abs(moveY)) {
                        // 属于横向滑动
                        intercept = true;
                    } else {
                        intercept = false;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                intercept = false;
                break;
        }

        lastInterceptX = x;
        lastInterceptY = y;
        return intercept;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        Log.d(TAG, "onTouchEvent: x,y= (" + x + "," + y + ")");
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                // 计算水平移动
                int moveX = x - lastTouchX;
                Log.d(TAG, "onTouchEvent: moveX= " + moveX);
                scrollBy(-moveX, 0);
                break;
            case MotionEvent.ACTION_UP:
                // 计算抬起时的水平移动距离
                int distance = getScrollX() - currentIndex * childWidth;
                if (Math.abs(distance) > childWidth / 2) { // 应该滑到下一个 child view 了
                    if (distance > 0) {
                        currentIndex++;
                    } else {
                        currentIndex--;
                    }

                    // 在这里滑动是不是也可以？
                } else { // 处理快速滑动
                    mVelocityTracker.computeCurrentVelocity(1000);
                    float xV = mVelocityTracker.getXVelocity();
                    if (Math.abs(xV) > 50) {
                        if (xV > 0) {
                            currentIndex++;
                        } else {
                            currentIndex--;
                        }
                    }
                }

                // 限定 currentIndex 范围
                currentIndex = Math.min(currentIndex,getChildCount() - 1);
                currentIndex = Math.max(0,currentIndex);

                // 滑动
                smoothScrollTo(currentIndex * childWidth, 0);

                // 滑动完后，重置速度计算器
                mVelocityTracker.clear();
                break;
        }

        lastTouchX = x;
        lastTouchY = y;
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        // 计算滑动
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

    public void smoothScrollTo(int destX, int destY) {
        mScroller.startScroll(getScrollX(), getScrollY(),
                destX - getScrollX(), destY - getScrollY(), scrollDuration);

        // 发起重新绘制
        invalidate();
    }

    private int min(int x, int y){
        return Math.min(x,y);
    }
}
