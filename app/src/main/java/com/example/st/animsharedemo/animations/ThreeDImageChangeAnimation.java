package com.example.st.animsharedemo.animations;

import android.graphics.Camera;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ThreeDImageChangeAnimation extends Animation {
    private float startAngle, sweepAngle;
    private Camera camera;
    private int width, height;

    private  boolean mReverse = true;

    public ThreeDImageChangeAnimation(float startAngle, float subAngle, boolean mReverse) {
        this.startAngle = startAngle;
        this.sweepAngle = subAngle;
        this.mReverse = mReverse;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        this.height = height;
        this.width = width;
        camera = new Camera();
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {


        camera.save();
        if (mReverse) {
            camera.translate(0, 0, 1000 * interpolatedTime);
        } else {
            camera.translate(0, 0, 1000 * (1 - interpolatedTime));
        }
        camera.rotateY(startAngle + sweepAngle * interpolatedTime);
        camera.getMatrix(t.getMatrix());
        camera.restore();

        t.getMatrix().preTranslate(-width / 2, -height / 2);

        t.getMatrix().postTranslate(width / 2, height / 2);

        super.applyTransformation(interpolatedTime, t);
    }

}
