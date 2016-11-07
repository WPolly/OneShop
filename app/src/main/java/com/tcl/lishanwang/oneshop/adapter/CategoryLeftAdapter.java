package com.tcl.lishanwang.oneshop.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.bean.CategoryMenuItemBean;
import com.tcl.lishanwang.oneshop.holder.CategoryLeftViewHolder;

import java.util.List;

/**
 * Created by lishan on 2016/11/7.
 * 14:46
 */

public class CategoryLeftAdapter extends RecyclerView.Adapter<CategoryLeftViewHolder> {

    private List<CategoryMenuItemBean> mCategoryMenuItemBeen;

    public CategoryLeftAdapter(List<CategoryMenuItemBean> categoryMenuItemBeen) {
        mCategoryMenuItemBeen = categoryMenuItemBeen;
    }

    @Override
    public CategoryLeftViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_left, parent, false);
        return new CategoryLeftViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CategoryLeftViewHolder holder, int position) {
//        if (position == 0) {
//            boolean b = holder.mTvCategoryLeftItem.requestFocus();
//            System.out.println(b);
//        }
        if (mCategoryMenuItemBeen.get(position).isSelected) {
            boolean b = holder.mTvCategoryLeftItem.requestFocus();
            System.out.println(b);
        }

        holder.mTvCategoryLeftItem.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                System.out.println("hahhahah");
                for (CategoryMenuItemBean bean : mCategoryMenuItemBeen) {
                    bean.isSelected = false;
                }
                mCategoryMenuItemBeen.get(holder.getAdapterPosition()).isSelected = true;
            }
        });

        holder.mTvCategoryLeftItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (CategoryMenuItemBean bean : mCategoryMenuItemBeen) {
                    bean.isSelected = false;
                }
                System.out.println("hahhahah");
                mCategoryMenuItemBeen.get(holder.getAdapterPosition()).isSelected = true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCategoryMenuItemBeen.size();
    }
}
