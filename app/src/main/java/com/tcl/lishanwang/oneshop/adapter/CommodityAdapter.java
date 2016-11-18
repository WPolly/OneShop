package com.tcl.lishanwang.oneshop.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.holder.CommodityItemViewHolder;

/**
 * Created by lishan on 2016/11/18.
 * 16:22
 */

public class CommodityAdapter extends RecyclerView.Adapter<CommodityItemViewHolder> {
    @Override
    public CommodityItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_commodity_list, parent, false);
        return new CommodityItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommodityItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
