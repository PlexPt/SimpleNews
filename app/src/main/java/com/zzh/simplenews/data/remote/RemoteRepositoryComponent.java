package com.zzh.simplenews.data.remote;

import dagger.Component;

/**
 * Created by zzh on 16/6/9.
 */
@RemoteRepositoryScope
@Component(modules = RemoteRepositoryModule.class)
public interface RemoteRepositoryComponent {
    RemoteRepository provideRemoteRepository();
}
