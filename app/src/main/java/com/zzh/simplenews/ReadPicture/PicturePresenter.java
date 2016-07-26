package com.zzh.simplenews.ReadPicture;

import android.content.Context;
import android.net.Uri;

import com.zzh.simplenews.beans.PictureInfo;
import com.zzh.simplenews.data.Repository;
import com.zzh.simplenews.util.RxSavePicture;

import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by zzh on 16/7/13.
 */
public class PicturePresenter {
    private Repository mRepository;
    private PictureFragment mPictureFragment;

    private CompositeSubscription mSubscriptions;

    public void setPictureFragment(PictureFragment pictureFragment) {
        mPictureFragment = pictureFragment;
    }

    public PicturePresenter(Repository repository){
        mRepository = repository;
        mSubscriptions = new CompositeSubscription();
    }

    public void getDate(final String page){
        mPictureFragment.beforeGetData();
        Subscription subscription = mRepository.getPictureInfo(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PictureInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Subscription errorSub = mRepository.getCachePictureInfo(page)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Observer<PictureInfo>() {

                                    @Override
                                    public void onCompleted() {

                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        mPictureFragment.afterGetData();
                                    }

                                    @Override
                                    public void onNext(PictureInfo pictureInfo) {
                                        if (page == "1"){
                                            mPictureFragment.afterGetData(pictureInfo,true);
                                        }else{
                                            mPictureFragment.afterGetData(pictureInfo,false);
                                        }

                                    }
                                });
                        mSubscriptions.add(errorSub);
                    }

                    @Override
                    public void onNext(PictureInfo pictureInfo) {
                        if (page == "1"){
                            mPictureFragment.afterGetData(pictureInfo,true);
                        }else{
                            mPictureFragment.afterGetData(pictureInfo,false);
                        }
                    }
                });

        mSubscriptions.add(subscription);
    }

    public void saveImageToGallery(Context context,String uri,String title){
        Subscription s = RxSavePicture.savePicture(context,uri,title)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Uri>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Uri uri) {

                    }
                });
    }


    public void refresh(){
        getDate("1");
    }

    public void loadMore(String page){
        getDate(page);
    }

    public void onDestroy(){
        mSubscriptions.clear();
    }



}
