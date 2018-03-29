package com.cyl.drawapp.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.cyl.drawapp.R;

/**
 * Matrix.setPolyToPoly(float[] src, int srcIndex,
 * float[] dst, int dstIndex, int pointCount) 用点对点映射的方式设置变换
 * poly 就是「多」的意思。setPolyToPoly() 的作用是通过多点
 * 的映射的方式来直接设置变换。「多点映射」的意思就是把指定的点移动到给出的位置，
 * 从而发生形变。例如：(0, 0) -> (100, 100) 表示把 (0, 0) 位置的像素
 * 移动到 (100, 100) 的位置，这个是单点的映射，单点映射可以实现平移。
 * 而多点的映射，就可以让绘制内容任意地扭曲
 */
public class Practice10MatrixSkewView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    Matrix matrix = new Matrix();

    public Practice10MatrixSkewView(Context context) {
        super(context);
    }

    public Practice10MatrixSkewView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10MatrixSkewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        matrix.reset();
        matrix.postSkew(0, 0.5f);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();

        matrix.reset();
        matrix.postSkew(-0.5f, 0);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
