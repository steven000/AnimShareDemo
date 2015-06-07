package com.example.st.animsharedemo.Interpolator.self;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

public class MyAccelerateDecelerateDampingInterpolator implements Interpolator{
    private float mDivideTime =0.5f;
    private float mExtend =0.1f;
    
    private float mAdjustFactor;
    private float mFactor;
    
    private Interpolator mInterpolator1;
    private Interpolator mInterpolator2;
    
    private static float mAdjustTime = 0.3f;
    
//    public static Interpolator getDefaultInterpolator() {
//        return new MyAccelerateDecelerateDampingInterpolator(0.5f, 0.1f);
//    }

    public MyAccelerateDecelerateDampingInterpolator(){
        this(0.5f, 0.1f);
    }

    public MyAccelerateDecelerateDampingInterpolator(float divideTime, float extend) {
        mDivideTime = divideTime;
        mExtend = extend;
        
        mInterpolator1 = new AccelerateDecelerateInterpolator();
        mInterpolator2 = new MyDampingInterpolator();
        
        mAdjustFactor = 0.143407f; // if (t == 0.143407f) LeDampingInterpolator() reach its max value
        
        mFactor = (1 - mAdjustFactor) / (1 - mDivideTime);
    }
    
    @Override
    public float getInterpolation(float t) {
        if (t < mDivideTime) {
            return (1f + mExtend) * mInterpolator1.getInterpolation(t/mDivideTime);
        } else {
            return mExtend * mInterpolator2.getInterpolation((t-mDivideTime)*mFactor + mAdjustFactor) + 1f;
        }
    }

}
