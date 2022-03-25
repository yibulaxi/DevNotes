package com.yusys.yump.harmony;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class CustomImageView extends androidx.appcompat.widget.AppCompatImageView {

    private float mEraseY = 0.5f;

    private RectF mEraseRect;

    private Paint mClearPaint = new Paint();

    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void createEraseRect() {
        float viewHeight = getMeasuredHeight();
        float viewWidth = getMeasuredWidth();
        float height = viewHeight * mEraseY;
        float width = viewWidth;
        mEraseRect = new RectF(0, viewHeight - height, width, viewHeight);
        mClearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        LinearGradient linearGradient = new LinearGradient(0, 0, 0, height, Color.argb(0, 255, 255, 255), Color.argb(255, 255, 255, 255), Shader.TileMode.MIRROR);
        mClearPaint.setShader(linearGradient);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        createEraseRect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int layer = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);

        super.onDraw(canvas);
        canvas.drawRect(mEraseRect, mClearPaint);

        canvas.restoreToCount(layer);
    }
}
