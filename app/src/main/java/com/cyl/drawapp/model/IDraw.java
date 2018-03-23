package com.cyl.drawapp.model;

import android.graphics.Canvas;

/**
 * Created by D22434 on 2017/10/9.
 */

public interface IDraw {
    /**
     * 绘制命令
     *
     * @param canvas 画布对象
     */
    void draw(Canvas canvas);

    /**
     * 撤销命令
     */
    void undo();
}
