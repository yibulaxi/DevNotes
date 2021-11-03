package cn.kk.customview.widget.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/**
 * 项目: CustomView
 * 类描述: This is 自定义 Behavior, 这个目前还有问题
 * 创建人: kk
 * 创建时间: 11/3/21
 */
public class FooterBehavior extends CoordinatorLayout.Behavior<View> {
    private int directionChange;

    public FooterBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes) {
        return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed) {
        if (dy > 0 && directionChange < 0 || dy < 0 && directionChange > 0){
            child.animate().cancel();;
            directionChange = 0;
        }
        directionChange += dy;

        if (directionChange > child.getHeight() && child.getVisibility() == View.VISIBLE){
            hide(child);
        } else {
            show(child);
        }
    }

    private void show(View child) {
        ViewPropertyAnimator animator = child.animate()
                .translationY(0)
                .setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(200);
        animator.setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                child.setVisibility(View.VISIBLE);
            }
        });
        animator.start();

    }

    private void hide(final View child) {
        ViewPropertyAnimator animator = child.animate()
                .translationY(child.getHeight())
                .setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(200);
        animator.setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                child.setVisibility(View.GONE);
            }
        });
        animator.start();
    }


}
