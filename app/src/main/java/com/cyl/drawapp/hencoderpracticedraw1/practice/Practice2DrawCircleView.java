package com.cyl.drawapp.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {
    Paint mPaint = new Paint();

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(5);

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(200, 200, 100, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(500, 200, 100, mPaint);

        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(200, 500, 100, mPaint);


        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(40);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(500, 500, 100, mPaint);
    }
}
