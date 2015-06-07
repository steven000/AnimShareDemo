package com.example.st.animsharedemo;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.st.animsharedemo.Interpolator.self.MyAccelerateDecelerateInterpolator;

import java.util.ArrayList;
import java.util.List;


public class SearchAty extends Activity implements AbsListView.OnScrollListener {

    private ListView listView;
    private View head;
    private View search, pinned;
    private View target;

    private List<String> values;
    private static AccelerateDecelerateInterpolator sSmoothInterpolator = new AccelerateDecelerateInterpolator();


    private int mActionBarHeight;
    private int mMinHeaderHeight;
    private int mHeaderHeight;
    private int mMinHeaderTranslation;

    private RectF mRect1 = new RectF();
    private RectF mRect2 = new RectF();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHeaderHeight = getResources().getDimensionPixelSize(R.dimen.header_height);
        mMinHeaderHeight = mHeaderHeight - getResources().getDimensionPixelSize(R.dimen.min_header_height);

        mMinHeaderTranslation = -mMinHeaderHeight + getActionBarHeight();
        setContentView(R.layout.activity_search_aty);
        listView = (ListView) findViewById(R.id.list);
        head = findViewById(R.id.head);
        search = findViewById(R.id.search);
        pinned = findViewById(R.id.pinnedTitle);
        target = findViewById(R.id.target);


        createValue();
        listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, values));
        View placeHoldView = getLayoutInflater().inflate(R.layout.search_place_hold, null);
        listView.addHeaderView(placeHoldView);
        listView.setOnScrollListener(this);

        getActionBar().setBackgroundDrawable(null);

    }

    private void createValue() {
        values = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            values.add(i + "  item");
        }
    }

    ValueAnimator animator;


    @Override
    public void onScrollStateChanged(final AbsListView view, int scrollState) {
        if (SCROLL_STATE_IDLE == scrollState) {

            if (animator != null && animator.isRunning()) {
                animator.cancel();
                animator = null;
            }


            float currentTranslationY = ViewCompat.getTranslationY(head);

            if (currentTranslationY > mMinHeaderTranslation) {


                float startOffest = currentTranslationY;
                float endOffset;


                if (currentTranslationY > mMinHeaderTranslation / 2) {
                    // 向下
                    endOffset = 0;
                } else {
                    // 向上
                    endOffset = mMinHeaderTranslation;
                }

                int during = (int)(2000f/Math.abs(mMinHeaderHeight)*Math.abs(endOffset - startOffest));

                animator = ValueAnimator.ofInt((int)startOffest,(int)endOffset);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        ((ListView)view).setSelectionFromTop(0,(int)animation.getAnimatedValue());
                    }
                });
                animator.setDuration(during);
                animator.setInterpolator(new MyAccelerateDecelerateInterpolator());
                animator.start();

            } else {
                // not to do
            }
        }else{
            if (animator != null && animator.isRunning()) {
                animator.cancel();
                animator = null;
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        scrollHead();
    }

    private  void scrollHead(){
        int scrollY = getScrollY(listView);
        ViewCompat.setTranslationY(head, Math.max(-scrollY, mMinHeaderTranslation));
        float ratio = clamp(ViewCompat.getTranslationY(head) / mMinHeaderTranslation, 0.0f, 1.0f);
        ViewCompat.setAlpha(target,ratio);
        ViewCompat.setAlpha(search,(1-ratio));
        interpolate(search, target, sSmoothInterpolator.getInterpolation(ratio));
    }

    private RectF getOnScreenRect(RectF rect, View view) {
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        return rect;
    }

    private void interpolate(View view1, View view2, float interpolation) {

        getOnScreenRect(mRect1, view1);
        getOnScreenRect(mRect2, view2);
        float scaleX = 1.0F + interpolation * (mRect2.width() / mRect1.width() - 1.0F);
        float scaleY = 1.0F + interpolation * (mRect2.height() / mRect1.height() - 1.0F);
        float translationX = 0.5F * (interpolation * (mRect2.left + mRect2.right - mRect1.left - mRect1.right));
        float translationY = 0.5F * (interpolation * (mRect2.top + mRect2.bottom - mRect1.top - mRect1.bottom));

        ViewCompat.setTranslationX(view1, translationX);
        ViewCompat.setTranslationY(view1, translationY - ViewCompat.getTranslationY(head));
        ViewCompat.setScaleX(view1, scaleX);
        ViewCompat.setScaleY(view1, scaleY);
    }


    public int getScrollY(AbsListView view) {
        View c = view.getChildAt(0);
        if (c == null) {
            return 0;
        }

        int firstVisiblePosition = view.getFirstVisiblePosition();
        int top = c.getTop();

        int headerHeight = 0;
        if (firstVisiblePosition >= 1) {
            headerHeight = mHeaderHeight;
        }

        return -top + firstVisiblePosition * c.getHeight() + headerHeight;
    }

    public static float clamp(float value, float max, float min) {
        return Math.max(Math.min(value, min), max);
    }


    private TypedValue mTypedValue = new TypedValue();

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public int getActionBarHeight() {
        if (mActionBarHeight != 0) {
            return mActionBarHeight;
        }

        getTheme().resolveAttribute(android.R.attr.actionBarSize, mTypedValue, true);

        mActionBarHeight = TypedValue.complexToDimensionPixelSize(mTypedValue.data, getResources().getDisplayMetrics());

        return mActionBarHeight;
    }
}
