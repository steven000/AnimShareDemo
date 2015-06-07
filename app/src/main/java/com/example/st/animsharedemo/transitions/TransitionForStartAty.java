package com.example.st.animsharedemo.transitions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.transition.Explode;
import android.transition.SidePropagation;
import android.transition.Slide;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.st.animsharedemo.R;
import com.example.st.animsharedemo.transitions.RecyclerViewAnimators.animators.adapters.SlideInBottomAnimationAdapter;

public class TransitionForStartAty extends Activity implements AdapterView.OnItemClickListener{


        private GridView mGridView;
        private GridAdapter mAdapter;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // <item name="android:windowContentTransitions">true</item>
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

//            <!— specify enter and exit transitions -->
//            <item name="android:windowEnterTransition">@transition/explode</item>
//            <item name="android:windowExitTransition">@transition/explode</item>
//
//            <!— specify shared element transitions -->
//            <item name="android:windowSharedElementEnterTransition">@transition/change_image_transform</item>
//            <item name="android:windowSharedElementExitTransition">@transition/change_image_transform</item>
            getWindow().setEnterTransition(new Explode());
            getWindow().setExitTransition(new Explode());
            setContentView(R.layout.activity_transition_for_start_aty);

            // Setup the GridView and set the adapter
            mGridView = (GridView) findViewById(R.id.grid);
            mGridView.setOnItemClickListener(this);
            mAdapter = new GridAdapter();
            mGridView.setAdapter(mAdapter);

        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Item item = (Item) adapterView.getItemAtPosition(position);

            // Construct an Intent as normal
            Intent intent = new Intent(this, TransitionForStartAty2.class);
            intent.putExtra(TransitionForStartAty2.EXTRA_PARAM_ID, item.getId());

            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this,

                    new Pair<View, String>(view.findViewById(R.id.imageview_item),
                            TransitionForStartAty2.VIEW_NAME_HEADER_IMAGE),
                    new Pair<View, String>(view.findViewById(R.id.textview_name),
                            TransitionForStartAty2.VIEW_NAME_HEADER_TITLE));

            ActivityCompat.startActivity(this, intent, activityOptions.toBundle());
        }

        /**
         * {@link android.widget.BaseAdapter} which displays items.
         */
        private class GridAdapter extends BaseAdapter {

            @Override
            public int getCount() {
                return Item.ITEMS.length;
            }

            @Override
            public Item getItem(int position) {
                return Item.ITEMS[position];
            }

            @Override
            public long getItemId(int position) {
                return getItem(position).getId();
            }

            @Override
            public View getView(int position, View view, ViewGroup viewGroup) {
                if (view == null) {
                    view = getLayoutInflater().inflate(R.layout.grid_item, viewGroup, false);
                }

                final Item item = getItem(position);

                ImageView image = (ImageView) view.findViewById(R.id.imageview_item);
                image.setImageBitmap(item.getThumbnailUrl(TransitionForStartAty.this));
                TextView name = (TextView) view.findViewById(R.id.textview_name);
                name.setText(getString(R.string.image_header, item.getName(), item.getAuthor()));

                return view;
            }
        }


}
