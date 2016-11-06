package com.tcl.lishanwang.oneshop;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.tcl.lishanwang.oneshop.adapter.MainContentViewPagerAdapter;
import com.tcl.lishanwang.oneshop.utils.UIUtils;

public class MainActivity extends AppCompatActivity {

    private RadioGroup mRgBottomNavigation;
    private ViewPager mVpMainContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRgBottomNavigation = (RadioGroup) findViewById(R.id.rg_bottom_tags);
        mVpMainContent = (ViewPager) findViewById(R.id.vp_content);
        resizeBottomIcons();
        mRgBottomNavigation.setOnCheckedChangeListener(mOnCheckedChangeListener);
        mVpMainContent.setAdapter(new MainContentViewPagerAdapter(getSupportFragmentManager()));
    }

    private void resizeBottomIcons() {
        int[] bottomIcons =
                {R.drawable.selector_general_ic_home, R.drawable.selector_general_ic_category, R.drawable.selector_general_ic_discovery, R.drawable.selector_general_ic_service};

        int childCount = mRgBottomNavigation.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RadioButton rb = (RadioButton) mRgBottomNavigation.getChildAt(i);
            if (i == 0) rb.setChecked(true);

            int bound = UIUtils.dip2Px(26);
            Drawable d = getResources().getDrawable(bottomIcons[i]);
            d.setBounds(0, 0, bound, bound);
            rb.setCompoundDrawables(null, d, null, null);
        }
    }

    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            switch (checkedId) {
                case R.id.rb_home:
                    mVpMainContent.setCurrentItem(0, false);
                    break;
                case R.id.rb_category:
                    mVpMainContent.setCurrentItem(1, false);
                    break;
                case R.id.rb_discover:
                    mVpMainContent.setCurrentItem(2, false);
                    break;
                case R.id.rb_service:
                    mVpMainContent.setCurrentItem(3, false);
                    break;
            }
        }
    };
}
