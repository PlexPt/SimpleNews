package com.zzh.simplenews.data;

import com.zzh.simplenews.beans.BeforeNews;
import com.zzh.simplenews.beans.Content;
import com.zzh.simplenews.beans.LatestNews;
import com.zzh.simplenews.beans.PictureInfo;
import com.zzh.simplenews.beans.Video;

import rx.Observable;

/**
 * Created by zzh on 16/5/31.
 */
public interface DataSource{

    Observable<LatestNews> getLatest();
    Observable<LatestNews> getCacheLatest();

    Observable<BeforeNews> getBefore(String date);
    Observable<BeforeNews> getCacheBefore(String date);


    Observable<Content> getContent(String id);
    Observable<Content> getCacheContent(String id);

    public Observable<PictureInfo> getPictureInfo(String page);
    public Observable<PictureInfo> getCachePictureInfo(String page);

    public Observable<Video> getVideo(String date,String num);

    public Observable<Video> getFirstPageVideo(String num,String udid,String vc);

}
