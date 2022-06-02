package cn.kk.customview.widget.work;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;

/**
 * 跑马灯效果
 * 参考：https://www.jianshu.com/p/c13a67172e6a
 */
public class AppMarqueeTextView extends androidx.appcompat.widget.AppCompatTextView {

    public AppMarqueeTextView(Context context) {
        super(context);
        setFocusable(true);
    }

    public AppMarqueeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFocusable(true);
    }

    public AppMarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
    }

    @Override
    public boolean isFocused() {
        return true;
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }
}