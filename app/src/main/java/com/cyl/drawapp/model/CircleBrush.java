package com.cyl.drawapp.model;

import android.graphics.Path;

/**
 * Created by D22434 on 2017/10/9.
 */

public class CircleBrush implements IBrush {
    @Override
    public void down(Path path, float x, float y) {
    }

    @Override
    public void move(Path path, float x, float y) {
        path.addCircle(x, y, 10, Path.Direction.CW);
    }

    @Override
    public void up(Path path, float x, float y) {

    }
}
