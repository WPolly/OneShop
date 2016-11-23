package com.tcl.lishanwang.oneshop.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tcl.lishanwang.oneshop.R;

/**
 * Created by lishan on 2016/11/23.
 * 11:35
 */

public class OfferPackageViewHolder extends RecyclerView.ViewHolder {

    public TextView mTvPriceItemOfferPackage;

    public OfferPackageViewHolder(View itemView) {
        super(itemView);
        mTvPriceItemOfferPackage = (TextView) itemView.findViewById(R.id.tv_price_item_offer_package);
    }
}
