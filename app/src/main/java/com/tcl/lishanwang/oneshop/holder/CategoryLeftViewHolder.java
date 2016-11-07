package com.tcl.lishanwang.oneshop.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tcl.lishanwang.oneshop.R;

/**
 * Created by lishan on 2016/11/7.
 * 14:14
 */

public class CategoryLeftViewHolder extends RecyclerView.ViewHolder {

    public TextView mTvCategoryLeftItem;

    public CategoryLeftViewHolder(View itemView) {
        super(itemView);
        mTvCategoryLeftItem = (TextView) itemView.findViewById(R.id.tv_category_left_item);
    }
}
