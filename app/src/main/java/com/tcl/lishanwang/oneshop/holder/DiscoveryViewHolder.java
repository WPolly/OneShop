package com.tcl.lishanwang.oneshop.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.tcl.lishanwang.oneshop.R;

/**
 * Created by xiaoshan on 2016/11/6.
 * 19:07
 */

public class DiscoveryViewHolder extends RecyclerView.ViewHolder {

    public ImageView ivItemDiscovery;

    public DiscoveryViewHolder(View itemView) {
        super(itemView);
        ivItemDiscovery = (ImageView) itemView.findViewById(R.id.iv_item_discovery);
    }
}
