package cn.kk.customview.widget;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.ColorInt;

import cn.kk.customview.R;


public class CountIndicatorView extends View {
    protected int numberOfItems = 6;
    protected int itemSpacing = 10;
    protected int radius = 5;
    private int numberSelected = 3;
    private  @ColorInt int unSelectedColour;
    private  @ColorInt int selectedColour;

    public CountIndicatorView(Context context) {
        super(context);
    }

    public CountIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        TypedArray styledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CountIndicatorView);
        radius = styledAttributes.getInt(R.styleable.CountIndicatorView_radius, radius);
        numberOfItems = styledAttributes.getInt(R.styleable.CountIndicatorView_numberOfItems, numberOfItems);
        numberSelected = styledAttributes.getInt(R.styleable.CountIndicatorView_numberSelected, numberSelected);
        itemSpacing = styledAttributes.getInt(R.styleable.CountIndicatorView_itemSpacing2, itemSpacing);
        selectedColour = styledAttributes.getColor(R.styleable.CountIndicatorView_selectedColor, Color.BLACK);
        unSelectedColour = styledAttributes.getColor(R.styleable.CountIndicatorView_unSelectedColor, Color.GRAY);
        styledAttributes.recycle();
    }

    public int getItemSpacing() {
        return itemSpacing;
    }

    public void setItemSpacing(int itemSpacing) {
        this.itemSpacing = itemSpacing;
        requestLayout();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        requestLayout();
    }

    public int getUnSelectedColour() {
        return unSelectedColour;
    }

    public void setUnSelectedColour(int unSelectedColour) {
        this.unSelectedColour = unSelectedColour;
        invalidate();
    }

    public int getSelectedColour() {
        return selectedColour;
    }

    public void setSelectedColour(int selectedColour) {
        this.selectedColour = selectedColour;
        invalidate();
    }


    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
        requestLayout();
    }

    public void setNumberSelected(int number) {
        this.numberSelected = number;
        invalidate();
    }

    public int getNumberSelected() {
        int itemWidth = (getWidth() / numberOfItems);
        for (int i = 0; i < numberOfItems; i++) {
            if (downX > itemWidth * i && downX <= itemWidth * (i + 1)) {
                numberSelected = i;
                break;
            }
        }
        return this.numberSelected;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < numberOfItems; i++) {
            float x = i * itemSpacing + (i * (radius * 2)) + radius + getPaddingLeft();
            float y = radius + getPaddingTop();
            canvas.drawCircle(x, y, radius, getPaint(i));
        }
    }

    float downX;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                break;
        }
        return super.onTouchEvent(event);
    }

    private onIndicatorClickListener mListener;

    public void setOnIndicatorClickListener(onIndicatorClickListener listeners) {
        this.mListener = listeners;
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemWidth = (getWidth() / numberOfItems);
                for (int i = 0; i < numberOfItems; i++) {
                    if (downX > itemWidth * i && downX <= itemWidth * (i + 1)) {
                        numberSelected = i;
                        break;
                    }
                }
                if (mListener != null)
                    mListener.onItemClick(numberSelected);
            }
        });
    }

    public interface onIndicatorClickListener {
        void onItemClick(int index);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);    //To change body of overridden methods use File | Settings | File Templates.
        int width = (numberOfItems * (radius * 2)) + ((numberOfItems - 1) * itemSpacing) + getPaddingLeft() + getPaddingRight();
        int height = (2 * radius) + getPaddingBottom() + getPaddingTop();
        setMeasuredDimension(width, height);
    }


    private Paint getPaint(int i) {
        int colour = i != numberSelected ? unSelectedColour : selectedColour;
        Paint p = new Paint();
        p.setColor(colour);
        p.setAntiAlias(true);
        return p;
    }

}
