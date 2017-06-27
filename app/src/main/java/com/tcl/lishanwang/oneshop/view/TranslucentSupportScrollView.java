package com.tcl.lishanwang.oneshop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by lishan on 2017/6/27.
 * 13:58
 */

public class TranslucentSupportScrollView extends ScrollView {

    private OnTranslucentScrollListener mListener;

    public TranslucentSupportScrollView(Context context) {
        super(context);
    }

    public TranslucentSupportScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        int widthPixels = getContext().getResources().getDisplayMetrics().widthPixels;
        float ratio = t / (widthPixels / 2.0f);
        ratio = ratio < 0 ? 0 : ratio;
        ratio = ratio > 1 ? 1 : ratio;
        if (mListener != null) mListener.onScroll(ratio);
    }

    public void setListener(OnTranslucentScrollListener listener) {
        mListener = listener;
    }
}
