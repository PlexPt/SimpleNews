package com.zzh.simplenews.data;

import com.zzh.simplenews.data.remote.RemoteRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zzh on 16/6/8.
 */
@Module
public class RepositoryModule {
    @RepositoryScope
    @Provides
    Repository provideRepository(RemoteRepository remoteRepository){
        return new Repository(remoteRepository);
    }
}
