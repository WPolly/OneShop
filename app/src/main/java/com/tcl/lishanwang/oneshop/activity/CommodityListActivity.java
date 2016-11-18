package com.tcl.lishanwang.oneshop.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.adapter.CommodityAdapter;
import com.tcl.lishanwang.oneshop.utils.UIUtils;

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
    @BindView(R.id.rl_sort_filter_container)
    RelativeLayout mRlsortFilterContainer;
    @BindView(R.id.rg_sort_filter)
    RadioGroup mRgSortFilter;
    @BindView(R.id.ll_filter_drop_menu)
    LinearLayout mLlFilterDropMenu;
    @BindView(R.id.v_shadow_behind)
    View mVShadowBehind;
    @BindView(R.id.rv_commodity)
    RecyclerView mRvCommodity;

    private static final int PRICE_RANKING_NONE = 0;
    private static final int PRICE_RANKING_ASCEND = 1;
    private static final int PRICE_RANKING_DESCEND = 2;
    private int mCurrentPriceRanking;
    private boolean mIsCurrentShowStyleGrid;
    private boolean mIsDropMenuOpen;
    private SharedPreferences mSharedPref;
    private ValueAnimator mDropMenuAnimator;
    private int mOriginIvFilterHeight;
    private int mOriginDropMenuHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodity_list);
        ButterKnife.bind(this);
        mSharedPref = getPreferences(Context.MODE_PRIVATE); //https://developer.android.com/training/basics/data-storage/shared-preferences.html
        mIsCurrentShowStyleGrid = mSharedPref.getBoolean("is_show_grid", false);
        refreshShowStyle();
        mRgSortFilter.check(R.id.rb_recommend);
        mRgSortFilter.setOnCheckedChangeListener(mOnCheckedChangeListener);
        mRvCommodity.setLayoutManager(new LinearLayoutManager(this));
        mRvCommodity.setAdapter(new CommodityAdapter());
    }

    @OnClick({R.id.rb_price_ranking, R.id.iv_filter, R.id.iv_show_style})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_price_ranking:
                changePriceRankingOrder();
                break;
            case R.id.iv_filter:
                int tempHeight = mLlFilterDropMenu.getMeasuredHeight();
                if (tempHeight != 0) mOriginDropMenuHeight = tempHeight;
                initDropMenuAnimator();
                toggleDropMenu();
                break;
            case R.id.iv_show_style:
                mIsCurrentShowStyleGrid = !mIsCurrentShowStyleGrid;
                refreshShowStyle();
                break;
        }
    }

    private void toggleDropMenu() {
        if (mIsDropMenuOpen) {
            closeDropMenu();
        } else {
            openDropMenu();
        }
        mIsDropMenuOpen = !mIsDropMenuOpen;
    }

    private void openDropMenu() {
        mRvCommodity.setLayoutFrozen(true);
        ViewGroup.LayoutParams ivFilterLp = mIvFilter.getLayoutParams();
        mOriginIvFilterHeight = ivFilterLp.height;
        ivFilterLp.height = mOriginIvFilterHeight + UIUtils.dip2Px(1);
        mIvFilter.setImageResource(R.drawable.product_btn_screen_pre);
        mDropMenuAnimator.removeListener(mAnimatorListenerAdapter);
        mDropMenuAnimator.start();
    }

    private void closeDropMenu() {
        mRvCommodity.setLayoutFrozen(false);
        mIvFilter.setImageResource(R.drawable.product_btn_screen_nor);
        mDropMenuAnimator.addListener(mAnimatorListenerAdapter);
        mDropMenuAnimator.reverse();
    }

    private void initDropMenuAnimator() {
        mDropMenuAnimator = ValueAnimator.ofInt(0, mOriginDropMenuHeight);
        mDropMenuAnimator.setDuration(200);
        mDropMenuAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        mDropMenuAnimator.addUpdateListener(mAnimatorUpdateListener);
        mDropMenuAnimator.addListener(mAnimatorListenerAdapter);
    }

    private void changePriceRankingOrder() {
        if (mCurrentPriceRanking == PRICE_RANKING_ASCEND) {
            mCurrentPriceRanking = PRICE_RANKING_DESCEND;
            mIvPriceRanking.setImageResource(R.drawable.product_screen_nprice_low);
        } else {
            mCurrentPriceRanking = PRICE_RANKING_ASCEND;
            mIvPriceRanking.setImageResource(R.drawable.product_screen_nprice_tall);
        }
    }

    private void refreshShowStyle() {
        mIvShowStyle.setImageResource(mIsCurrentShowStyleGrid ? R.drawable.product_btn_list_word : R.drawable.product_btn_list);
        mSharedPref.edit().putBoolean("is_show_grid", mIsCurrentShowStyleGrid).apply();
    }

    @Override
    public void onBackPressed() {
        if (mIsDropMenuOpen) {
            closeDropMenu();
            mIsDropMenuOpen = false;
        } else {
            super.onBackPressed();
        }
    }

    //region:  listeners
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

    private AnimatorListenerAdapter mAnimatorListenerAdapter = new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
            ViewGroup.LayoutParams ivFilterLp = mIvFilter.getLayoutParams();
            ivFilterLp.height = mOriginIvFilterHeight;
        }
    };

    private ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            mLlFilterDropMenu.setVisibility(View.VISIBLE);
            int animatedValue = (int) valueAnimator.getAnimatedValue();
            ViewGroup.LayoutParams llFilterDropMenuLp = mLlFilterDropMenu.getLayoutParams();
            llFilterDropMenuLp.height = animatedValue;
            mLlFilterDropMenu.requestLayout();

            float fraction = animatedValue / 500f;
            int startColor = Color.parseColor("#00000000");
            int endColor = Color.parseColor("#66000000");
            ArgbEvaluator argbEvaluator = new ArgbEvaluator();
            int evaluateColor = (int) argbEvaluator.evaluate(fraction, startColor, endColor);
            mVShadowBehind.setBackgroundColor(evaluateColor);
        }
    };
}
