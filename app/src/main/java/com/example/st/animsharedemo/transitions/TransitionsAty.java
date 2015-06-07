package com.example.st.animsharedemo.transitions;

import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.st.animsharedemo.BaseActivity;
import com.example.st.animsharedemo.R;

public class TransitionsAty extends BaseActivity {


    boolean centerInParent = true;

    boolean isScale = false;

    @Override
    public void onClick(View v) {
        super.onClick(v);

        RelativeLayout contentView = (RelativeLayout) findViewById(R.id.content);

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        switch (v.getId()) {
            case R.id.alpha:

                TransitionManager.beginDelayedTransition(contentView);
                if (imageView.getVisibility() == View.VISIBLE) {
                    imageView.setVisibility(View.GONE);
                } else {
                    imageView.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.translate:
                TransitionManager.beginDelayedTransition(contentView);
                if (centerInParent) {
                    layoutParams.removeRule(RelativeLayout.CENTER_IN_PARENT);
                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

                } else {
                    layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                    layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
                }
                centerInParent = !centerInParent;
                contentView.requestLayout();

                break;
            case R.id.three_D:
            case R.id.turn_off_btn:
            case R.id.forever_btn:
            case R.id.twoD_btn:


                ChangeBounds changeBounds = new ChangeBounds();
                TransitionManager.beginDelayedTransition(contentView,changeBounds);
                if (isScale) {
                    layoutParams.height = dp2px(200);
                    layoutParams.width = layoutParams.height;
                } else {
                    layoutParams.height = 100;
                    layoutParams.width = 100;
                }
                isScale = !isScale;
                contentView.requestLayout();
                break;
        }
    }


    public int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

}
