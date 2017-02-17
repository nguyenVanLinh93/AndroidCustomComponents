package com.example.nguyenlinh.androidcustomcomponents;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

/**
 * Make a custom View called RedView.
 * It should have a red background and a desired dimension (e.g., when used with wrap_content) of 200 pixels in both directions.
 * Put it in a layout that has some nested vertical and horizontal LinearLayouts, and sometimes use wrap_content and sometimes use match_parent.
 *
 * Created by nguyenlinh on 17/02/2017.
 */

public class RedView extends View {
    private int mDesiredSize = 200;
    private int mBackgroundColor = Color.RED;
    private int mColorSecond = Color.YELLOW;

    public RedView(Context context) {
        super(context);
    }

    public RedView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(mBackgroundColor);
    }

    public RedView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        //Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            //Must be this size
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            width = Math.min(mDesiredSize, widthSize);
        } else {
            //Be whatever you want
            width = mDesiredSize;
        }

        //Measure Height
        if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(mDesiredSize, heightSize);
        } else {
            //Be whatever you want
            height = mDesiredSize;
        }

        setMeasuredDimension(width, height);
    }

    public void changeColor(){
        setBackgroundColor(mColorSecond);
    }
}
