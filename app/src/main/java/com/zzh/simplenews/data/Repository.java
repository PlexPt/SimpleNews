package com.zzh.simplenews.data;

import com.zzh.simplenews.beans.BeforeNews;
import com.zzh.simplenews.beans.Content;
import com.zzh.simplenews.beans.LatestNews;
import com.zzh.simplenews.beans.PictureInfo;
import com.zzh.simplenews.beans.Video;
import com.zzh.simplenews.data.remote.RemoteRepository;

import rx.Observable;

/**
 * 单例
 * Created by zzh on 16/5/31.
 */

public class Repository implements DataSource {

    private RemoteRepository mRemoteRepository;

    public Repository(RemoteRepository remoteRepository) {
        mRemoteRepository = remoteRepository;
    }


    @Override
    public Observable<LatestNews> getLatest() {
        return mRemoteRepository.getLatestNews();
    }

    @Override
    public Observable<LatestNews> getCacheLatest() {
        return mRemoteRepository.getCacheLatestNews();
    }

    @Override
    public Observable<BeforeNews> getBefore(String date) {
        return mRemoteRepository.getBefore(date);
    }

    @Override
    public Observable<BeforeNews> getCacheBefore(String date) {
        return mRemoteRepository.getCacheBefore(date);
    }

    @Override
    public Observable<Content> getContent(String id) {
        return mRemoteRepository.getContent(id);
    }

    @Override
    public Observable<Content> getCacheContent(String id) {
        return mRemoteRepository.getCacheContent(id);
    }

    @Override
    public Observable<PictureInfo> getPictureInfo(String page) {
        return mRemoteRepository.getPictureInfo(page);
    }

    @Override
    public Observable<PictureInfo> getCachePictureInfo(String page) {
        return mRemoteRepository.getPictureInfo(page);
    }

    @Override
    public Observable<Video> getVideo(String date,String num) {
        return mRemoteRepository.getVideo(date,num);
    }

    @Override
    public Observable<Video> getFirstPageVideo(String num, String udid, String vc) {
        return mRemoteRepository.getFirstPageVideo(num,udid,vc);
    }


}
