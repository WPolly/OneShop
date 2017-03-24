package com.tcl.lishanwang.oneshop.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.activity.LoginActivity;
import com.tcl.lishanwang.oneshop.activity.VoiceMailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by lishan on 2016/11/4.
 * 16:54
 */

public class ServiceFragment extends Fragment {

    @BindView(R.id.civ_user_profile)
    CircleImageView mCivUserProfile;
    @BindView(R.id.ll_user_profile_container)
    LinearLayout mLlUserProfileContainer;
    @BindView(R.id.tv_all_orders)
    TextView mTvAllOrders;
    @BindView(R.id.ll_to_pay)
    LinearLayout mLlToPay;
    @BindView(R.id.imageView)
    ImageView mImageView;
    @BindView(R.id.ll_to_receive)
    LinearLayout mLlToReceive;
    @BindView(R.id.ll_to_comment)
    LinearLayout mLlToComment;
    @BindView(R.id.ll_returns)
    LinearLayout mLlReturns;
    @BindView(R.id.ll_favorite)
    LinearLayout mLlFavorite;
    @BindView(R.id.ll_coupons)
    LinearLayout mLlCoupons;
    @BindView(R.id.ll_others)
    LinearLayout mLlOthers;
    @BindView(R.id.ll_service_site)
    LinearLayout mLlServiceSite;
    @BindView(R.id.ll_usual_question)
    LinearLayout mLlUsualQuestion;
    @BindView(R.id.ll_contact_us)
    LinearLayout mLlContactUs;
    @BindView(R.id.ll_feedback)
    LinearLayout mLlFeedback;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_service, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @OnClick({R.id.civ_user_profile, R.id.ll_user_profile_container, R.id.tv_all_orders, R.id.ll_to_pay, R.id.imageView, R.id.ll_to_receive, R.id.ll_to_comment, R.id.ll_returns, R.id.ll_favorite, R.id.ll_coupons, R.id.ll_others, R.id.ll_service_site, R.id.ll_usual_question, R.id.ll_contact_us, R.id.ll_feedback})
    public void onClick(View view) {
        Intent intent  = new Intent();
        Class<? extends Activity> cls = null;
        switch (view.getId()) {
            case R.id.civ_user_profile:
                break;
            case R.id.ll_user_profile_container:
                cls = LoginActivity.class;
                break;
            case R.id.tv_all_orders:
                break;
            case R.id.ll_to_pay:
                cls = VoiceMailActivity.class;
                break;
            case R.id.imageView:
                break;
            case R.id.ll_to_receive:
                break;
            case R.id.ll_to_comment:
                break;
            case R.id.ll_returns:
                break;
            case R.id.ll_favorite:
                break;
            case R.id.ll_coupons:
                break;
            case R.id.ll_others:
                break;
            case R.id.ll_service_site:
                break;
            case R.id.ll_usual_question:
                break;
            case R.id.ll_contact_us:
                break;
            case R.id.ll_feedback:
                break;
        }
        if (cls != null) {
            intent.setClass(getActivity(), cls);
            startActivity(intent);
        }
    }
}
