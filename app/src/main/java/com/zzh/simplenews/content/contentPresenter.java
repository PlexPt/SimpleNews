package com.zzh.simplenews.content;

import com.zzh.simplenews.beans.Content;
import com.zzh.simplenews.data.Repository;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by zzh on 16/7/12.
 */
public class contentPresenter {

    private Repository mRepository;
    private CompositeSubscription mCompositeSubscription;
    private contentActivity mContentActivity;

    public void setContentActivity(contentActivity contentActivity) {
        mContentActivity = contentActivity;
    }

    public contentPresenter(Repository repository) {
        mRepository = repository;
        mCompositeSubscription = new CompositeSubscription();
    }

    public void getContent(final String id) {
        mContentActivity.BeforeRefresh();
        Subscription subscription = mRepository.getCacheContent(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Content>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Subscription errorSub = mRepository.getContent(id).
                                subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Observer<Content>() {
                                    @Override
                                    public void onCompleted() {

                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        e.printStackTrace();
                                        mContentActivity.AfterRefresh();
                                    }

                                    @Override
                                    public void onNext(Content content) {
                                        mContentActivity.AfterRefresh(content);
                                    }
                                });

                       mCompositeSubscription.add(errorSub);
                    }

                    @Override
                    public void onNext(Content content) {
                        mContentActivity.AfterRefresh(content);
                    }
                });

        mCompositeSubscription.add(subscription);
    }

    public void onDestroy() {
        mCompositeSubscription.clear();
    }
}
