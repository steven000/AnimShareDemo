package com.example.st.animsharedemo.Interpolator;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import com.example.st.animsharedemo.Interpolator.self.MyAccelerateDecelerateDampingInterpolator;
import com.example.st.animsharedemo.Interpolator.self.MyAccelerateDecelerateInterpolator;
import com.example.st.animsharedemo.Interpolator.self.MyBounceInterpolator;
import com.example.st.animsharedemo.Interpolator.self.MyDampingInterpolator;
import com.example.st.animsharedemo.Interpolator.self.MyEaseInQuartEaseOutCubicInterpolator;
import com.example.st.animsharedemo.Interpolator.self.MyUShapeInterpolator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by snile on 4/22/15.
 */
public class Skill {
    private static List<Map<String,Interpolator>> interploators = new ArrayList<Map<String,Interpolator>>();



    static{
        HashMap<String,Interpolator> map = new HashMap();
        map.put(LinearInterpolator.class.getSimpleName(), new LinearInterpolator());
        interploators.add(map);
        map = new HashMap();
        map.put(AccelerateDecelerateInterpolator.class.getSimpleName(), new AccelerateDecelerateInterpolator());
        interploators.add(map);
        map = new HashMap();
        map.put(DecelerateInterpolator.class.getSimpleName(), new DecelerateInterpolator());
        interploators.add(map);
        map = new HashMap();
        map.put(AccelerateInterpolator.class.getSimpleName(), new AccelerateInterpolator());
        interploators.add(map);
        map = new HashMap();
        map.put(AnticipateInterpolator.class.getSimpleName(), new AnticipateInterpolator());
        interploators.add(map);
        map = new HashMap();
        map.put(AnticipateOvershootInterpolator.class.getSimpleName(), new AnticipateOvershootInterpolator());
        interploators.add(map);
        map = new HashMap();
        map.put(BounceInterpolator.class.getSimpleName(), new BounceInterpolator());
        interploators.add(map);
        map = new HashMap();
        map.put(DecelerateInterpolator.class.getSimpleName(), new DecelerateInterpolator());
        interploators.add(map);
        map = new HashMap();
        map.put(CycleInterpolator.class.getSimpleName(), new CycleInterpolator(0.5f));
        interploators.add(map);


        map = new HashMap();
        map.put(MyAccelerateDecelerateDampingInterpolator.class.getSimpleName(),new MyAccelerateDecelerateDampingInterpolator());
        interploators.add(map);
        map = new HashMap();
        map.put(MyAccelerateDecelerateInterpolator.class.getSimpleName(),new MyAccelerateDecelerateInterpolator());
        interploators.add(map);
        map = new HashMap();
        map.put(MyBounceInterpolator.class.getSimpleName(),new MyBounceInterpolator());
        interploators.add(map);
        map = new HashMap();
        map.put(MyDampingInterpolator.class.getSimpleName(),new MyDampingInterpolator());
        interploators.add(map);
        map = new HashMap();
        map.put(MyEaseInQuartEaseOutCubicInterpolator.class.getSimpleName(),new MyEaseInQuartEaseOutCubicInterpolator());
        interploators.add(map);
        map = new HashMap();
        map.put(MyUShapeInterpolator.class.getSimpleName(),new MyUShapeInterpolator());
        interploators.add(map);

    }

    public static List values(){
        return interploators;
    }

}
