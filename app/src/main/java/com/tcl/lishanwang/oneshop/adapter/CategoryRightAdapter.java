package com.tcl.lishanwang.oneshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.activity.CommodityListActivity;
import com.tcl.lishanwang.oneshop.holder.CategoryRightViewHolder;

/**
 * Created by lishan on 2016/11/9.
 * 17:36
 */

public class CategoryRightAdapter extends RecyclerView.Adapter<CategoryRightViewHolder> implements View.OnClickListener {
    @Override
    public CategoryRightViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_right, parent, false);
        itemView.setOnClickListener(this);
        return new CategoryRightViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryRightViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, CommodityListActivity.class);
        context.startActivity(intent);
    }
}
