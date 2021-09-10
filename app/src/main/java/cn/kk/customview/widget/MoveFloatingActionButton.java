package cn.kk.customview.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import cn.kk.base.UIHelper;

/**
 * 类描述: This is ...
 * 创建人: kk
 * 创建时间: 9/8/21
 */
public class MoveFloatingActionButton extends FloatingActionButton implements View.OnTouchListener {
    private final static float CLICK_DRAG_TOLERANCE = 10; // Often, there will be a slight, unintentional, drag when the user taps the FAB, so we need to account for this.
    private static final String TAG = "MoveFloatingActionButton";
    private float downRawX, downRawY;
    private float marginX, marginY;
    private float dX, dY;
    private int screenWidth = 0;

    public MoveFloatingActionButton(@NonNull Context context) {
        super(context);
        init(context);
    }

    public MoveFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MoveFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(@NonNull Context context) {
        setOnTouchListener(this);
        screenWidth = UIHelper.INSTANCE.getScreenSize((Activity) context).x;
        marginX = 100;
        marginY = 100;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();

        int action = motionEvent.getAction();
        if (action == MotionEvent.ACTION_DOWN) {

            downRawX = motionEvent.getRawX();
            downRawY = motionEvent.getRawY();
            dX = view.getX() - downRawX;
            dY = view.getY() - downRawY;

            return true; // Consumed

        }
        else if (action == MotionEvent.ACTION_MOVE) {

            int viewWidth = view.getWidth();
            int viewHeight = view.getHeight();

            View viewParent = (View)view.getParent();
            int parentWidth = viewParent.getWidth();
            int parentHeight = viewParent.getHeight();

            float newX = motionEvent.getRawX() + dX;
            newX = Math.max(layoutParams.leftMargin, newX); // Don't allow the FAB past the left hand side of the parent
            newX = Math.min(parentWidth - viewWidth - layoutParams.rightMargin, newX); // Don't allow the FAB past the right hand side of the parent

            float newY = motionEvent.getRawY() + dY;
            newY = Math.max(layoutParams.topMargin, newY); // Don't allow the FAB past the top of the parent
            newY = Math.min(parentHeight - viewHeight - layoutParams.bottomMargin, newY); // Don't allow the FAB past the bottom of the parent

            view.animate()
                    .x(newX)
                    .y(newY)
                    .setDuration(0)
                    .start();

            return true; // Consumed

        }
        else if (action == MotionEvent.ACTION_UP) {

            float upRawX = motionEvent.getRawX();
            float upRawY = motionEvent.getRawY();

            float upDX = upRawX - downRawX;
            float upDY = upRawY - downRawY;

            if (Math.abs(upDX) < CLICK_DRAG_TOLERANCE && Math.abs(upDY) < CLICK_DRAG_TOLERANCE) { // A click
                return performClick();
            }
            else { // A drag
                // 判断手指抬起后，水平位置是屏幕左边还是右边。
                if (upRawX < screenWidth / 2){
                    view.animate().x(marginX).setDuration(150).start();
                } else {
                    view.animate().x(screenWidth - view.getWidth() - marginX).setDuration(150).start();
                }
                return true; // Consumed
            }

        }
        else {
            return super.onTouchEvent(motionEvent);
        }

    }


}
