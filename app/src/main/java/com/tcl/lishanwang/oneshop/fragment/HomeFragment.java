package com.tcl.lishanwang.oneshop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.adapter.HomeLoopingImgViewPagerAdapter;
import com.tcl.lishanwang.oneshop.utils.UIUtils;
import com.tcl.lishanwang.oneshop.view.AutoScrollViewPager;

/**
 * Created by lishan on 2016/11/4.
 * 16:54
 */

public class HomeFragment extends Fragment {

    private int[] mImgIds =
            {R.mipmap.discovery_hot_topic, R.mipmap.discovery_hot_activity, R.mipmap.discovery_sweepstakes, R.mipmap.discovery_physical_store};
    private AutoScrollViewPager mVpHomeLoopingImg;
    private LinearLayout mLLHomeLoopIndicator;
    private HomeLoopingImgViewPagerAdapter mHomeLoopingImgViewPagerAdapter;

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
        mVpHomeLoopingImg = (AutoScrollViewPager) rootView.findViewById(R.id.vp_home_looping_img);
        mLLHomeLoopIndicator = (LinearLayout) rootView.findViewById(R.id.ll_home_loop_indicator);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mHomeLoopingImgViewPagerAdapter = new HomeLoopingImgViewPagerAdapter(mImgIds);
        mVpHomeLoopingImg.setAdapter(mHomeLoopingImgViewPagerAdapter);
        mVpHomeLoopingImg.addOnPageChangeListener(mOnPageChangeListener);
    }

    @Override
    public void onStart() {
        super.onStart();
        mVpHomeLoopingImg.startScroll(mImgIds.length);
    }

    private void refreshLoopIndicator(int index) {
        mLLHomeLoopIndicator.removeAllViews();
        for (int i = 0; i < mImgIds.length; i++) {
            ImageView ivDot;
            LinearLayout.LayoutParams layoutParams;
            if (i == index) {
                ivDot = new ImageView(getContext());
                layoutParams = new LinearLayout.LayoutParams(UIUtils.dip2Px(15), ViewGroup.LayoutParams.MATCH_PARENT);
                layoutParams.rightMargin = UIUtils.dip2Px(4);
                ivDot.setLayoutParams(layoutParams);
                ivDot.setBackgroundResource(R.drawable.home_dot_pre);
            } else {
                ivDot = new ImageView(getContext());
                layoutParams = new LinearLayout.LayoutParams(UIUtils.dip2Px(7), ViewGroup.LayoutParams.MATCH_PARENT);
                layoutParams.rightMargin = UIUtils.dip2Px(4);
                ivDot.setLayoutParams(layoutParams);
                ivDot.setBackgroundResource(R.drawable.home_dot_nor);
            }
            mLLHomeLoopIndicator.addView(ivDot);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        mVpHomeLoopingImg.stopScroll();
    }

    private ViewPager.SimpleOnPageChangeListener mOnPageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            refreshLoopIndicator(position % mImgIds.length);
        }
    };
}
