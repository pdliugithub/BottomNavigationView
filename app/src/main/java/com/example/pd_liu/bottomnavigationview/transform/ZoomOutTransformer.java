package com.example.pd_liu.bottomnavigationview.transform;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by pd_liu on 2017/7/11.
 */

public class ZoomOutTransformer implements ViewPager.PageTransformer {
    private static final String TAG = "ZoomOutTransformer";
    @Override
    public void transformPage(View page, float position) {
        Log.e(TAG, "page:" + page.getId() + "----position:" + position);
    }
}
