package com.zzh.simplenews.data.remote;

import com.zzh.simplenews.beans.BeforeNews;
import com.zzh.simplenews.beans.Content;
import com.zzh.simplenews.beans.LatestNews;
import com.zzh.simplenews.beans.PictureInfo;
import com.zzh.simplenews.beans.Video;

import rx.Observable;

/**
 * Created by zzh on 16/5/31.
 */

public class RemoteRepository {
    private NetApi mNetApi;
    private PictureApi mPictureApi;
    private VideoApi mVideoApi;

    public RemoteRepository(NetApi netApi,PictureApi pictureApi,VideoApi videoApi) {
        mNetApi = netApi;
        mPictureApi = pictureApi;
        mVideoApi = videoApi;
    }

    public Observable<LatestNews> getLatestNews() {
        return mNetApi.getLatest();
    }

    public Observable<LatestNews> getCacheLatestNews() {
        return mNetApi.getCacheLatest();
    }

    public Observable<BeforeNews> getBefore(String date){
        return  mNetApi.getBefore(date);
    }

    public Observable<BeforeNews> getCacheBefore(String date){
        return  mNetApi.getCacheBefore(date);
    }

    public Observable<Content> getContent(String id) {
        return mNetApi.getContent(id);
    }

    public Observable<Content> getCacheContent(String id){return mNetApi.getCacheContent(id);}

    public Observable<PictureInfo> getPictureInfo(String page){return mPictureApi.getPictrueInfo(page);}
    public Observable<PictureInfo> getCachePictureInfo(String page){return mPictureApi.getCachePictrueInfo(page);}

    public Observable<Video> getVideo(String date,String num){
        return mVideoApi.getVideo(date,num);
    }
    public Observable<Video> getFirstPageVideo(String num,String udid,String vc){
        return mVideoApi.getFirstPageVideo(num,udid,vc);
    }
}
