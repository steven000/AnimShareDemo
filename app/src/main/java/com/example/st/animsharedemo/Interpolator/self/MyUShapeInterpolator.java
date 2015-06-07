package com.example.st.animsharedemo.Interpolator.self;

import android.view.animation.Interpolator;
import android.graphics.Path;
import android.view.animation.PathInterpolator;

public class MyUShapeInterpolator implements Interpolator {
	private Interpolator mHeadInterpolator;
	private Interpolator mRearInterpolator;

	public MyUShapeInterpolator() {
		Path path = new Path();
		path.moveTo(0.0f, 0.0f);
		path.cubicTo(1 / 3f, 0, 0, 1, 1, 1);
		mHeadInterpolator = new PathInterpolator(path);
		path.reset();
		path.moveTo(0.0f, 0.0f);
		path.cubicTo(1, 0, 2 / 3f, 1, 1, 1);
		mRearInterpolator = new PathInterpolator(path);
	}

	@Override
	public float getInterpolation(float t) {
		if (t < 0.5f) {
			return mHeadInterpolator.getInterpolation(2f * t);
		} else {
			return 1 - mRearInterpolator.getInterpolation(2f * (t - 0.5f));
		}
	}

}
