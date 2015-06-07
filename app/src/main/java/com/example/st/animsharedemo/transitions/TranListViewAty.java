package com.example.st.animsharedemo.transitions;

import android.app.Activity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.st.animsharedemo.R;

public class TranListViewAty extends Activity {

    private static String[] data = new String[]{
            "Apple", "Ball", "Camera", "Day", "Egg", "Foo", "Google", "Hello", "Iron", "Japan",
            "Coke", "Dog", "Cat", "Yahoo", "Sony", "Canon", "Fujitsu", "USA", "Nexus", "LINE",
            "Haskell", "C++", "Java", "Go", "Swift", "Objective-c", "Ruby", "PHP", "Bash", "ksh",
            "C", "Groovy", "Kotlin", "Chip", "Japan", "U.S.A", "San Francisco", "Paris", "Tokyo",
            "Silicon Valley", "London", "Spain", "China", "Taiwan", "Asia", "New York", "France",
            "Kyoto", "Android", "Google", "iPhone", "iPad", "iPod", "Wasabeef"
    };

    MyAdapter myAdapter = new MyAdapter();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tran_list_view_aty);

        listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(myAdapter);
    }


    boolean showCheckbox = false;

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public String getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;

            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.list_item,null);
                holder = new ViewHolder();
                holder.checkBox = (CheckBox) convertView.findViewById(R.id.checkbox);
                holder.textView = (TextView) convertView.findViewById(R.id.title);

                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }

            holder.textView.setText(getItem(position));
            holder.checkBox.setVisibility(showCheckbox?View.VISIBLE:View.GONE);

            return convertView;
        }



        class ViewHolder{
            CheckBox checkBox;
            TextView textView;
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tran_list_view_aty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            showCheckbox = !showCheckbox;
            TransitionManager.beginDelayedTransition(listView);
            myAdapter.notifyDataSetChanged();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
