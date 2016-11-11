package com.tcl.lishanwang.oneshop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.adapter.HomeLoopingImgViewPagerAdapter;
import com.tcl.lishanwang.oneshop.utils.UIUtils;

/**
 * Created by lishan on 2016/11/4.
 * 16:54
 */

public class HomeFragment extends Fragment {

    private int[] mImgIds =
            {R.mipmap.discovery_hot_topic, R.mipmap.discovery_hot_activity, R.mipmap.discovery_sweepstakes, R.mipmap.discovery_physical_store};
    private ViewPager mVpHomeLoopingImg;
    private LinearLayout mLLHomeLoopIndicator;
    private HomeLoopingImgViewPagerAdapter mHomeLoopingImgViewPagerAdapter;
    private AutoScrollTask mAutoScrollTask;

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
        mVpHomeLoopingImg = (ViewPager) rootView.findViewById(R.id.vp_home_looping_img);
        mLLHomeLoopIndicator = (LinearLayout) rootView.findViewById(R.id.ll_home_loop_indicator);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mHomeLoopingImgViewPagerAdapter = new HomeLoopingImgViewPagerAdapter(mImgIds);
        mVpHomeLoopingImg.setAdapter(mHomeLoopingImgViewPagerAdapter);
        mVpHomeLoopingImg.addOnPageChangeListener(mOnPageChangeListener);
        mVpHomeLoopingImg.setOnTouchListener(mVpOnTouchListener);
        mVpHomeLoopingImg.setCurrentItem(determineCurrentPosition());
        refreshLoopIndicator(0);
        mAutoScrollTask = new AutoScrollTask();
        mAutoScrollTask.startScroll();
    }

    private int determineCurrentPosition() {
        int currentPosition = mHomeLoopingImgViewPagerAdapter.getCount() / 2;
        while (currentPosition % mImgIds.length != 0) currentPosition++;
        return currentPosition;
    }

    private void refreshLoopIndicator(int index) {
        mLLHomeLoopIndicator.removeAllViews();
        for (int i = 0; i < mImgIds.length; i++) {
            ImageView ivDot;
            LinearLayout.LayoutParams layoutParams;
            if (i == index) {
                ivDot = new ImageView(getContext());
                layoutParams = new LinearLayout.LayoutParams(UIUtils.dip2Px(15), ViewGroup.LayoutParams.MATCH_PARENT);
                layoutParams.rightMargin = 4;
                ivDot.setLayoutParams(layoutParams);
                ivDot.setBackgroundResource(R.drawable.home_dot_pre);
            } else {
                ivDot = new ImageView(getContext());
                layoutParams = new LinearLayout.LayoutParams(UIUtils.dip2Px(7), ViewGroup.LayoutParams.MATCH_PARENT);
                layoutParams.rightMargin = 4;
                ivDot.setLayoutParams(layoutParams);
                ivDot.setBackgroundResource(R.drawable.home_dot_nor);
            }
            mLLHomeLoopIndicator.addView(ivDot);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mAutoScrollTask.stopScroll();
    }

    private class AutoScrollTask implements Runnable {

        void startScroll() {
            UIUtils.postTaskDelay(this, 3000);
        }

        void stopScroll() {
            UIUtils.removeTask(this);
        }

        @Override
        public void run() {
            mVpHomeLoopingImg.setCurrentItem(mVpHomeLoopingImg.getCurrentItem() + 1);
            startScroll();
        }
    }

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            refreshLoopIndicator(position % mImgIds.length);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private View.OnTouchListener mVpOnTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mAutoScrollTask.stopScroll();
                    break;
                case MotionEvent.ACTION_UP:
                    mAutoScrollTask.startScroll();
                    break;
                case MotionEvent.ACTION_CANCEL:
                    mAutoScrollTask.startScroll();
                    break;
            }
            return false;
        }
    };
}
