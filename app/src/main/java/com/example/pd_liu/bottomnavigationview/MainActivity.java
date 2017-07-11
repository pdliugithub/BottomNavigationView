package com.example.pd_liu.bottomnavigationview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.pd_liu.bottomnavigationview.adapter.ViewPagerAdapter;
import com.example.pd_liu.bottomnavigationview.fragment.BlankFragment;
import com.example.pd_liu.bottomnavigationview.transform.AlphaTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pd_liu
 *         This Sample show some base functions only.
 *         You can {@link # https://material.io/guidelines/components/bottom-navigation.html#bottom-navigation-behavior}to learn more.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * view pager
     */
    private ViewPager mViewPager;
    /**
     * bottom navigation view
     */
    private BottomNavigationView mBottomNavigationView;
    /**
     * fragment containers
     */
    private List<Fragment> mFragments;
    /**
     * menu item
     */
    private MenuItem mPreMenuItem;

    private TextView mDescribeLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mViewPager = (ViewPager) findViewById(R.id.view_page);

        mDescribeLog = (TextView) findViewById(R.id.describe_log);
        AlphaTransformer zoomOutTransformer = new AlphaTransformer();
        zoomOutTransformer.setTextView(mDescribeLog);
        mViewPager.setPageTransformer(true, zoomOutTransformer);
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_view);

        mFragments = new ArrayList<>(3);
        mFragments.add(new BlankFragment());
        mFragments.add(new BlankFragment());
        mFragments.add(new BlankFragment());

        mViewPager.setOffscreenPageLimit(mFragments.size() -1);

        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), mFragments));

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_1:
                        mViewPager.setCurrentItem(0);
                        ((BlankFragment) mFragments.get(0)).setContentTxt(item.getTitle().toString());
                        break;
                    case R.id.bottom_2:
                        mViewPager.setCurrentItem(1);
                        ((BlankFragment) mFragments.get(1)).setContentTxt(item.getTitle().toString());
                        break;
                    case R.id.bottom_3:
                        mViewPager.setCurrentItem(2);
                        ((BlankFragment) mFragments.get(2)).setContentTxt(item.getTitle().toString());
                        break;
                }
                return true;
            }

        });

        mBottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                // This operate can be instead of refreshing this page data.
                Snackbar.make(mBottomNavigationView, "点击了：" + item.getTitle() + "当前页面刷新中....", Snackbar.LENGTH_LONG).show();
            }
        });


        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (mPreMenuItem != null) {
                    mPreMenuItem.setChecked(false);
                }
                mBottomNavigationView.getMenu().getItem(position).setChecked(true);
                mPreMenuItem = mBottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * start new activity.
     *
     * @param view click view
     */
    public void start(View view) {
        startActivity(new Intent(this, SampleTwoActivity.class));
    }

}
