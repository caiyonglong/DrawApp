package com.cyl.drawapp.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice11PieChartView extends View {
    Paint paint = new Paint();
    Path path = new Path();
    String[] title = new String[]{"Froyo", "Gingerbread", "Ice Cream Sandwich", "Jelly Bean", "Kitkat", "Lollipop", "Marshmallow"};

    int[] sweep = new int[]{52, 10, 8, 60, 100, 120};
    int[] colors = new int[]{
            Color.parseColor("#FFB300"),
            Color.parseColor("#8E24AA"),
            Color.parseColor("#9E9E9E"),
            Color.parseColor("#388E3C"),
            Color.parseColor("#0091EA"),
            Color.parseColor("#F44336"),
    };


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
        Log.e("TAG", width + "----" + height);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        int centerX = width / 6;
        int centerY = height / 6;
        int radius = centerX *2;
        int diffed = 10;

        int startAngle = -35;
        int spacing = 2;

        paint.setStyle(Paint.Style.FILL); // 填充模式
        for (int i = 0; i < sweep.length - 1; i++) {
            paint.setColor(colors[i]);
            canvas.drawArc(centerX, centerY, centerX + radius, radius + centerY, startAngle, sweep[i], true, paint); // 绘制扇形
            startAngle += sweep[i] + spacing;
        }
        paint.setColor(Color.parseColor("#F44336"));
        canvas.drawArc(centerX - diffed, centerY - diffed, centerX + radius - diffed, centerY + radius - diffed, startAngle, sweep[5], true, paint); // 绘制扇形

    }
}
