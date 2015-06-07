package com.example.st.animsharedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class BaseActivity extends Activity implements View.OnClickListener{

    public static int[] imageRes = {R.drawable.bg_01,
            R.drawable.bg_02,
            R.drawable.bg_03,
            R.drawable.bg_04,
            R.drawable.bg_05,
            R.drawable.bg_06,
            R.drawable.bg_07,
            R.drawable.bg_08,
            R.drawable.bg_09,
            R.drawable.bg_10,
            R.drawable.bg_11,
            R.drawable.bg_12,
            R.drawable.bg_13,
            R.drawable.bg_14,
            R.drawable.bg_15};


    protected ImageView imageView;
    protected Button alphaBtn, tanBtn, threeDBtn, turnOffBtn, foreverBtn, twoDBtn;
    protected int during = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_base);

        imageView = (ImageView) findViewById(R.id.imv);
        alphaBtn = (Button) findViewById(R.id.alpha);
        tanBtn = (Button) findViewById(R.id.translate);
        threeDBtn = (Button) findViewById(R.id.three_D);
        turnOffBtn = (Button) findViewById(R.id.turn_off_btn);
        foreverBtn = (Button) findViewById(R.id.forever_btn);
        twoDBtn = (Button) findViewById(R.id.twoD_btn);
        alphaBtn.setOnClickListener(this);
        tanBtn.setOnClickListener(this);
        threeDBtn.setOnClickListener(this);
        turnOffBtn.setOnClickListener(this);
        foreverBtn.setOnClickListener(this);
        twoDBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}
