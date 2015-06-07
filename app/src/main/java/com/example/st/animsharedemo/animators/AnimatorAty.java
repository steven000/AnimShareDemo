package com.example.st.animsharedemo.animators;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;

import com.example.st.animsharedemo.BaseActivity;
import com.example.st.animsharedemo.R;

public class AnimatorAty extends BaseActivity {



    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.alpha:
                ObjectAnimator alpha = ObjectAnimator.ofFloat(imageView,"alpha",1,0,1);
                alpha.setDuration(during);
                alpha.start();
                break;
            case R.id.translate:
                ObjectAnimator translate = ObjectAnimator.ofFloat(imageView, ImageView.X, 220,0,800,220);
                translate.setDuration(during * 10);
                translate.start();
                break;
            case R.id.three_D:
                ObjectAnimator rotY = ObjectAnimator.ofFloat(imageView,"rotationY",0,360);
                rotY.setDuration(during*4);
                rotY.start();

                break;
            case R.id.turn_off_btn:
                final ValueAnimator animatorX = ValueAnimator.ofFloat(1f,0f);
                animatorX.setDuration(during);
                animatorX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setScaleX((Float) animation.getAnimatedValue());
                    }
                });
                final ValueAnimator animatorY = ValueAnimator.ofFloat(1f,0.01f);
                animatorY.setDuration(during);
                animatorY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setScaleY((Float) animation.getAnimatedValue());
                    }
                });

                animatorX.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        float value = (float) ((ValueAnimator)animation).getAnimatedValue();
                        if(value<.5f) {
                            animatorX.reverse();
                        }else{
                            animatorY.reverse();
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

                final AnimatorSet turnOff = new AnimatorSet();

                turnOff.play(animatorY).before(animatorX);
                turnOff.start();
                break;

            case R.id.forever_btn:

                imageView.animate().rotation(360).setDuration(during).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        imageView.setRotation(0);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();

                break;
            case R.id.twoD_btn:
                ValueAnimator animatorX1 = ValueAnimator.ofFloat(0f);
                animatorX1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setScaleX(animation.getAnimatedFraction());
                    }
                });
                ValueAnimator animatorY1 = ValueAnimator.ofFloat(0f);
                animatorY1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setScaleY(animation.getAnimatedFraction());
                    }
                });


                AnimatorSet turnOff1 = new AnimatorSet();
                turnOff1.setDuration(during*2);
                turnOff1.play(animatorY1).with(animatorX1);
                turnOff1.start();

                break;
        }

    }

}
