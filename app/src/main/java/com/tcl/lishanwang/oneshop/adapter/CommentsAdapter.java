package com.tcl.lishanwang.oneshop.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.holder.CommentItemViewHolder;

/**
 * Created by lishan on 2016/11/25.
 * 17:34
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentItemViewHolder> {
    @Override
    public CommentItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new CommentItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
