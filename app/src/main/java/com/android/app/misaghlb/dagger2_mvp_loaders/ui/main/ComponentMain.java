package com.android.app.misaghlb.dagger2_mvp_loaders.ui.main;


import com.android.app.misaghlb.dagger2_mvp_loaders.di.scope.FragmentScope;

import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = ModuleMain.class)
public interface ComponentMain {
    void inject(ActivityMain activityMain);
}
