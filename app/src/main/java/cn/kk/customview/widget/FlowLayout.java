package cn.kk.customview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.kk.customview.R;
import cn.kk.customview.bean.Word;
import cn.kk.customview.utils.ParseSentenceUtil;

/**
 * FlowLayout is much more like a {@link android.widget.LinearLayout}, but it can automatically
 * separate the widgets wrapped in it into multiple lines just like the water flow.
 * <p>
 * Inspired by {@see http://hzqtc.github.io/2013/12/android-custom-layout-flowlayout.html}
 *
 * @author liangfeizc {@see http://www.liangfeizc.com}
 */
public class FlowLayout extends ViewGroup {

    private static final int DEFAULT_HORIZONTAL_SPACING = 5;
    private static final int DEFAULT_VERTICAL_SPACING = 5;

    private int mVerticalSpacing;
    private int mHorizontalSpacing;

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FlowLayout);
        try {
            mHorizontalSpacing = a.getDimensionPixelSize(
                    R.styleable.FlowLayout_horizontal_spacing, DEFAULT_HORIZONTAL_SPACING);
            mVerticalSpacing = a.getDimensionPixelSize(
                    R.styleable.FlowLayout_vertical_spacing, DEFAULT_VERTICAL_SPACING);
        } finally {
            a.recycle();
        }
    }


    public void setHorizontalSpacing(int pixelSize) {
        mHorizontalSpacing = pixelSize;
    }

    public void setVerticalSpacing(int pixelSize) {
        mVerticalSpacing = pixelSize;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int myWidth = resolveSize(0, widthMeasureSpec);

        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int childLeft = paddingLeft;
        int childTop = paddingTop;

        int lineHeight = 0;

        // Measure each child and put the child to the right of previous child
        // if there's enough room for it, otherwise, wrap the line and put the child to next line.
        for (int i = 0, childCount = getChildCount(); i < childCount; ++i) {
            View child = getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                measureChild(child, widthMeasureSpec, heightMeasureSpec);
            } else {
                continue;
            }

            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();

            lineHeight = Math.max(childHeight, lineHeight);

            if (childLeft + childWidth + paddingRight > myWidth) {
                childLeft = paddingLeft;
                childTop += mVerticalSpacing + lineHeight;
                lineHeight = childHeight;
            } else {
                childLeft += childWidth + mHorizontalSpacing;
            }
        }

        int wantedHeight = childTop + lineHeight + paddingBottom;

        setMeasuredDimension(myWidth, resolveSize(wantedHeight, heightMeasureSpec));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int myWidth = r - l;

        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();

        int childLeft = paddingLeft;
        int childTop = paddingTop;

        int lineHeight = 0;

        for (int i = 0, childCount = getChildCount(); i < childCount; ++i) {
            View childView = getChildAt(i);

            if (childView.getVisibility() == View.GONE) {
                continue;
            }

            int childWidth = childView.getMeasuredWidth();
            int childHeight = childView.getMeasuredHeight();

            lineHeight = Math.max(childHeight, lineHeight);

            if (childLeft + childWidth + paddingRight > myWidth) {
                childLeft = paddingLeft;
                childTop += mVerticalSpacing + lineHeight;
                lineHeight = childHeight;
            }

            childView.layout(childLeft, childTop, childLeft + childWidth, childTop + childHeight);
            childLeft += childWidth + mHorizontalSpacing;
        }
    }

    public void addData(String data) {

        // 解析句子

        List<Word> wordList = ParseSentenceUtil.INSTANCE.parse(data);

        // 根据解析的句子，动态生成一组 view
        if (wordList.isEmpty()) {
            return;
        }

        for (Word word : wordList) {
            if (word.isWord()) {
                createWordView(word.getSpellPart());
            } else {
                createNormalView(word.getNormalPart());
            }
        }

    }


    private void createNormalView(String normalPart) {
        for (String word : normalPart.split(" ")) {
            TextView wordView = new TextView(getContext());
            wordView.setText(word + " ");
            wordView.setTextSize(18);
            wordView.setHeight(dp2px(38));
            addView(wordView);
        }
    }

    private void createWordView(String word) {
        TextView wordView = new TextView(getContext());
        wordView.setText(word);
        wordView.setTextSize(18);
        wordView.setTextColor(Color.RED);
        wordView.setHeight(dp2px(38));
        addView(wordView);
    }



    private int dp2px(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }
}
