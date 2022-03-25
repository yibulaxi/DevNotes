package cn.kk.customview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import cn.kk.customview.R;

/**
 * 图片渐变效果。原创自：Hencoder 学元群，分享的
 */
public class GradientImageView extends androidx.appcompat.widget.AppCompatImageView {

    private float mEraseY = 0.5f;

    private RectF mEraseRect;

    private Paint mClearPaint = new Paint();

    public GradientImageView(Context context) {
//        super(context);
        this(context, null);
    }

    public GradientImageView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
        this(context, attrs, 0);
    }

    public GradientImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setImageDrawable(ContextCompat.getDrawable(context, R.drawable.bg_portrait_1));
    }

    private void createEraseRect() {
        float viewHeight = getMeasuredHeight();
        float viewWidth = getMeasuredWidth();
        float height = viewHeight * mEraseY;
        float width = viewWidth;
        mEraseRect = new RectF(0, viewHeight - height, width, viewHeight);
        mClearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        LinearGradient linearGradient = new LinearGradient(0, 0, 0, height,
                Color.argb(0, 255, 255, 255), Color.argb(255, 255, 255, 255),
                Shader.TileMode.MIRROR);
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
