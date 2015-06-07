package com.example.st.animsharedemo.Interpolator.self;

import android.view.animation.Interpolator;


public class MyBounceInterpolator implements  Interpolator {
    
    private float mBounceHeight[]; // maximum height of bounce from earth
    private float mTime[]; // time point that ball arrives earth
    
    public MyBounceInterpolator(){
        this(new float[]{0.1f, 0.01f});
    }

    public MyBounceInterpolator(float bounceHeight[]) {
        init(bounceHeight);
    }
    


    private void init(float bounceHeight[]) {
        if (bounceHeight == null || bounceHeight.length == 0) {
            throw new IllegalArgumentException("input array should not be null or empty");
        }
        
        for (int i=0; i<bounceHeight.length; i++) {
            if (bounceHeight[i] <= 0f)
                throw new IllegalArgumentException("bounce height must > 0");
        }
        
        final int len = bounceHeight.length;
        
        mBounceHeight = new float[len];
        System.arraycopy(bounceHeight, 0, mBounceHeight, 0, len);
        mTime = new float[len+1];
        
        double totalTime = 1.4142;
        for (int i=0; i<len; i++) {
            totalTime += Math.sqrt(8.0*mBounceHeight[i]);
        }
        
        double currentTime = 1.4142;
        for (int i=0; i<len; i++) {
            mTime[i] = (float)(currentTime / totalTime);
            currentTime += Math.sqrt(8.0*mBounceHeight[i]);
        }
        mTime[len] = 1f;
    }
    
    private static float square(float t) {
        return t * t;
    }
    
    private float getCurve(int i, float t) {
        if (i == 0) {
            return square(t/mTime[0]);
        } else {
            return square( (t - (mTime[i-1] + mTime[i])/2f) / mTime[0]) + (1f - mBounceHeight[i-1]);
        }

    }
    
    @Override
    public float getInterpolation(float t) {
        
        for (int i=0; i<mTime.length; i++) {
            
            if (t < mTime[i]) {
                return getCurve(i, t);
            }
        }
        
        return 1f;
    }

}
