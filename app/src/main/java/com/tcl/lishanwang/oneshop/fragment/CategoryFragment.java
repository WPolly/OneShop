package com.tcl.lishanwang.oneshop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.adapter.CategoryRightAdapter;

/**
 * Created by lishan on 2016/11/8.
 * 10:52
 */

public class CategoryFragment extends Fragment {

    private RadioGroup mRgCategoryLeft;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);
        RecyclerView rvCategoryRight = (RecyclerView) rootView.findViewById(R.id.rv_category_right);
        rvCategoryRight.setAdapter(new CategoryRightAdapter());
        mRgCategoryLeft = (RadioGroup) rootView.findViewById(R.id.rg_category_left);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int checkedId = R.id.rb0;
        if (savedInstanceState != null) checkedId = savedInstanceState.getInt("checked_id", R.id.rb0);
        mRgCategoryLeft.check(checkedId);
        mRgCategoryLeft.setOnCheckedChangeListener(mOnCheckedChangeListener);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("checked_id", mRgCategoryLeft.getCheckedRadioButtonId());
    }

    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            switch (checkedId) {
                case R.id.rb0:
                    Toast.makeText(getContext(), ((RadioButton) radioGroup.getChildAt(0)).getText(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rb1:
                    Toast.makeText(getContext(), ((RadioButton) radioGroup.getChildAt(1)).getText(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rb2:
                    Toast.makeText(getContext(), ((RadioButton) radioGroup.getChildAt(2)).getText(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rb3:
                    Toast.makeText(getContext(), ((RadioButton) radioGroup.getChildAt(3)).getText(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rb4:
                    break;
                case R.id.rb5:
                    break;
            }
        }
    };;
}
