package com.tcl.lishanwang.oneshop.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.holder.CategoryRightViewHolder;

/**
 * Created by lishan on 2016/11/9.
 * 17:36
 */

public class CategoryRightAdapter extends RecyclerView.Adapter<CategoryRightViewHolder> {
    @Override
    public CategoryRightViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_right, parent, false);
        return new CategoryRightViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryRightViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
