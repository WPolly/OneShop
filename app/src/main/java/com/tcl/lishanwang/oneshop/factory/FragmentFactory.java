package com.tcl.lishanwang.oneshop.factory;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import com.tcl.lishanwang.oneshop.fragment.CategoryFragment;
import com.tcl.lishanwang.oneshop.fragment.DiscoveryFragment;
import com.tcl.lishanwang.oneshop.fragment.HomeFragment;
import com.tcl.lishanwang.oneshop.fragment.ServiceFragment;

/**
 * Created by lishan on 2016/11/11.
 * 15:34
 */

public class FragmentFactory {

    private static SparseArray<Fragment> sCacheFragments = new SparseArray<>();

    public static Fragment getFragmentInstance(int position) {
        Fragment fragment = sCacheFragments.get(position);

        if (fragment != null) {
            return fragment;
        }

        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new CategoryFragment();
                break;
            case 2:
                fragment = new DiscoveryFragment();
                break;
            case 3:
                fragment = new ServiceFragment();
                break;
        }
        sCacheFragments.put(position, fragment);
        return fragment;
    }
}
