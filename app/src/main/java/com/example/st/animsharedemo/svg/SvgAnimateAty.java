package com.example.st.animsharedemo.svg;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.st.animsharedemo.R;

public class SvgAnimateAty extends Activity {

    private ViewGroup container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg_animate_aty);


        container = (ViewGroup) findViewById(R.id.container);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < container.getChildCount(); ++i) {
                    animateDrawables(container.getChildAt(i));
                }
            }
        });
    }

    private void animateDrawables(View view) {
        if (!(view instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) view;
        for (final Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            }
        }
    }

}
