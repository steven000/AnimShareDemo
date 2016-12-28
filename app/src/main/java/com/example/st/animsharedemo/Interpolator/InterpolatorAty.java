package com.example.st.animsharedemo.Interpolator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SyncAdapterType;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.st.animsharedemo.R;

import java.util.Map;

public class InterpolatorAty extends Activity {

    private ListView mEasingList;
    private EasingAdapter mAdapter;
    private View mTarget;

    private DrawView mHistory;
    private int during = 1000;
    ObjectAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator_aty);
        mEasingList = (ListView)findViewById(R.id.easing_list);
        mAdapter = new EasingAdapter(this);
        mEasingList.setAdapter(mAdapter);
        mTarget = findViewById(R.id.target);
        mHistory = (DrawView)findViewById(R.id.history);
        mEasingList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(animator!=null&&animator.isRunning()){
                    animator.cancel();
                }

                mHistory.clear();
                mTarget.setTranslationX(0);
                mTarget.setTranslationY(0);

                animator = ObjectAnimator.ofFloat(mTarget, "translationY", 0, dipToPixels(InterpolatorAty.this, -(160 - 3)));
                animator.setDuration(during);
                animator.setStartDelay(0);
                Map<String,Interpolator> map = (Map<String, Interpolator>) adapterView.getItemAtPosition(i);
                for ( Interpolator interpolator :map.values()){
                    animator.setInterpolator(interpolator);
                }
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float curTime = animation.getCurrentPlayTime();
                        float during = animation.getDuration();
                        float value = (float) animation.getAnimatedValue();
                        mHistory.drawPoint(curTime,during,value);
                    }
                });

                animator.start();
            }
        });

    }

    public static float dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_interpolator_aty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
