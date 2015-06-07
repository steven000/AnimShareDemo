package com.example.st.animsharedemo.transitions;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.FrameLayout;

import com.example.st.animsharedemo.R;
import com.example.st.animsharedemo.transitions.tran.ChangeColor;

public class TransitionCustomSceneAty extends Activity implements View.OnClickListener{

    private static final String STATE_CURRENT_SCENE = "current_scene";


    private Scene[] mScenes;

    private int mCurrentScene;

    private Transition mTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secence_aty);
        FrameLayout container = (FrameLayout) findViewById(R.id.container);
        findViewById(R.id.show_next_scene).setOnClickListener(this);
        if (null != savedInstanceState) {
            mCurrentScene = savedInstanceState.getInt(STATE_CURRENT_SCENE);
        }
        mScenes = new Scene[] {
                Scene.getSceneForLayout(container, R.layout.scene1, this),
                Scene.getSceneForLayout(container, R.layout.scene2, this),
                Scene.getSceneForLayout(container, R.layout.scene3, this),
        };

        mTransition = new ChangeColor();
        mTransition.setDuration(2000);
        TransitionManager.go(mScenes[mCurrentScene % mScenes.length]);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_CURRENT_SCENE, mCurrentScene);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.show_next_scene: {
                mCurrentScene = (mCurrentScene + 1) % mScenes.length;
                TransitionManager.go(mScenes[mCurrentScene], mTransition);
                break;
            }
        }
    }

}
