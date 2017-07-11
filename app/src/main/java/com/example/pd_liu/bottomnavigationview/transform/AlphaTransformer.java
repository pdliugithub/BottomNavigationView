package com.example.pd_liu.bottomnavigationview.transform;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

/**
 * Created by pd_liu on 2017/7/11.
 */

public class AlphaTransformer implements ViewPager.PageTransformer {
    private TextView mTextView;
    private static final String TAG = "ZoomOutTransformer";

    @Override
    public void transformPage(View page, float position) {

        if (mTextView != null) {
            mTextView.setText("page:" + page.getId() + "----position:" + position);
        }

        if (position < -1) {//超出屏幕
            page.setAlpha(1.0f);
        } else if (position <= 0) {//当前的左边的控件[-1,0]越往左滑，position值越小
            float value = 1 - Math.abs(position);
            page.setAlpha(value);
        } else if (position <= 1) {//当前的右边控件[0,1]越往左滑，position值越小
            float value = 1 - Math.abs(position);
            page.setAlpha(value);
        } else {
            page.setAlpha(1.0f);
        }
    }

    public void setTextView(TextView textView) {
        this.mTextView = textView;
    }
}
