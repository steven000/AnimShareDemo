package com.example.st.animsharedemo.Interpolator.self;

import android.view.animation.Interpolator;

// refer to http://isux.tencent.com/animation-factor.html

public class MyAccelerateDecelerateInterpolator implements Interpolator{
    private final float mFactor;
    private final float mValue;
    
    public static Interpolator getAccelerateDecelerateInterpolatorC() {
        Interpolator interpolator = new MyAccelerateDecelerateInterpolator(0.2f, 0.3f);
        return interpolator;
    }
    
    public static Interpolator getAccelerateDecelerateInterpolatorD() {
        Interpolator interpolator = new MyAccelerateDecelerateInterpolator(0.8f, 0.7f);
        return interpolator;
    }
    
    public MyAccelerateDecelerateInterpolator() {
        mFactor = 0.5f;
        mValue = 0.5f;
    }
    
    // Callers must make sure factor is not 0.0f or 1.0f
    public MyAccelerateDecelerateInterpolator(float factor, float value) {
        mFactor = factor;
        mValue = value;
    }
    

    
    private static double scale() {
        return Math.PI / (Math.PI - 2.0);
    }
    
    // angle of accelerate period
    private double a(float t) {
        return Math.PI * (1.0f + t/(2.0f * mFactor));
    }
    
    // angle of decelerate period
    private double d(float t) {
        return Math.PI * (t + 1.0f - 2.0f*mFactor) / (2.0f * (1.0f-mFactor));
    }
    
    private double p1() {
        return 2f * mFactor / Math.PI;
    }
    
    private double p2() {
        return 2f * (1 - mFactor) / Math.PI;
    }
    
    
    @Override
    public float getInterpolation(float t) {
        float output = 1f;
        
        if (t <= mFactor) {
            output = (float) ( scale() * (t + p1() * Math.sin( a(t) ) )) * mValue/mFactor;
        } else if (t <= 1.0f) {
            output = (float) ((t - mFactor + p2() * (Math.sin( d(t) ) - 1) ) * scale() * (1-mValue)/(1-mFactor)) + mValue;
        }
        
        return output;
    }
    
}
