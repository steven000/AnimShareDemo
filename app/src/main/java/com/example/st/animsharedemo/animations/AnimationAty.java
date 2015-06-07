package com.example.st.animsharedemo.animations;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.example.st.animsharedemo.BaseActivity;
import com.example.st.animsharedemo.R;

public class AnimationAty extends BaseActivity implements  AnimationListener {


    Animation alpha, translate1, translate2, translate3, translate4, scale, scale1, scale2, scale_in, scale_out,
            rotate;
    Animation threeAnimationOut, threeAnimationIn;
    private int index = 0;
    private boolean in = false, out = true;




    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.alpha:
                alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
                alpha.setDuration(during*2);
                imageView.startAnimation(alpha);
                break;
            case R.id.translate:
                translate1 =
                        new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1f,
                                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
                translate1.setDuration(during);
                translate1.setFillAfter(true);
                translate1.setAnimationListener(this);
                imageView.startAnimation(translate1);
                break;
            case R.id.three_D:
                threeAnimationOut = new ThreeDImageChangeAnimation(0, 90, out);
                threeAnimationOut.setDuration(during);
                threeAnimationOut.setAnimationListener(this);
                threeAnimationOut.setFillAfter(true);
                imageView.startAnimation(threeAnimationOut);
                break;
            case R.id.turn_off_btn:
                scale1 =
                        new ScaleAnimation(1, 1f, 1, 0.01f, Animation.RELATIVE_TO_SELF, 0.5f,
                                Animation.RELATIVE_TO_SELF, 0.5f);
                scale1.setDuration(during);
                scale1.setFillAfter(true);
                scale1.setAnimationListener(this);
                imageView.startAnimation(scale1);
                break;
            case R.id.forever_btn:
                rotate =
                        new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(during);
                rotate.setRepeatCount(RotateAnimation.INFINITE);
                rotate.setRepeatMode(RotateAnimation.RESTART);
                rotate.setInterpolator(this, android.R.anim.linear_interpolator);
                imageView.startAnimation(rotate);
                break;
            case R.id.twoD_btn:
                scale_out =
                        new ScaleAnimation(1, 0f, 1, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                                0.5f);
                scale_out.setDuration(during);
                scale_out.setAnimationListener(this);
                imageView.startAnimation(scale_out);
                break;
            default:
                break;
        }

    }

    @Override
    public void onAnimationEnd(Animation arg0) {
        if (arg0 == translate1) {
            translate2 =
                    new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 1f,
                            Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1f);
            translate2.setDuration(during);
            translate2.setFillAfter(true);
            translate2.setAnimationListener(this);
            imageView.startAnimation(translate2);
        } else if (arg0 == translate2) {
            translate3 =
                    new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0f,
                            Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 1f);
            translate3.setDuration(during);
            translate3.setAnimationListener(this);
            translate3.setFillAfter(true);
            imageView.startAnimation(translate3);
        } else if (arg0 == translate3) {
            translate4 =
                    new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f,
                            Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0f);
            translate4.setDuration(during);
            translate4.setFillAfter(true);
            translate4.setAnimationListener(this);
            imageView.startAnimation(translate4);
        } else if (arg0 == scale1) {
            scale2 =
                    new ScaleAnimation(1, 0f, 0.01f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                            0.5f);
            scale2.setDuration(during);
            scale2.setFillAfter(true);
            imageView.startAnimation(scale2);
        } else if (arg0 == rotate) {
            imageView.startAnimation(rotate);
        } else if (arg0 == scale_out) {
            scale_in =
                    new ScaleAnimation(0, 1f, 0, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            imageView.setImageResource(imageRes[(++index)
                    % imageRes.length]);
            scale_in.setDuration(during);
            imageView.startAnimation(scale_in);
        } else if (arg0 == threeAnimationOut) {
            imageView.setImageResource(imageRes[(++index)
                    % imageRes.length]);
            threeAnimationIn = new ThreeDImageChangeAnimation(-90, 90, in);
            threeAnimationIn.setDuration(during);
            imageView.startAnimation(threeAnimationIn);
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }


}
