package com.tcl.lishanwang.oneshop.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.tcl.lishanwang.oneshop.utils.UIUtils;

/**
 * Created by lishan on 2016/11/22.
 * 14:08
 */

public class AutoScrollViewPager extends ViewPager {

    private AutoScrollTask mAutoScrollTask;

    public AutoScrollViewPager(Context context) {
        this(context, null);
    }

    public AutoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        mAutoScrollTask = new AutoScrollTask();
    }

    public void startScroll(int pagerCount) {
        setCurrentItem(determineCurrentPosition(pagerCount));
        mAutoScrollTask.startScroll();
    }

    public void stopScroll() {
        mAutoScrollTask.stopScroll();
    }

    private int determineCurrentPosition(int paperCount) {
        int currentPosition = getAdapter().getCount() / 2;
        while (currentPosition % paperCount != 0) currentPosition++;
        return currentPosition;
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
            AutoScrollViewPager.this.setCurrentItem(AutoScrollViewPager.this.getCurrentItem() + 1);
            startScroll();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
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
        return super.onTouchEvent(ev);
    }
}
