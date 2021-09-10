package cn.kk.customview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class ProgressImageView extends ImageView {
    Paint circlePaint = new Paint();
    private float progress;
    private RectF rectF = new RectF();
    private boolean progressEnable;
    private int strokeWidth = 0;

    public ProgressImageView(Context context) {
        super(context);
        initPaint();
    }

    public ProgressImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public ProgressImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }


    private void initPaint() {
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(Color.TRANSPARENT);
        circlePaint.setStyle(Paint.Style.STROKE);
    }

    public void setProgressColor(int color) {
        circlePaint.setColor(color);
    }

    public void setProgressStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
        circlePaint.setStrokeWidth(strokeWidth);
    }


    public void setProgress(float progress) {
        if (progress < 0) {
            progress = 0;
        } else if (progress > 1) {
            progress = 1;
        }
        this.progress = progress * 360;
        postInvalidate();
    }

    public void setProgressEnable(boolean enable) {
        if (progressEnable = enable) {
            return;
        }
        progressEnable = enable;
        progress = 0;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (progressEnable) {
            rectF.left = strokeWidth;
            rectF.top = strokeWidth;
            rectF.right = getWidth() - strokeWidth;
            rectF.bottom = getBottom() - strokeWidth;
            canvas.drawArc(rectF, 0,
                    progress, false, circlePaint);
        }


    }
}
