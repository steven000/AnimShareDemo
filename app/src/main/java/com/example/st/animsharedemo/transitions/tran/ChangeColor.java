

package com.example.st.animsharedemo.transitions.tran;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;

public class ChangeColor extends Transition {

    private static final String PROPNAME_BACKGROUND = "customtransition:change_color:background";

    private void captureValues(TransitionValues values) {
        values.values.put(PROPNAME_BACKGROUND, values.view.getBackground());
    }

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot,
                                   TransitionValues startValues, TransitionValues endValues) {
        if (null == startValues || null == endValues) {
            return null;
        }
        final View view = endValues.view;

        Drawable startBackground = (Drawable) startValues.values.get(PROPNAME_BACKGROUND);
        Drawable endBackground = (Drawable) endValues.values.get(PROPNAME_BACKGROUND);


        if (startBackground instanceof ColorDrawable && endBackground instanceof ColorDrawable) {
            ColorDrawable startColor = (ColorDrawable) startBackground;
            ColorDrawable endColor = (ColorDrawable) endBackground;
            if (startColor.getColor() != endColor.getColor()) {
                ValueAnimator animator = ValueAnimator.ofObject(new ArgbEvaluator(),
                        startColor.getColor(), endColor.getColor());
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Object value = animation.getAnimatedValue();
                        if (null != value) {
                            view.setBackgroundColor((Integer) value);
                        }
                    }
                });
                return animator;
            }
        }
        return null;
    }

}
