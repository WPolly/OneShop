package com.tcl.lishanwang.oneshop.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.holder.DiscoveryViewHolder;

/**
 * Created by xiaoshan on 2016/11/6.
 * 19:13
 */

public class DiscoveryAdapter extends RecyclerView.Adapter<DiscoveryViewHolder> {

    private int[] imgIds =
            {R.mipmap.discovery_hot_topic, R.mipmap.discovery_hot_activity, R.mipmap.discovery_sweepstakes, R.mipmap.discovery_physical_store};

    @Override
    public DiscoveryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discovery, parent, false);
        return new DiscoveryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final DiscoveryViewHolder holder, int position) {
        holder.ivItemDiscovery.setImageResource(imgIds[position]);
        holder.ivItemDiscovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "img:" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return imgIds.length;
    }
}
