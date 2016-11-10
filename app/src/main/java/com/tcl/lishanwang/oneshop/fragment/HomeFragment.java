package com.tcl.lishanwang.oneshop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.adapter.HomeLoopingImgViewPagerAdapter;

/**
 * Created by lishan on 2016/11/4.
 * 16:54
 */

public class HomeFragment extends Fragment {


    public static HomeFragment newInstance(int someInt) {
        HomeFragment myFragment = new HomeFragment();

        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        myFragment.setArguments(args);

        return myFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ViewPager vpHomeLoopingImg = (ViewPager) rootView.findViewById(R.id.vp_home_looping_img);
        vpHomeLoopingImg.setAdapter(new HomeLoopingImgViewPagerAdapter());
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
