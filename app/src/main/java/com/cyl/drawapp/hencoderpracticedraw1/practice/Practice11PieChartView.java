package com.cyl.drawapp.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice11PieChartView extends View {
    Paint paint = new Paint();
    Path path = new Path();
    String[] title = new String[]{"Froyo", "Gingerbread", "Ice Cream Sandwich", "Jelly Bean", "Kitkat", "Lollipop", "Marshmallow"};

    int[] sweep = new int[]{0, 8, 5, 57, 100, 125, 55};

    int[] colors = new int[]{
            Color.parseColor("#8E24AA"),
            Color.parseColor("#8E24AA"),
            Color.parseColor("#9E9E9E"),
            Color.parseColor("#388E3C"),
            Color.parseColor("#0091EA"),
            Color.parseColor("#F44336"),
            Color.parseColor("#FFB300")
    };

    int offset = 20;
    int startAngle = 0;
    int spacing = 2;
    float startX, startY, centerX, centerY, centerAngle = 0;
    float cosAngle, sinAngle;

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        int left = width / 5;
        int top = height / 6;
        int radius = height / 3;
        RectF rectF = new RectF(left, top, left + radius * 2, radius * 2 + top);
        RectF singleRectF = new RectF(left - offset, top - offset, left + radius * 2 - offset, radius * 2 + top - offset);
        startAngle = 0;

        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        for (int i = 0; i < sweep.length; i++) {
            Log.e("TAG", i + "--" + startX + "---" + startY);
            //绘制扇形
            paint.setColor(colors[i]);
            paint.setStyle(Paint.Style.FILL); // 填充模式

            if (i == 5) {
                //突出的扇形
                centerX = left + radius - offset;
                centerY = top + radius - offset;
                startAngle -= spacing;
                canvas.drawArc(singleRectF
                        , startAngle, sweep[i], true, paint); // 绘制扇形
            } else {
                centerX = left + radius;
                centerY = top + radius;
                canvas.drawArc(rectF, startAngle, sweep[i], true, paint); // 绘制扇形
            }
            centerAngle = -(startAngle + sweep[i] / 2);
            sinAngle = (float) Math.sin(centerAngle * 1.0 / 180 * Math.PI);
            cosAngle = (float) Math.cos(centerAngle * 1.0 / 180 * Math.PI);
            startY = centerY - (sinAngle * radius);
            startX = (cosAngle * radius) + centerX;

            //绘制直线和文字
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.WHITE);
            path.moveTo(startX, startY);
            path.rLineTo(cosAngle * 40, -sinAngle * 40);
            path.rLineTo(cosAngle >= 0 ? 80 : -80, 0);
            canvas.drawPath(path, paint);
            paint.setTextSize(18);
            canvas.drawText(title[i], cosAngle >= 0 ?
                            startX + cosAngle * 40 + 90 :
                            startX + cosAngle * 40 - 90 - paint.measureText(title[i]),
                    startY - sinAngle * 40, paint);
            startAngle += sweep[i] + spacing;
        }
        paint.setTextSize(40);
        paint.setColor(Color.WHITE);
        canvas.drawText("饼图", centerX - paint.measureText("饼图") / 2, centerY + radius + 40, paint);
    }


}
