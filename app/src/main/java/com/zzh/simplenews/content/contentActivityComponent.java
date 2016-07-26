package com.zzh.simplenews.content;

import com.zzh.simplenews.data.RepositoryComponent;
import com.zzh.simplenews.main.PerActivity;

import dagger.Component;

/**
 * Created by zzh on 16/7/12.
 */
@PerActivity
@Component(dependencies = RepositoryComponent.class, modules = {contentModule.class})
public interface contentActivityComponent {
    public void inject(contentActivity contentActivity);
}
