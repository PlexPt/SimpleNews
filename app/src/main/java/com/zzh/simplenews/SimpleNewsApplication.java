package com.zzh.simplenews;

import android.app.Application;
import android.content.Context;

import com.zzh.simplenews.data.DaggerRepositoryComponent;
import com.zzh.simplenews.data.RepositoryComponent;
import com.zzh.simplenews.data.remote.DaggerRemoteRepositoryComponent;
import com.zzh.simplenews.data.remote.RemoteRepositoryComponent;
import com.zzh.simplenews.util.Toasts;


/**
 * Created by zzh on 16/5/31.
 */
public class SimpleNewsApplication extends Application {
    private static Context sContext;
    private RepositoryComponent mRepositoryComponent;
    private RemoteRepositoryComponent mRemoteRepositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        Toasts.register(this);
        mRemoteRepositoryComponent = DaggerRemoteRepositoryComponent.builder().build();
        mRepositoryComponent = DaggerRepositoryComponent.builder()
                .remoteRepositoryComponent(mRemoteRepositoryComponent)
                .build();
    }

    public RepositoryComponent getRepositoryComponent() {

        return mRepositoryComponent;
    }

    public static Context getContext() {
        return sContext;
    }
}
