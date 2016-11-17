package com.tcl.lishanwang.oneshop.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.tcl.lishanwang.oneshop.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommodityListActivity extends AppCompatActivity {

    @BindView(R.id.rb_recommend)
    RadioButton mRbRecommend;
    @BindView(R.id.rb_new)
    RadioButton mRbNew;
    @BindView(R.id.rb_price_ranking)
    RadioButton mRbPriceRanking;
    @BindView(R.id.iv_price_ranking)
    ImageView mIvPriceRanking;
    @BindView(R.id.iv_filter)
    ImageView mIvFilter;
    @BindView(R.id.iv_show_style)
    ImageView mIvShowStyle;
    @BindView(R.id.ll_sort_filter_container)
    LinearLayout mLlsortFilterContainer;
    @BindView(R.id.rg_sort_filter)
    RadioGroup mRgSortFilter;
    private static final int PRICE_RANKING_NONE = 0;
    private static final int PRICE_RANKING_ASCEND = 1;
    private static final int PRICE_RANKING_DESCEND = 2;
    private int mCurrentPriceRanking;
    private boolean mIsCurrentShowStyleGrid;
    private PopupWindow mPopupWindow;
    private SharedPreferences mSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodity_list);
        ButterKnife.bind(this);
        mSharedPref = getPreferences(Context.MODE_PRIVATE); //https://developer.android.com/training/basics/data-storage/shared-preferences.html
        mIsCurrentShowStyleGrid = mSharedPref.getBoolean("is_show_grid", false);
        refreshShowStyle();
        mRgSortFilter.setOnCheckedChangeListener(mOnCheckedChangeListener);
    }

    @OnClick({R.id.rb_price_ranking, R.id.iv_filter, R.id.iv_show_style})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_price_ranking:
                if (mCurrentPriceRanking == PRICE_RANKING_ASCEND) {
                    mCurrentPriceRanking = PRICE_RANKING_DESCEND;
                    mIvPriceRanking.setImageResource(R.drawable.product_screen_nprice_low);
                } else {
                    mCurrentPriceRanking = PRICE_RANKING_ASCEND;
                    mIvPriceRanking.setImageResource(R.drawable.product_screen_nprice_tall);
                }
                break;
            case R.id.iv_filter:
                togglePopupWindow();
                break;
            case R.id.iv_show_style:
                mIsCurrentShowStyleGrid = !mIsCurrentShowStyleGrid;
                refreshShowStyle();
                break;
        }
    }

    private void togglePopupWindow() {
        if (mPopupWindow == null) {
            View contentView = View.inflate(this, R.layout.popup_filter, null);
            mPopupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        if (mPopupWindow.isShowing()) {
            mIvFilter.setImageResource(R.drawable.product_btn_screen_nor);
            mPopupWindow.dismiss();
        } else {
            mIvFilter.setImageResource(R.drawable.product_btn_screen_pre);
            mPopupWindow.showAsDropDown(mLlsortFilterContainer);
            dimBehind(mPopupWindow);
        }
    }

    private void refreshShowStyle() {
        mIvShowStyle.setImageResource(mIsCurrentShowStyleGrid ? R.drawable.product_btn_list_word : R.drawable.product_btn_list);
        mSharedPref.edit().putBoolean("is_show_grid", mIsCurrentShowStyleGrid).apply();
    }

    private void dimBehind(PopupWindow popupWindow) {
        View container;
        if (popupWindow.getBackground() == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                container = (View) popupWindow.getContentView().getParent();
            } else {
                container = popupWindow.getContentView();
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                container = (View) popupWindow.getContentView().getParent().getParent();
            } else {
                container = (View) popupWindow.getContentView().getParent();
            }
        }
        Context context = popupWindow.getContentView().getContext();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams p = (WindowManager.LayoutParams) container.getLayoutParams();
        p.flags |= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        p.dimAmount = 0.3f;
        wm.updateViewLayout(container, p);
    }

    @Override
    public void onBackPressed() {
        if (mPopupWindow != null && mPopupWindow.isShowing()) {
            mIvFilter.setImageResource(R.drawable.product_btn_screen_nor);
            mPopupWindow.dismiss();
        } else {
            super.onBackPressed();
        }
    }

    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            mCurrentPriceRanking = PRICE_RANKING_NONE;
            mIvPriceRanking.setImageResource(R.drawable.product_screen_nprice_uncheck);
            switch (checkedId) {
                case R.id.rb_recommend:
                    Toast.makeText(CommodityListActivity.this, "recommend", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rb_new:
                    Toast.makeText(CommodityListActivity.this, "new", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    ;
}
