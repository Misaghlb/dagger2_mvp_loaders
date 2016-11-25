package com.android.app.misaghlb.dagger2_mvp_loaders.di.modules;

import com.android.app.misaghlb.dagger2_mvp_loaders.ui.main.ContractMain;

import dagger.Module;
import dagger.Provides;

@Module
public class MainPresenterModule {
    private final ContractMain.View mView;


    public MainPresenterModule(ContractMain.View mView) {
        this.mView = mView;
    }

    @Provides
    ContractMain.View provideMainContractView() {
        return mView;
    }
}
