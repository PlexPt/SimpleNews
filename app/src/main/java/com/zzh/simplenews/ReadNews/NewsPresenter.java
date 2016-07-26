package com.zzh.simplenews.ReadNews;

import com.zzh.simplenews.beans.BeforeNews;
import com.zzh.simplenews.beans.LatestNews;
import com.zzh.simplenews.data.DataSource;
import com.zzh.simplenews.data.Repository;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by zzh on 16/6/7.
 */
public class NewsPresenter {

    public static final String TAG = NewsPresenter.class.getSimpleName();


    private final DataSource mDataSource;


    private NewsFragment mNewsFragment;

    private CompositeSubscription mCompositeSubscription;

    public void setView(NewsFragment newsFragment ) {
        mNewsFragment = newsFragment;
    }

    public NewsPresenter(Repository dataSource) {
        mDataSource = dataSource;
        mCompositeSubscription = new CompositeSubscription();
    }


    public void refreshData() {
        mNewsFragment.BeforeRefresh();
        Subscription subscription = mDataSource.getLatest()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LatestNews>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        //从缓存里面读
                        Subscription cachesubscrip = mDataSource.getCacheLatest()
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Subscriber<LatestNews>() {
                                    @Override
                                    public void onCompleted() {

                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        //Log.d("TAG", "没有读到缓存");
                                        mNewsFragment.AfterRefresh();
                                    }

                                    @Override
                                    public void onNext(LatestNews latest) {
                                        mNewsFragment.AfterRefresh(latest);
                                    }
                                });
                        mCompositeSubscription.add(cachesubscrip);
                    }

                    @Override
                    public void onNext(LatestNews latest) {
                        mNewsFragment.AfterRefresh(latest);
                    }
                });

        mCompositeSubscription.add(subscription);
    }

    public void LoadMoreDate(final String date){
        mNewsFragment.BeforeRefresh();
        final Subscription subscription = mDataSource.getCacheBefore(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BeforeNews>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //读网络
                        Subscription subscribe = mDataSource.getBefore(date)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Subscriber<BeforeNews>() {

                                    @Override
                                    public void onCompleted() {

                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        mNewsFragment.AfterRefresh();
                                    }

                                    @Override
                                    public void onNext(BeforeNews dayStories) {
                                       mNewsFragment.AfterRefresh(dayStories);
                                    }
                                });
                        mCompositeSubscription.add(subscribe);
                    }

                    @Override
                    public void onNext(BeforeNews dayStories){
                        mNewsFragment.AfterRefresh(dayStories);
                    }
                });
        mCompositeSubscription.add(subscription);
    }


    public void onDestroy() {
        mCompositeSubscription.clear();
    }

}
