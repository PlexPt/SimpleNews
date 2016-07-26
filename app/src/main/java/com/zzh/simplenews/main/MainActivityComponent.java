package com.zzh.simplenews.main;

import com.zzh.simplenews.ReadNews.NewsFragment;
import com.zzh.simplenews.ReadPicture.PictureFragment;
import com.zzh.simplenews.data.RepositoryComponent;
import com.zzh.simplenews.readVideo.VideoFragment;

import dagger.Component;

/**
 * Created by zzh on 16/7/12.
 */

@PerActivity
@Component(dependencies = RepositoryComponent.class,modules = {MainActivityModule.class})
public interface MainActivityComponent {
    void inject(NewsFragment newsFragment);
    void inject(PictureFragment pictureFragment);
    void inject(VideoFragment videoFragment);
}
