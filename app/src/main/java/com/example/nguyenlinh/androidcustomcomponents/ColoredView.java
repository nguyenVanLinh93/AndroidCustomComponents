package com.example.nguyenlinh.androidcustomcomponents;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

/**
 * Make a new variation of your component called ColoredView.
 * Use custom XML components to let the app author specify the original background color, the color after pressing, and the desired dimension.
 *
 * Created by nguyenlinh on 17/02/2017.
 */

public class ColoredView extends View {
    private int mDesiredSizeDefault = 200;
    private int mBackgroundColorDefault = Color.RED;
    private int mColorSecondDefault = Color.YELLOW;

    public ColoredView(Context context) {
        super(context);
    }

    public ColoredView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeCustomAttributes(attrs);
        setBackgroundColor(mBackgroundColorDefault);
    }

    private void initializeCustomAttributes(AttributeSet attrs) {
        // get array attribute
        TypedArray attributeArray = getContext().obtainStyledAttributes(attrs,R.styleable.ColoredView);

        // set attributes
        mDesiredSizeDefault = attributeArray.getInt(R.styleable.ColoredView_desired_size, mDesiredSizeDefault);

        mBackgroundColorDefault = attributeArray.getInt(R.styleable.ColoredView_background_color, mBackgroundColorDefault);

        mColorSecondDefault = attributeArray.getInt(R.styleable.ColoredView_color_second, mColorSecondDefault);
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
            width = Math.min(mDesiredSizeDefault, widthSize);
        } else {
            //Be whatever you want
            width = mDesiredSizeDefault;
        }

        //Measure Height
        if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(mDesiredSizeDefault, heightSize);
        } else {
            //Be whatever you want
            height = mDesiredSizeDefault;
        }

        setMeasuredDimension(width, height);
    }

    public void changeColor(){
        setBackgroundColor(mColorSecondDefault);
    }
}
