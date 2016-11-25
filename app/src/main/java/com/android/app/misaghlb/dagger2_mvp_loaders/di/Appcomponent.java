package com.android.app.misaghlb.dagger2_mvp_loaders.di;

import com.android.app.misaghlb.dagger2_mvp_loaders.di.modules.AppModule;
import com.android.app.misaghlb.dagger2_mvp_loaders.ui.main.ComponentMain;
import com.android.app.misaghlb.dagger2_mvp_loaders.ui.main.ModuleMain;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AppModule.class,
        }
)
public interface Appcomponent {
    ComponentMain plus(ModuleMain moduleMain);
}
