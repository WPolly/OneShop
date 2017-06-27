package com.tcl.lishanwang.oneshop.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.tcl.lishanwang.oneshop.R;
import com.tcl.lishanwang.oneshop.view.OnTranslucentScrollListener;
import com.tcl.lishanwang.oneshop.view.TranslucentSupportScrollView;

public class TranslucentToolbarActivity extends AppCompatActivity implements OnTranslucentScrollListener {

    private FrameLayout mTbTranslucent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translucent_toolbar);
        mTbTranslucent = (FrameLayout) findViewById(R.id.gt);
        mTbTranslucent.getChildAt(0).setBackgroundColor(Color.TRANSPARENT);  //inflate的toolbar此时是FrameLayout的子视图。
        TranslucentSupportScrollView tssTest = (TranslucentSupportScrollView) findViewById(R.id.tss);
        tssTest.setListener(this);
    }

    @Override
    public void onScroll(float alpha) {
        mTbTranslucent.setBackgroundColor(Color.argb((int) (alpha*255), 32, 48, 67));
    }
}
