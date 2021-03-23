package cn.kk.customview.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import cn.kk.customview.R;

/**
 * 项目: CustomView
 * 类描述: This is ...
 * 创建人: kk
 * 创建时间: 3/22/21
 */
public class MyImageView extends ImageView {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.app_icon);
        canvas.drawBitmap(bitmap, 0, 0, mPaint);
    }
}
