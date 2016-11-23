package com.tcl.lishanwang.oneshop.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.holder.OfferPackageViewHolder;

/**
 * Created by lishan on 2016/11/23.
 * 11:34
 */

public class OfferPackageAdapter extends RecyclerView.Adapter<OfferPackageViewHolder> {
    @Override
    public OfferPackageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_offer_package, parent, false);
        return new OfferPackageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OfferPackageViewHolder holder, int position) {
        String text = "Add $" + position + " to buy";
        int index = text.indexOf('t');
        Spannable span = new SpannableString(text);
        span.setSpan(new ForegroundColorSpan(Color.RED), 4, index, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.mTvPriceItemOfferPackage.setText(span);
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
