package com.example.st.animsharedemo.svg;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.st.animsharedemo.R;

public class SvgMapAty extends Activity {
    IntroView mIntroView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg_map_aty);

        mIntroView = (IntroView) findViewById(R.id.intro);
        mIntroView.setSvgResource(R.raw.map_china);
    }


}
