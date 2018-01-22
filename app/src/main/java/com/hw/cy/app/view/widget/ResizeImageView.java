package com.hw.cy.app.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.hw.cy.app.R;


/**
 * Created by Administrator on 2016/5/20.
 */
public class ResizeImageView extends android.support.v7.widget.AppCompatImageView {
    private int resizeWidth=16;
    private int resizeHeight=9;

    public ResizeImageView(Context context) {
        super(context);
    }

    public ResizeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ResizeImageView);
        resizeWidth=ta.getInt(R.styleable.ResizeImageView_resize_width,16);
        resizeHeight=ta.getInt(R.styleable.ResizeImageView_resize_height,9);
        ta.recycle();
    }

    public ResizeImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ResizeImageView);
        resizeWidth=ta.getInt(R.styleable.ResizeImageView_resize_width,16);
        resizeHeight=ta.getInt(R.styleable.ResizeImageView_resize_height,9);
        ta.recycle();
    }

    public void setResize(int width,int height){
        this.resizeWidth=width;
        this.resizeHeight=height;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width= MeasureSpec.getSize(widthMeasureSpec);
        int height=width*resizeHeight/resizeWidth;
        setMeasuredDimension(width, height);
    }
}
