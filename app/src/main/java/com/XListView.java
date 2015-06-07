package com;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by snile on 4/28/15.
 */
public class XListView extends ListView implements AbsListView.OnScrollListener{

    public XListView(Context context) {
        super(context);
    }

    public XListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private View pinnedView;
    private boolean pinned =false;


    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);

        if(pinned){
            drawChild(canvas,pinnedView,getDrawingTime());
        }

    }



    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
