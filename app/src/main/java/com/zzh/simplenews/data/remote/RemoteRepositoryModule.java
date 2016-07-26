package com.zzh.simplenews.data.remote;

import android.util.Log;

import com.zzh.simplenews.SimpleNewsApplication;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zzh on 16/6/9.
 */

@Module
public class RemoteRepositoryModule {
    public static final String TAG = "RemoteRepositoryModule";
    private Map<String, String> EtagMap = new HashMap<>();

    @RemoteRepositoryScope
    @Provides
    RemoteRepository provideRemoteRepository(NetApi netApi, PictureApi pictureApi, VideoApi videoApi) {
        return new RemoteRepository(netApi,pictureApi,videoApi);
    }

    @RemoteRepositoryScope
    @Provides
    OkHttpClient provideOkHttpClient() {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(new File(SimpleNewsApplication.getContext().getCacheDir(), "http"), cacheSize);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //.addNetworkInterceptor(new LoggingInterceptor())
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Response response = null;
                        String url = request.url().toString();
                        if (EtagMap.get(url) != null) {
                            request.newBuilder()
                                    .header("If-None-Match", EtagMap.get(url));
                        }
                        response = chain.proceed(request);
                        EtagMap.put(url, response.header("ETag"));

                        //根据服务器的数据还可以添加修改时间 max-age 来管理缓存
                        return response;
                    }
                })
                .addInterceptor(new LoggingInterceptor())
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();

                        if (request.header("force_cache") != null && request.header("force_cache").equals("true")) {
                            //Log.d(TAG, "强制读缓存");
                            Request newRequest = request.newBuilder()
                                    .removeHeader("force_cache")
                                    .cacheControl(CacheControl.FORCE_CACHE)
                                    .build();
                            return chain.proceed(newRequest);
                        }

                        Response response = chain.proceed(request);
                        //response.cacheResponse();
                        return response;
                    }
                })
                .cache(cache)
                .build();
        return okHttpClient;
    }


    @RemoteRepositoryScope
    @Provides
    Retrofit.Builder provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        return retrofitBuilder;
    }

    @RemoteRepositoryScope
    @Provides
    NetApi provideNetApi(Retrofit.Builder retrofitBuilder) {
        retrofitBuilder.baseUrl("http://news-at.zhihu.com/");
        //retrofit("http://news-at.zhihu.com");
        return retrofitBuilder.build().create(NetApi.class);
    }

    @RemoteRepositoryScope
    @Provides
    PictureApi providePictureApi(Retrofit.Builder retrofitBuilder){
        retrofitBuilder.baseUrl("http://gank.io/");
        return retrofitBuilder.build().create(PictureApi.class);
    }

    @RemoteRepositoryScope
    @Provides
    VideoApi provideVideoApi(Retrofit.Builder retrofitBuilder){
        retrofitBuilder.baseUrl("http://baobab.wandoujia.com/api/v2/");
        return retrofitBuilder.build().create(VideoApi.class);
    }


    static class LoggingInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            long t1 = System.nanoTime();
            Log.i(TAG, String.format("Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers()));

            Response response = chain.proceed(request);

            long t2 = System.nanoTime();
            Log.i(TAG, String.format("Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));

            return response;
        }
    }


}
