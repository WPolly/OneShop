package com.tcl.lishanwang.oneshop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tcl.lishanwang.oneshop.factory.FragmentFactory;

/**
 * Created by lishan on 2016/11/4.
 * 16:46
 */

public class MainContentViewPagerAdapter extends FragmentStatePagerAdapter {

    public MainContentViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.getFragmentInstance(position);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
