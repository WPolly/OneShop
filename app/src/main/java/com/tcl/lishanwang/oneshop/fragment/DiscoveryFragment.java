package com.tcl.lishanwang.oneshop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.adapter.DiscoveryAdapter;
import com.tcl.lishanwang.oneshop.utils.UIUtils;

/**
 * Created by lishan on 2016/11/6.
 * 18:50
 */

public class DiscoveryFragment extends Fragment {

    private SwipeRefreshLayout mSrDiscovery;
    private RecyclerView mRvDiscovery;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_discovery, container, false);
        mSrDiscovery = (SwipeRefreshLayout) rootView.findViewById(R.id.sr_discovery);
        mRvDiscovery = (RecyclerView) rootView.findViewById(R.id.rv_discovery);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRvDiscovery.setAdapter(new DiscoveryAdapter());
        mRvDiscovery.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mSrDiscovery.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                UIUtils.postTaskDelay(new Runnable() {
                    @Override
                    public void run() {
                        mSrDiscovery.setRefreshing(false);
                    }
                }, 2000);
            }
        });
        mSrDiscovery.setProgressViewEndTarget(true, UIUtils.dip2Px(100));
    }
}
