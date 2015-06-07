package com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.st.animsharedemo.R;

/**
 * Created by Wasabeef on 2015/03/08.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.btn_animator_sample).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AnimatorSampleActivity.class));
            }
        });

        findViewById(R.id.btn_adapter_sample).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AdapterSampleActivity.class));
            }
        });

    }
}
