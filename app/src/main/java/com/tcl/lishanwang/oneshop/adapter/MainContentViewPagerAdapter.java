package com.tcl.lishanwang.oneshop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tcl.lishanwang.oneshop.fragment.CategoryFragment;
import com.tcl.lishanwang.oneshop.fragment.DiscoveryFragment;
import com.tcl.lishanwang.oneshop.fragment.HomeFragment;
import com.tcl.lishanwang.oneshop.fragment.ServiceFragment;

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
        switch (position) {
            case 0:
                break;
            case 1:
                return new CategoryFragment();
            case 2:
                return new DiscoveryFragment();
            case 3:
                return new ServiceFragment();
        }
        return new HomeFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }
}
