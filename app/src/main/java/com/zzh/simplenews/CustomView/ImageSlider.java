package com.zzh.simplenews.CustomView;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zzh.simplenews.R;
import com.zzh.simplenews.util.DimentsUtil;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zzh on 16/6/1.
 */
public class ImageSlider extends FrameLayout {

    public static final String TAG = ImageSlider.class.getSimpleName();

    private Context mContext;

    private int preDotPosition;

    //private List<Latest.TopStoriesBean> mTopStories= new ArrayList<>();

    private List<String> bannerTextDesc = new ArrayList<>();

    private List<String> imageUrls = new ArrayList<>();

    private boolean isStopped = false;

    private int scrollTimeOffset = 5000;

    private ViewPager mViewPager;

    private TextView tvBannerTextDesc;

    private LinearLayout llDotGroup;

    private BannerAdapter mBannerAdapter;

    private ImageSliderOnClickListener mImageSliderOnClickListener;

    private Subscription mSubscription;


    public void setImageSliderOnClickListener(ImageSliderOnClickListener imageSliderOnClickListener) {
        mImageSliderOnClickListener = imageSliderOnClickListener;
    }

    public ImageSlider(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.image_slider, this);
        initView();
    }

    public void RefreshView(List<String> descs,List<String> urls){

        bannerTextDesc = descs;
        imageUrls = urls;
        setDotsView();

        mBannerAdapter.notifyDataSetChanged();
        // 选中第一个图片、文字描述
        tvBannerTextDesc.setText(bannerTextDesc.get(0));
        llDotGroup.getChildAt(0).setEnabled(true);
        mViewPager.setCurrentItem(0);
    }

    public void onDestroy() {
        isStopped = true;
        mContext = null;

    }

    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                isStopped = true;
                return false;
            }
        });

        llDotGroup = (LinearLayout) findViewById(R.id.ll_dot_group);
        tvBannerTextDesc = (TextView) findViewById(R.id.tv_banner_text_desc);
        mBannerAdapter = new BannerAdapter(((AppCompatActivity)mContext).getSupportFragmentManager());
        mViewPager.setAdapter(mBannerAdapter);
        mViewPager.addOnPageChangeListener(new BannerPageChangeListener());
        startBannerScrollThread();
    }

    private void setDotsView() {
        llDotGroup.removeAllViews();
        View dot;
        LayoutParams params;
        for (String url:imageUrls) {
            //Log.d(TAG,"图片Id: " + url );
            // 每循环一次添加一个点到线行布局中
            dot = new View(mContext);
            dot.setBackgroundResource(R.drawable.dot_bg_selector);
            params = new LayoutParams(DimentsUtil.dp2px(6f), DimentsUtil.dp2px(6f));
            params.leftMargin = DimentsUtil.dp2px(10f);
            dot.setEnabled(false);
            dot.setLayoutParams(params);
            llDotGroup.addView(dot); // 向线性布局中添加"点"
        }
    }

    private void startBannerScrollThread() {
        mSubscription = Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                while (!isStopped) {
                    SystemClock.sleep(scrollTimeOffset);
                    subscriber.onNext(null);
                }
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Object o) {
                        if (imageUrls.size() > 0){
                            int newindex = (mViewPager.getCurrentItem() + 1) % imageUrls.size();
                            mViewPager.setCurrentItem(newindex);
                        }
                    }
                });
    }


    private class BannerAdapter extends FragmentStatePagerAdapter {

        public BannerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(final int position) {

            final ImageFragment imageFragment = new ImageFragment();
            Bundle bundle = new Bundle();
            bundle.putString("url",imageUrls.get(position));
            imageFragment.setArguments(bundle);
            imageFragment.setImageFragmentClickListener(new ImageFragment.ImageFragmentClickListener() {
                @Override
                public void onClick() {
                    if (mImageSliderOnClickListener != null){
                        mImageSliderOnClickListener.OnClick(position);
                    }

                }
            });
            return imageFragment;
    }

        @Override
        public int getCount() {
            return imageUrls.size();
        }
    }


    private class BannerPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // Nothing to do
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // Nothing to do
        }

        @Override
        public void onPageSelected(int position) {
            // 取余后的索引，得到新的page的索引
            int newPositon = position % imageUrls.size();
            // 根据索引设置图片的描述
            tvBannerTextDesc.setText(bannerTextDesc.get(position));
            // 把上一个点设置为被选中
            llDotGroup.getChildAt(preDotPosition).setEnabled(false);
            // 根据索引设置那个点被选中
            llDotGroup.getChildAt(newPositon).setEnabled(true);
            // 新索引赋值给上一个索引的位置
            preDotPosition = newPositon;
        }

    }

    public interface ImageSliderOnClickListener{
        void OnClick(int position);
    }

    public void Destroy(){
        mSubscription.unsubscribe();
    }

}


