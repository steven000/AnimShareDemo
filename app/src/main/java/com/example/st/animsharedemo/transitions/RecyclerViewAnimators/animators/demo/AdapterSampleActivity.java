package com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.st.animsharedemo.R;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.FadeInAnimator;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.adapters.AlphaInAnimationAdapter;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.adapters.ScaleInAnimationAdapter;

import java.util.ArrayList;
import java.util.Arrays;




public class AdapterSampleActivity extends Activity {

    private static String[] data = new String[]{
            "Apple", "Ball", "Camera", "Day", "Egg", "Foo", "Google", "Hello", "Iron", "Japan",
            "Coke", "Dog", "Cat", "Yahoo", "Sony", "Canon", "Fujitsu", "USA", "Nexus", "LINE",
            "Haskell", "C++", "Java", "Go", "Swift", "Objective-c", "Ruby", "PHP", "Bash", "ksh",
            "C", "Groovy", "Kotlin", "Chip", "Japan", "U.S.A", "San Francisco", "Paris", "Tokyo",
            "Silicon Valley", "London", "Spain", "China", "Taiwan", "Asia", "New York", "France",
            "Kyoto", "Android", "Google", "iPhone", "iPad", "iPod", "Wasabeef"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_sample);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new FadeInAnimator());
        MainAdapter adapter = new MainAdapter(this, new ArrayList<>(Arrays.asList(data)));

        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
        ScaleInAnimationAdapter scaleAdapter = new ScaleInAnimationAdapter(alphaAdapter);
        recyclerView.setAdapter(scaleAdapter);
    }
}
