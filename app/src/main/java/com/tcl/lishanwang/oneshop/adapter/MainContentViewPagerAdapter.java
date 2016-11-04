package com.tcl.lishanwang.oneshop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tcl.lishanwang.oneshop.fragment.HomeFragment;

/**
 * Created by lishan on 2016/11/4.
 * 16:46
 */

public class MainContentViewPagerAdapter extends FragmentPagerAdapter {

    public MainContentViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new HomeFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }
}
