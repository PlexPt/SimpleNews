package com.zzh.simplenews.data.remote;

import com.zzh.simplenews.beans.Video;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zzh on 16/7/22.
 */
public interface VideoApi{
    @GET("feed")
    Observable<Video> getFirstPageVideo(@Query("num") String num,@Query("udid") String udid,@Query("vc") String vc);

    @GET("feed")
    Observable<Video> getVideo(@Query("date") String date,@Query("num") String num);
}
