package com.tcl.lishanwang.oneshop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tcl.lishanwang.oneshop.fragment.VoiceMailForAllFragment;
import com.tcl.lishanwang.oneshop.fragment.VoiceMailForKidFragment;

/**
 * Created by lishan on 2017/3/24.
 * 15:25
 */

public class VoiceMailViewPagerAdapter extends FragmentPagerAdapter {

    public VoiceMailViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) return new VoiceMailForAllFragment();
        return new VoiceMailForKidFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }
}
