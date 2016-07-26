package com.zzh.simplenews.content;

import com.zzh.simplenews.data.Repository;
import com.zzh.simplenews.main.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zzh on 16/7/12.
 */
@Module
public class contentModule {
    @PerActivity
    @Provides
    public contentPresenter provideContentPresenter(Repository repository){
        return new contentPresenter(repository);
    }
}
