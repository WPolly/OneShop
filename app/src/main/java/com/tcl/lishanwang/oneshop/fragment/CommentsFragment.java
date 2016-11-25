package com.tcl.lishanwang.oneshop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.adapter.CommentsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lishan on 2016/11/23.
 * 15:37
 */

public class CommentsFragment extends Fragment {
    @BindView(R.id.tv_comments_favorable_rate_percent)
    TextView mTvCommentsFavorableRatePercent;
    @BindView(R.id.ctv_comments_all)
    CheckedTextView mCtvCommentsAll;
    @BindView(R.id.ctv_comments_image)
    CheckedTextView mCtvCommentsImage;
    @BindView(R.id.ctv_comments_good)
    CheckedTextView mCtvCommentsGood;
    @BindView(R.id.ctv_comments_average)
    CheckedTextView mCtvCommentsAverage;
    @BindView(R.id.ctv_comments_bad)
    CheckedTextView mCtvCommentsBad;
    @BindView(R.id.rl_comments_filter_container)
    RelativeLayout mRlCommentsFilterContainer;
    @BindView(R.id.rv_comments)
    RecyclerView mRvComments;
    private int mCheckedViewId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_comments, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCheckedViewId = mCtvCommentsAll.getId();
        if (savedInstanceState != null) {
            int checkedId = savedInstanceState.getInt("checked_id", mCtvCommentsAll.getId());
            setCheckedTextViewState(checkedId);
        } else {
            mCtvCommentsAll.setChecked(true);
        }
        mRvComments.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvComments.setAdapter(new CommentsAdapter());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("checked_id", mCheckedViewId);
    }

    @OnClick({R.id.ctv_comments_all, R.id.ctv_comments_image, R.id.ctv_comments_good, R.id.ctv_comments_average, R.id.ctv_comments_bad})
    public void onClick(View view) {
        setCheckedTextViewState(view.getId());
        switch (view.getId()) {
            case R.id.ctv_comments_all:
                break;
            case R.id.ctv_comments_image:
                break;
            case R.id.ctv_comments_good:
                break;
            case R.id.ctv_comments_average:
                break;
            case R.id.ctv_comments_bad:
                break;
        }
    }

    private void setCheckedTextViewState(int viewId) {
        int childCount = mRlCommentsFilterContainer.getChildCount();
        for (int i=0; i<childCount; i++) {
            View childAt = mRlCommentsFilterContainer.getChildAt(i);
            if (childAt instanceof CheckedTextView) {
                mCheckedViewId = viewId;
                if (childAt.getId() == viewId) {
                    ((CheckedTextView) childAt).setChecked(true);
                    continue;
                }
                ((CheckedTextView) childAt).setChecked(false);
            }
        }
    }
}
