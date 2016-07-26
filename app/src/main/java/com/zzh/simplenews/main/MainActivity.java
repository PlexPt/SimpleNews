package com.zzh.simplenews.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.zzh.simplenews.CustomView.TabEntity;
import com.zzh.simplenews.R;
import com.zzh.simplenews.ReadNews.NewsFragment;
import com.zzh.simplenews.ReadPicture.PictureFragment;
import com.zzh.simplenews.readVideo.VideoFragment;
import com.zzh.simplenews.SimpleNewsApplication;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private String[] mTitles = {"读报", "读图", "读视频"};
    private int[] mIconUnselectIds = {
            R.drawable.tab_readpaper_black, R.drawable.tab_picture_black,
            R.drawable.tab_video_black};
    private int[] mIconSelectIds = {
            R.drawable.tab_readpaper_blue, R.drawable.tab_picture_blue,
            R.drawable.tab_video_blue};

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private ViewPager mViewPager;

    private CommonTabLayout mCommonTabLayout;

    private Toolbar mToolbar;

    private DaggerMainActivityComponent mDaggerMainActivityComponent;

    private NewsFragment mNewsFragment;

    private PictureFragment mPictureFragment;

    private VideoFragment mVideoFragment;


    public DaggerMainActivityComponent getDaggerMainActivityComponent() {
        return mDaggerMainActivityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_main);
            mDaggerMainActivityComponent =
                (DaggerMainActivityComponent) DaggerMainActivityComponent.builder()
                        .repositoryComponent(((SimpleNewsApplication) (SimpleNewsApplication.getContext())).getRepositoryComponent())
                        .build();


        mNewsFragment = new NewsFragment();
        mPictureFragment = new PictureFragment();
        mVideoFragment = new VideoFragment();

        ViewInit();
        super.onCreate(savedInstanceState);

    }

    private void ViewInit() {
        mViewPager = (ViewPager) findViewById(R.id.main_viewPager);
        mCommonTabLayout = (CommonTabLayout) findViewById(R.id.main_tabLayout);

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mCommonTabLayout.setTabData(mTabEntities);
        mToolbar = (Toolbar) findViewById(R.id.main_toolBar);
        mToolbar.setTitle("首页");
        mCommonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCommonTabLayout.setCurrentTab(position);
                if (position == 0){
                    mToolbar.setTitle("读报");
                }else if (position == 1){
                    mToolbar.setTitle("读图");
                }else {
                    mToolbar.setTitle("读视频");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0){
                    return mNewsFragment;
                }
                if (position == 1){
                    return mPictureFragment;
                }
                if (position == 2){
                    return mVideoFragment;
                }

                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
    }

    public void setToolBarTitle(String title) {
        mToolbar.setTitle(title);
    }
}
