package com.tcl.lishanwang.oneshop.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tcl.lishanwang.oneshop.R;

/**
 * Created by lishan on 2016/11/10.
 * 13:53
 */

public class HomeLoopingImgViewPagerAdapter extends PagerAdapter {

    private static final int TOTAL_PAGER_COUNT = 10000;
    private int[] imgIds =
            {R.mipmap.discovery_hot_topic, R.mipmap.discovery_hot_activity, R.mipmap.discovery_sweepstakes, R.mipmap.discovery_physical_store};

    public HomeLoopingImgViewPagerAdapter(int[] imgIds) {
        this.imgIds = imgIds;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int fixedPosition = position % imgIds.length;
        ImageView imageView = new ImageView(container.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(imgIds[fixedPosition]);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return TOTAL_PAGER_COUNT;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
