package com.xinzhili.doctor.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.xinzhili.doctor.R;
import com.xinzhili.doctor.util.AppUtil;

import androidx.annotation.Nullable;

/**
 * 自定义圆点
 * 可设置颜色和半径
 */
public class PointView extends View {
    private float mRadio = 3;
    private int mPointColor = Color.BLACK;
    private Paint mPaint;

    public PointView(Context context) {
        super(context);
        initPaint();
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = null;
        try {
            ta = context.obtainStyledAttributes(attrs, R.styleable.PointView);
            mRadio = ta.getDimension(R.styleable.PointView_radio, AppUtil.dp2px(3));
            mPointColor = ta.getColor(R.styleable.PointView_pointColor, Color.YELLOW);
        } finally {
            if (ta != null) {
                ta.recycle();
            }
        }
        initPaint();
    }

    private void initPaint(){
        if (mPaint == null) {
            mPaint = new Paint();
            mPaint.setColor(mPointColor);
            mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mRadio,mRadio,mRadio,mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int resultWidth = 0;
        int resultHeight = 0;
        int specWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int specWidthSize = MeasureSpec.getSize(widthMeasureSpec);
        int specHeightMode = MeasureSpec.getMode(heightMeasureSpec);
        int specHeightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (specWidthMode == MeasureSpec.AT_MOST) {//wrap_content
            resultWidth = (int) (mRadio * 2);
        }else{//match_parent
            resultWidth = specWidthSize;
        }

        if (specHeightMode == MeasureSpec.AT_MOST) {//wrap_content
            resultHeight = (int) (mRadio * 2);
        }else{//match_parent
            resultHeight = specHeightSize;
        }

        setMeasuredDimension(resultWidth,resultHeight);
    }

    //set color
    public void setColor(int color){
        initPaint();
        mPaint.setColor(color);
        invalidate();
    }

    //设置半径
    public void setRadio(int radio){
        if (radio > 0) {
            mRadio = AppUtil.dp2px(radio);
        }
        requestLayout();
    }
}
