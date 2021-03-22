package cn.kk.customview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * 项目: CustomView
 * 类描述: 继承自系统控件：TextView
 * 创建人: kk
 * 创建时间: 3/22/21
 */
public class MyTextView extends TextView {
    //创建画笔
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private void initPaint() {
        mPaint.setColor(Color.RED);  // 设置画笔颜色
        mPaint.setStrokeWidth(6.5f); // 设置画笔宽度
    }

    //
    public MyTextView(Context context) {
        super(context);
        initPaint();
    }


    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制...

        // 得到控件的尺寸：width 和 height
        int width = getWidth();
        int height = getHeight();

        // 在控件竖直方向中间位置，画一条线
        canvas.drawLine(0,height / 2f,width, height / 2f,mPaint);

    }
}
