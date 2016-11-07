package com.tcl.lishanwang.oneshop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.adapter.CategoryLeftAdapter;
import com.tcl.lishanwang.oneshop.bean.CategoryMenuItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishan on 2016/11/7.
 * 13:54
 */

public class CategoryFragment extends Fragment {


    private RecyclerView mRvCategoryLeft;
    private List<CategoryMenuItemBean> mCategoryMenuItemBeen;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);
        mRvCategoryLeft = (RecyclerView) rootView.findViewById(R.id.rv_category_left);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCategoryMenuItemBeen = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            CategoryMenuItemBean bean = new CategoryMenuItemBean();
            mCategoryMenuItemBeen.add(bean);
        }
        mRvCategoryLeft.setAdapter(new CategoryLeftAdapter(mCategoryMenuItemBeen));
        mRvCategoryLeft.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
