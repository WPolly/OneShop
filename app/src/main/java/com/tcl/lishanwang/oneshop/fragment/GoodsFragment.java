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
import com.tcl.lishanwang.oneshop.adapter.HomeLoopingImgViewPagerAdapter;
import com.tcl.lishanwang.oneshop.adapter.OfferPackageAdapter;
import com.tcl.lishanwang.oneshop.view.AutoScrollViewPager;

/**
 * Created by lishan on 2016/11/21.
 * 14:23
 */

public class GoodsFragment extends Fragment {

    private AutoScrollViewPager mVpGoodsImg;
    private RecyclerView mRvOfferPackage;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_goods, container, false);
        mVpGoodsImg = (AutoScrollViewPager) rootView.findViewById(R.id.vp_goods_img);
        mRvOfferPackage = (RecyclerView) rootView.findViewById(R.id.rv_offer_package);
        mRvOfferPackage.setAdapter(new OfferPackageAdapter());
        mRvOfferPackage.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mVpGoodsImg.setAdapter(new HomeLoopingImgViewPagerAdapter());
        mVpGoodsImg.startScroll(4);
    }
}
