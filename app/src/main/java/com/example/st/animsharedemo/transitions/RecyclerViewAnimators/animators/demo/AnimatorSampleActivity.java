package com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.demo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.st.animsharedemo.R;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.BaseItemAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.FadeInAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.FadeInDownAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.FadeInLeftAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.FadeInRightAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.FadeInUpAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.FlipInBottomXAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.FlipInLeftYAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.FlipInRightYAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.FlipInTopXAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.LandingAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.OvershootInLeftAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.OvershootInRightAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.ScaleInAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.ScaleInBottomAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.ScaleInLeftAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.ScaleInRightAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.ScaleInTopAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.SlideInDownAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.SlideInLeftAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.SlideInRightAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.SlideInUpAnimator;

import java.util.ArrayList;
import java.util.Arrays;




public class AnimatorSampleActivity extends ActionBarActivity {

    enum Type {
        FadeIn(new FadeInAnimator()),
        FadeInDown(new FadeInDownAnimator()),
        FadeInUp(new FadeInUpAnimator()),
        FadeInLeft(new FadeInLeftAnimator()),
        FadeInRight(new FadeInRightAnimator()),
        Landing(new LandingAnimator()),
        ScaleIn(new ScaleInAnimator()),
        ScaleInTop(new ScaleInTopAnimator()),
        ScaleInBottom(new ScaleInBottomAnimator()),
        ScaleInLeft(new ScaleInLeftAnimator()),
        ScaleInRight(new ScaleInRightAnimator()),
        FlipInTopX(new FlipInTopXAnimator()),
        FlipInBottomX(new FlipInBottomXAnimator()),
        FlipInLeftY(new FlipInLeftYAnimator()),
        FlipInRightY(new FlipInRightYAnimator()),
        SlideInLeft(new SlideInLeftAnimator()),
        SlideInRight(new SlideInRightAnimator()),
        SlideInDown(new SlideInDownAnimator()),
        SlideInUp(new SlideInUpAnimator()),
        OvershootInRight(new OvershootInRightAnimator()),
        OvershootInLeft(new OvershootInLeftAnimator());

        private BaseItemAnimator mAnimator;

        Type(BaseItemAnimator animator) {
            mAnimator = animator;
        }

        public BaseItemAnimator getAnimator() {
            return mAnimator;
        }
    }

    private static String[] data = new String[]{
            "Apple", "Ball", "Camera", "Day", "Egg", "Foo", "Google", "Hello", "Iron", "Japan",
            "Coke", "Dog", "Cat", "Yahoo", "Sony", "Canon", "Fujitsu", "USA", "Nexus", "LINE",
            "Haskell", "C++", "Java", "Go", "Swift", "Objective-c", "Ruby", "PHP", "Bash", "ksh",
            "C", "Groovy", "Kotlin"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_sample);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setItemAnimator(new FadeInAnimator());
        final MainAdapter adapter = new MainAdapter(this, new ArrayList<>(Arrays.asList(data)));
        recyclerView.setAdapter(adapter);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        for (Type type : Type.values()) {
            spinnerAdapter.add(type.name());
        }
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                recyclerView.setItemAnimator(Type.values()[position].getAnimator());
                recyclerView.getItemAnimator().setAddDuration(300);
                recyclerView.getItemAnimator().setRemoveDuration(300);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.add("newly added item", 1);
            }
        });

        findViewById(R.id.del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.remove(1);
            }
        });
    }
}
