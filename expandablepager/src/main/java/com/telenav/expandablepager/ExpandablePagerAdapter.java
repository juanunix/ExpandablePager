package com.telenav.expandablepager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Adapter for ExpandablePager. Extend this class and pass it to your pager via {@link ExpandablePager#setAdapter(ExpandablePagerAdapter)}
 */
public class ExpandablePagerAdapter<T> extends PagerAdapter {

    protected List<T> items;

    public ExpandablePagerAdapter(List<T> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * Attaches the view to the container and gives it a specific id. Return the result of this method when overriding {@link #instantiateItem(ViewGroup, int)}
     * @param container view container
     * @param v inflated view
     * @param position position of the view in the adapter
     * @return inflated view
     */
    protected View attach(ViewGroup container, View v, int position) {
        v.setId(ExpandablePager.INTERNAL_PAGE_ID + position);
        container.addView(v);
        return v;
    }
}