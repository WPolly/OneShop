package com.tcl.lishanwang.oneshop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.tcl.lishanwang.oneshop.R;

/**
 * Created by lishan on 2016/11/25.
 * 10:06
 */

public class StarRatingBar extends View {

    private int mStarSize;
    private int mStarCount;
    private int mStarPadding;
    private Drawable mStarEmptyDrawable;
    private Drawable mStarFullDrawable;
    private Paint mStarPaint;
    private float mRating;

    public StarRatingBar(Context context) {
        this(context, null);
    }

    public StarRatingBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.StarRatingBar);
        mStarSize = (int) typedArray.getDimension(R.styleable.StarRatingBar_starSize, 20);
        mStarCount = typedArray.getInt(R.styleable.StarRatingBar_starCount, 0);
        mStarPadding = (int) typedArray.getDimension(R.styleable.StarRatingBar_starPadding, 0);
        mStarEmptyDrawable = typedArray.getDrawable(R.styleable.StarRatingBar_starEmptyDrawable);
        mStarFullDrawable = typedArray.getDrawable(R.styleable.StarRatingBar_starFullDrawable);
        mRating = typedArray.getFloat(R.styleable.StarRatingBar_rating, 5);
        typedArray.recycle();

        mStarPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        if (mStarFullDrawable != null) {
            mStarFullDrawable.setBounds(0, 0, mStarSize, mStarSize);
            Bitmap shaderBitmap = Bitmap.createBitmap(mStarSize, mStarSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(shaderBitmap);
            mStarFullDrawable.draw(canvas);
            mStarPaint.setShader(new BitmapShader(shaderBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(mStarSize * mStarCount + mStarPadding * (mStarCount - 1), mStarSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mStarEmptyDrawable == null || mStarFullDrawable == null) return;
        for (int i = 0; i < mStarCount; i++) {
            mStarEmptyDrawable.setBounds((mStarSize + mStarPadding) * i, 0, mStarSize + (mStarSize + mStarPadding) * i, mStarSize);
            mStarEmptyDrawable.draw(canvas);
        }

        if (mRating > mStarCount) {
            throw new IllegalArgumentException("the rating should not be larger than total star count.");
        }

        float lastStar = mRating - (int) mRating;
        for (int i = 0; i < (int) mRating + 1; i++) {
            if (i == (int) mRating) {
                canvas.drawRect(0, 0, mStarSize * lastStar, mStarSize, mStarPaint);
                break;
            }
            canvas.drawRect(0, 0, mStarSize, mStarSize, mStarPaint);
            canvas.translate(mStarSize + mStarPadding, 0);
        }
    }
}
