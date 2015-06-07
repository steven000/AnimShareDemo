

package com.example.st.animsharedemo.transitions;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.example.st.animsharedemo.R;


public class Item {

    public static Item[] ITEMS = new Item[] {
            new Item("Flying in the Light", "Romain Guy", R.drawable.bg_01),
            new Item("Caterpillar", "Romain Guy", R.drawable.bg_02),
            new Item("Look Me in the Eye", "Romain Guy", R.drawable.bg_03),
            new Item("Flamingo", "Romain Guy", R.drawable.bg_04),
            new Item("Rainbow", "Romain Guy", R.drawable.bg_05),
            new Item("Over there", "Romain Guy", R.drawable.bg_06),
            new Item("Jelly Fish 2", "Romain Guy", R.drawable.bg_07),
            new Item("Lone Pine Sunset", "Romain Guy", R.drawable.bg_08),
    };

    public static Item getItem(int id) {
        for (Item item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    private final String mName;
    private final String mAuthor;
    private final int mFileName;

    Item(String name, String author, int fileName) {
        mName = name;
        mAuthor = author;
        mFileName = fileName;
    }

    public int getId() {
        return mName.hashCode() ;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getName() {
        return mName;
    }

    public Bitmap getPhotoUrl(Context context) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize=2;
        return BitmapFactory.decodeResource(context.getResources(),mFileName,options);
    }

    public Bitmap getThumbnailUrl(Context context) {


        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize=4;
        return BitmapFactory.decodeResource(context.getResources(),mFileName,options);
    }

}
