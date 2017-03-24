package com.tcl.lishanwang.oneshop.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.adapter.VoiceMailViewPagerAdapter;

public class VoiceMailActivity extends AppCompatActivity {

    private ViewPager mVpVoiceMail;
    private CheckedTextView mCtvTagForAll;
    private CheckedTextView mCtvTagForKid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_mail);
        mVpVoiceMail = (ViewPager)findViewById(R.id.vp_voice_mail);
        mCtvTagForAll = (CheckedTextView) findViewById(R.id.ctv_message_tag_all);
        mCtvTagForKid = (CheckedTextView) findViewById(R.id.ctv_message_tag_kid);

        mVpVoiceMail.setAdapter(new VoiceMailViewPagerAdapter(getSupportFragmentManager()));
        mVpVoiceMail.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                mCtvTagForAll.setChecked(position == 0);
                mCtvTagForKid.setChecked(position == 1);
            }
        });

        mCtvTagForAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVpVoiceMail.setCurrentItem(0);
            }
        });

        mCtvTagForKid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVpVoiceMail.setCurrentItem(1);
            }
        });
    }
}
