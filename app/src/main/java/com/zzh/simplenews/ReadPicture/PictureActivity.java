package com.zzh.simplenews.ReadPicture;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.DecelerateInterpolator;

import com.zzh.simplenews.R;
import com.zzh.simplenews.util.RxSavePicture;
import com.zzh.simplenews.util.Shares;
import com.zzh.simplenews.util.Toasts;

import java.io.File;

import javax.inject.Inject;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;


/**
 * Created by zzh on 16/4/25.
 */
public class PictureActivity extends SwipeBackActivity {

    private ViewPager mViewPager;
    private PagerViewShowPictureAdapter mPagerAdapter;
    private static int sPosition = 0;
    //private View mDecorView;
    private Toolbar mToolbar;

    private AppBarLayout mAppBarLayout;
    @Inject
    PicturePresenter mPicturePresenter;

    protected boolean mIsHidden = false;


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_picture);
        mViewPager = (ViewPager) findViewById(R.id.viewpager_activity_picture_show_activity);
        mPagerAdapter = new PagerViewShowPictureAdapter(this);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(sPosition);
        mToolbar = (Toolbar) findViewById(R.id.picture_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        mAppBarLayout.setAlpha(0.7f);

    }

    public static void startPictureActivity(int postion, Context context) {
        sPosition = postion;
        context.startActivity(new Intent(context, PictureActivity.class));
    }
//
//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        mDecorView = getWindow().getDecorView();
//        if (hasFocus) {
//            mDecorView.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//        }
//    }

    @Override
    protected void onPause() {
        super.onPause();
        mPagerAdapter.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_picture, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String url = PicturesAdapter.sUrls.get(mViewPager.getCurrentItem());
        String title = String.valueOf(url.hashCode());
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_share:

                RxSavePicture.savePicture(this, url, title)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<Uri>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                Toasts.showLong(e.getMessage() + "\n再试试...");
                            }

                            @Override
                            public void onNext(Uri uri) {
                                Shares.shareImage(PictureActivity.this,uri,getString(R.string.share_meizhi_to));
                            }
                        });
                break;
            case R.id.action_save:

                RxSavePicture.savePicture(this, url, title)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<Uri>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                Toasts.showLong(e.getMessage() + "\n再试试...");
                            }

                            @Override
                            public void onNext(Uri uri) {
                                File appDir = new File(Environment.getExternalStorageDirectory(), "SimpleNews");
                                String msg = String.format(getString(R.string.picture_has_save_to),
                                        appDir.getAbsolutePath());
                                Toasts.showShort(msg);
                            }
                        });
                break;
        }
        return true;
    }

    public void hideOrShowToolbar() {
        mAppBarLayout.animate()
                .translationY(mIsHidden ? 0 : -mToolbar.getHeight())
                .setInterpolator(new DecelerateInterpolator(2))
                .start();
        mIsHidden = !mIsHidden;
    }

}

