package com.tcl.lishanwang.oneshop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tcl.lishanwang.oneshop.fragment.GoodsFragment;

/**
 * Created by xiaoshan on 2016/11/20.
 * 20:01
 */

public class CommodityInfoViewPagerAdapter extends FragmentStatePagerAdapter {

    private String[] titles = {"Goods", "Detail", "Parameter", "Comments"};

    public CommodityInfoViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new GoodsFragment();
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
