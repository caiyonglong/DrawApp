package com.cyl.drawapp;

import android.graphics.Path;

/**
 * Created by D22434 on 2017/10/24.
 */

class PathSegment {
    Path path;
    float width;
    int alpha;

    public PathSegment(Path path) {
        this.path = path;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }


}
