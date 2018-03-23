package com.cyl.drawapp.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by D22434 on 2017/10/9.
 */

public class DrawCanvas extends SurfaceView implements SurfaceHolder.Callback {

    public boolean isDrawing, isRunning;
    private Bitmap mBitmap;
    private DrawInvoker mInvoker;
    private DrawThread mThread;

    public DrawCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInvoker = new DrawInvoker();
        mThread = new DrawThread();

        getHolder().addCallback(this);
    }

    public void add(DrawPath path) {
        mInvoker.add(path);
    }

    public boolean canRedo() {
        return mInvoker.canRedo();
    }

    public boolean canUndo() {
        return mInvoker.canUndo();
    }

    public void undo() {
        isDrawing = true;
        mInvoker.undo();
    }

    public void redo() {
        isDrawing = true;
        mInvoker.redo();
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        isRunning = true;
        mThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        mBitmap = Bitmap.createBitmap(i1, i2, Bitmap.Config.RGB_565);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        boolean retry = true;
        isRunning = false;
        while (retry) {
            try {
                mThread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class DrawThread extends Thread {
        @Override
        public void run() {
            super.run();
            Canvas canvas = null;
            while (isRunning) {
                if (isDrawing) {
                    try {
                        canvas = getHolder().lockCanvas(null);
                        if (mBitmap == null) {
                            mBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                        }
                        Canvas c = new Canvas(mBitmap);
                        c.drawColor(0, PorterDuff.Mode.CLEAR);

                        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                        mInvoker.execute(c);
                        canvas.drawBitmap(mBitmap, 0, 0, null);
                    } finally {
                        getHolder().unlockCanvasAndPost(canvas);
                    }
                    isDrawing = false;
                }
            }
        }
    }
}
