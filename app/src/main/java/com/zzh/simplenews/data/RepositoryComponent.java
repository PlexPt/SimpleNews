package com.zzh.simplenews.data;

import com.zzh.simplenews.data.remote.RemoteRepositoryComponent;

import dagger.Component;

/**
 * Created by zzh on 16/6/8.
 */
@RepositoryScope
@Component(dependencies = RemoteRepositoryComponent.class , modules = RepositoryModule.class)
public interface RepositoryComponent {
    Repository provideRepository();
}
