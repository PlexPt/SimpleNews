package com.zzh.simplenews.data.remote;

import com.zzh.simplenews.beans.BeforeNews;
import com.zzh.simplenews.beans.Content;
import com.zzh.simplenews.beans.LatestNews;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by zzh on 16/5/30.
 */
public interface NetApi {

    @GET("api/4/news/latest")
    Observable<LatestNews> getLatest();

    @GET("api/4/news/latest")
    @Headers("force_cache:true")
    Observable<LatestNews> getCacheLatest();

    //http://news.at.zhihu.com/api/4/news/before/20160609
    @GET("api/4/news/before/{date}")
    Observable<BeforeNews> getBefore(@Path("date") String date);

    @GET("api/4/news/before/{date}")
    @Headers("force_cache:true")
    Observable<BeforeNews> getCacheBefore(@Path("date") String date);

    @GET("api/4/news/{id}")
    Observable<Content> getContent(@Path("id") String id);

    @GET("api/4/news/{id}")
    @Headers("force_cache:true")
    Observable<Content> getCacheContent(@Path("id") String id);


}
