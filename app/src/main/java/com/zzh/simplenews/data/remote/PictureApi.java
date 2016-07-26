package com.zzh.simplenews.data.remote;

import com.zzh.simplenews.beans.PictureInfo;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by zzh on 16/7/13.
 */
public interface PictureApi {

    @GET("api/data/福利/20/{page}")
    Observable<PictureInfo> getPictrueInfo(@Path("page") String page);

    @GET("api/data/福利/20/{page}")
    @Headers("force_cache:true")
    Observable<PictureInfo> getCachePictrueInfo(@Path("page") String page);
}
