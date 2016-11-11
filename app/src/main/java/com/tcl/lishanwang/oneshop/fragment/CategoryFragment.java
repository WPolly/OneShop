package com.tcl.lishanwang.oneshop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.adapter.CategoryRightAdapter;

/**
 * Created by lishan on 2016/11/8.
 * 10:52
 */

public class CategoryFragment extends Fragment {

    private ViewGroup mVgCategoryLeft;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);
        RecyclerView rvCategoryRight = (RecyclerView) rootView.findViewById(R.id.rv_category_right);
        rvCategoryRight.setAdapter(new CategoryRightAdapter());
        mVgCategoryLeft = (ViewGroup) rootView.findViewById(R.id.rg_category_left);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int checkedId = 0;
        if (savedInstanceState != null) checkedId = savedInstanceState.getInt("checked_id", 0);
        ((RadioButton) mVgCategoryLeft.getChildAt(checkedId)).setChecked(true);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        int childCount = mVgCategoryLeft.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RadioButton childAt = (RadioButton) mVgCategoryLeft.getChildAt(i);
            if (childAt.isChecked()) outState.putInt("checked_id", i);
        }
    }
}
