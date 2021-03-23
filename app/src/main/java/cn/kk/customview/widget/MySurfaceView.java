package cn.kk.customview.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import cn.kk.customview.R;

/**
 * 项目: CustomView
 * 类描述: 在自定义的 SurfaceView 中绘制 bitmap
 * 创建人: kk
 * 创建时间: 3/22/21
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder mSurfaceHolder;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap;

    public MySurfaceView(Context context) {
//        super(context);
        this(context, null);
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
//        super(context, attrs);
        this(context, attrs, 0);
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // 得到控制器
        mSurfaceHolder = getHolder();

        mSurfaceHolder.addCallback(this);

        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.app_icon);
    }


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        Canvas canvas = mSurfaceHolder.lockCanvas();
        canvas.drawBitmap(mBitmap,new Matrix(),mPaint);

        // 解锁画布
        mSurfaceHolder.unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
}
