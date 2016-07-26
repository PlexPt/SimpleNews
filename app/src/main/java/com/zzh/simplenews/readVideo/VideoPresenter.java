package com.zzh.simplenews.readVideo;

import com.zzh.simplenews.beans.Video;
import com.zzh.simplenews.data.Repository;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zzh on 16/7/22.
 */
public class VideoPresenter {

    private Repository mRepository;
    private VideoFragment mVideoFragment;

    public void setVideoFragment(VideoFragment videoFragment) {
        mVideoFragment = videoFragment;
    }

    public VideoPresenter(Repository repository){
        this.mRepository = repository;
    }

    public void getVideos(String date,String num){
        mRepository.getVideo(date,num)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<Video>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Video video) {
                if (mVideoFragment == null){
                    throw  new RuntimeException("you have to set the mVideoFragment before use VideoPresenter");
                }
               mVideoFragment.afterGetVideo(video,false);
            }
        });
    }

    public void getFirstPageVideo(String num,String udid,String vc){
        mRepository.getFirstPageVideo(num,udid,vc)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Video>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Video video) {
                        if (mVideoFragment == null){
                            throw  new RuntimeException("you have to set the mVideoFragment before use VideoPresenter");
                        }
                        mVideoFragment.afterGetVideo(video,true);
                    }
                });
    }
}
