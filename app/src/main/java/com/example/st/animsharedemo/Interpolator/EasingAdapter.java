package com.example.st.animsharedemo.Interpolator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.st.animsharedemo.R;

import java.util.Map;
import java.util.Set;


public class EasingAdapter extends BaseAdapter {

    private Context mContext;
    public EasingAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return Skill.values().size();
    }

    @Override
    public Map<String,Interpolator> getItem(int i) {
        return (Map<String, Interpolator>) Skill.values().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Map<String,Interpolator> o = getItem(i);
        Set<String> set = o.keySet();
        View v = LayoutInflater.from(mContext).inflate(R.layout.inter_item,null);
        TextView tv = (TextView)v.findViewById(R.id.list_item_text);

        for (String name: set){
            tv.setText(name);
            v.setTag(o);
        }


        return v;
    }
}
