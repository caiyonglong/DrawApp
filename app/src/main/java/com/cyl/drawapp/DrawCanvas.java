package com.cyl.drawapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by D22434 on 2017/10/18.
 */

public class DrawCanvas extends View {

    Paint mPaint;
    Path mPath;
    float tempX, tempY;
    float downX, downY;


    public DrawCanvas(Context context) {
        super(context, null);
    }

    public DrawCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawCanvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(10);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath = new Path();
        mPath.moveTo(downX, downY);
        Log.e("TAG", downX + "-" + downY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                downY = event.getY();
                mPaint.setStrokeWidth(event.getPressure() * 1000);
                Log.e("TAG", event.getPressure() + "-" +
                        event.getSize());
                mPath.moveTo(downX, downY);
                invalidate();
                tempX = downX;
                tempY = downY;
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.quadTo(tempX, tempY, event.getX(), event.getY());

                Log.e("TAG", event.getPressure() + "-" +
                        event.getSize());
                mPaint.setStrokeWidth(event.getPressure() * 30);
                invalidate();
                tempX = event.getX();
                tempY = event.getY();
                break;
        }
        return true;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        if (mPath != null)
            canvas.drawPath(mPath, mPaint);
        canvas.restore();

        if (isClear) {
            Paint p = new Paint();
            //清屏
            canvas.drawColor(Color.WHITE);
            isClear = false;
        }

    }

    boolean isClear = false;

    public void clearCanvas() {
        isClear = true;
        invalidate();
    }
}
