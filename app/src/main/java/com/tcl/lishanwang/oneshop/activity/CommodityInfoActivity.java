package com.tcl.lishanwang.oneshop.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.adapter.CommodityInfoViewPagerAdapter;

public class CommodityInfoActivity extends AppCompatActivity {

    private TabLayout mTlCommodityInfo;
    private ViewPager mVpCommodityInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodity_info);
        mTlCommodityInfo = (TabLayout) findViewById(R.id.tl_commodity_info);
        mVpCommodityInfo = (ViewPager) findViewById(R.id.vp_commodity_info);
        mVpCommodityInfo.setAdapter(new CommodityInfoViewPagerAdapter(getSupportFragmentManager()));
        mTlCommodityInfo.setupWithViewPager(mVpCommodityInfo);
    }
}
