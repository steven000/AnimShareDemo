package com.example.st.animsharedemo.Interpolator.self;

import android.view.animation.Interpolator;

public class MyEaseInQuartEaseOutCubicInterpolator implements Interpolator {
    private float divide, height;
    
    public MyEaseInQuartEaseOutCubicInterpolator() {
        this(0.2f, 0.3f);
    }

    public MyEaseInQuartEaseOutCubicInterpolator(float divide, float height) {
        this.divide = divide;
        this.height = height;
    }

    @Override
    public float getInterpolation(float t) {

        if (t < divide)
            return EasingEquations.easeInQuart(t, 0, height, divide);
        else 
            return EasingEquations.easeOutCubic(t-divide, height, 1 - height, 1 - divide);
    }
}
