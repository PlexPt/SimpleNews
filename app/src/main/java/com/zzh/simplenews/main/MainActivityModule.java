package com.zzh.simplenews.main;

import com.zzh.simplenews.ReadNews.NewsPresenter;
import com.zzh.simplenews.ReadPicture.PicturePresenter;
import com.zzh.simplenews.data.Repository;
import com.zzh.simplenews.readVideo.VideoPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zzh on 16/7/12.
 */
@Module
public class MainActivityModule {


    @PerActivity
    @Provides
    NewsPresenter provideNewsPresenter(Repository repository){
        return new NewsPresenter(repository);
    }
    @PerActivity
    @Provides
    PicturePresenter providePicturePresenter(Repository repository){
        return new PicturePresenter(repository);
    }
    @PerActivity
    @Provides
    VideoPresenter provideVideoPresenter(Repository repository){
        return new VideoPresenter(repository);
    }

}
