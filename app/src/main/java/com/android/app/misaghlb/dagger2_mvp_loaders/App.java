package com.android.app.misaghlb.dagger2_mvp_loaders;

import android.app.Application;
import android.content.Context;

import com.android.app.misaghlb.dagger2_mvp_loaders.di.Appcomponent;
import com.android.app.misaghlb.dagger2_mvp_loaders.di.DaggerAppcomponent;
import com.android.app.misaghlb.dagger2_mvp_loaders.di.modules.AppModule;

import timber.log.Timber;


public class App extends Application {

    private Appcomponent appcomponent;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public Appcomponent getAppcomponent() {
        return appcomponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initTimber();
        initDI();
    }

    private void initDI() {
        appcomponent = DaggerAppcomponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    /*
    * log just in debug mode
    */
    private void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}