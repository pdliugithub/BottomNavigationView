package com.example.pd_liu.bottomnavigationview;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;
    private List<Fragment> mFragments;
    private MenuItem mPreMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mViewPager = (ViewPager) findViewById(R.id.view_page);
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_view);

        mFragments = new ArrayList<>(3);
        mFragments.add(new BlankFragment());
        mFragments.add(new BlankFragment());
        mFragments.add(new BlankFragment());
        mFragments.add(new BlankFragment());

        mViewPager.setAdapter(new ViewPagerAdaper(getSupportFragmentManager()));

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottom_1:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.bottom_2:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.bottom_3:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.bottom_4:
                        mViewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }

        });

        mBottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                // This operate can be instead of refreshing this page data.
                Snackbar.make(mBottomNavigationView, "点击了："+item.getTitle() + "当前页面刷新中....", Snackbar.LENGTH_LONG).show();
            }
        });


        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(mPreMenuItem != null){
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

    class ViewPagerAdaper extends FragmentPagerAdapter{

        public ViewPagerAdaper(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }

}
