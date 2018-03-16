package com.fyx.leon.fyx_leon.utils.bezierutils;

import android.graphics.PointF;

/**
 * @author : Tanck
 * @Description : TODO
 * @date 10/13/2015
 */
public class HPoint {
    public float x;
    public float y;
    public PointF left = new PointF();
    public PointF right = new PointF();

    public void setY(float y) {
        this.y = y;
        left.y = y;
        right.y = y;
    }

    public void adjustAllX(float offset) {
        this.x += offset;
        left.x += offset;
        right.x += offset;
    }

    public void adjustAllY(float offset) {
        this.y += offset;
        left.y += offset;
        right.y += offset;
    }

    public void adjustAllXY(float x, float y) {
        adjustAllX(x);
        adjustAllY(y);
    }
}