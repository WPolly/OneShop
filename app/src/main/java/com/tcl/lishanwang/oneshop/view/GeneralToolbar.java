package com.tcl.lishanwang.oneshop.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tcl.lishanwang.oneshop.R;

/**
 * Created by lishan on 2016/11/14.
 * 10:38
 */

public class GeneralToolbar extends FrameLayout implements View.OnClickListener {

    public GeneralToolbar(Context context) {
        this(context, null, 0);
    }

    public GeneralToolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GeneralToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context, attrs);
    }

    private void initLayout(Context context, AttributeSet attrs) {
        inflate(context, R.layout.toolbar_general, this);
        findViewById(R.id.iv_toolbar_back).setOnClickListener(this);
        TextView tvMiddle = (TextView) findViewById(R.id.tv_toolbar_middle);
        TextView tvRight = (TextView) findViewById(R.id.tv_sign_in);
        View cart = findViewById(R.id.iv_toolbar_cart);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GeneralToolbar);
        boolean isRightImgShow = typedArray.getBoolean(R.styleable.GeneralToolbar_isRightImgShow, false);
        String tvTitle = typedArray.getString(R.styleable.GeneralToolbar_title);
        cart.setOnClickListener(this);
        cart.setVisibility(isRightImgShow ? VISIBLE : GONE);
        tvRight.setVisibility(isRightImgShow ? GONE : VISIBLE);
        tvMiddle.setText(tvTitle);
        typedArray.recycle();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_toolbar_back:
                ((Activity) getContext()).onBackPressed();
                break;
            case R.id.iv_toolbar_cart:
                Toast.makeText(getContext(), "shopping cart", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
