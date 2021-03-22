package cn.kk.customview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import cn.kk.customview.R;

/**
 * 项目: Custom View
 * 类描述: 继承 View 的自定义控件, 矩形View
 * 1. 实现 onDraw() 方法
 * 2. 处理 padding 属性
 * 3. 处理 wrap_content 属性, 在 onMeasure() 方法中处理
 * 4. 对外提供自定义属性: rect_color
 * <p>
 * 创建人: kk
 * 创建时间: 3/22/21
 */
public class RectView extends View {
    private static final String TAG = "RectView";
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mColor = Color.parseColor("#ABCEDF"); //画笔颜色
    private float paintWidth = 5.f; //画笔宽度
    private int defaultWidth = 0; // view 默认宽
    private int defaultHeight = 0; // view 默认高

    public RectView(Context context) {
        super(context);
        initPaint();
    }

    public RectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //得到自定义属性：rect_color
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.RectView);
        mColor = mTypedArray.getColor(R.styleable.RectView_rect_color,Color.parseColor("#123456"));

        //回收资源
        mTypedArray.recycle();
        initPaint();
    }

    public RectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint.setColor(mColor);
        mPaint.setStrokeWidth(paintWidth);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthSpecSize = MeasureSpec.getSize(widthSpecMode);
        int heightSpecSize = MeasureSpec.getSize(heightSpecMode);


        if (widthMeasureSpec == MeasureSpec.AT_MOST &&
                heightMeasureSpec == MeasureSpec.AT_MOST) {
            setMeasuredDimension(defaultWidth, defaultHeight);
        } else if (widthMeasureSpec == MeasureSpec.AT_MOST) {
            setMeasuredDimension(defaultWidth, heightSpecSize);
        } else if (heightMeasureSpec == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, defaultHeight);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 处理 padding
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int width = getWidth() - (paddingLeft + paddingRight);
        int height = getHeight() - (paddingTop + paddingBottom);

        int left = 0 + paddingLeft;
        int top = 0 + paddingTop;

        canvas.drawRect(left, top, left + width, top + height, mPaint);

    }
}
