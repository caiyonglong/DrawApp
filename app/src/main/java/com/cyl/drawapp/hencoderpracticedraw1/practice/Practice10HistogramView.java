package com.cyl.drawapp.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice10HistogramView extends View {
    Paint paint = new Paint();
    Path path = new Path();
    String[] title = new String[]{"Froyo", "GB", "IC S", "JB", "Kitkat", "L", "M"};

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        Log.e("TAG", width + "----" + height);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        int centerX = width / 9;
        int startY = height / 8;


        path.moveTo(centerX, startY);
        path.lineTo(centerX, startY * 6);
        path.lineTo(centerX * 8 + 30, startY * 6);

        canvas.drawPath(path, paint);

        paint.setTextSize(24);
        canvas.drawText("直方图", width / 2 - paint.measureText("直方图") / 2, startY * 8, paint);

        for (int i = 1; i < 8; i++) {
            float top = (float) (Math.random() * startY * 5);
            paint.setColor(Color.parseColor("#8BC34A"));
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(centerX * i + 20, top, centerX * (i + 1), startY * 6, paint);

            paint.setColor(Color.parseColor("#ffffff"));
            paint.setTextSize(36);

            canvas.drawText(title[i - 1], centerX * i + centerX / 2 + 10 - paint.measureText(title[i - 1]) / 2, startY * 6 + 36, paint);
        }
    }
}
