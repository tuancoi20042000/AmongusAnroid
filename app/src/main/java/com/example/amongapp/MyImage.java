package com.example.amongapp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class MyImage extends ImageView {
    public MyImage(Context context) {
        super(context);
    }

    public MyImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int a= getMeasuredWidth();
        setMeasuredDimension(a,a);
    }
}
