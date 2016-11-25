package com.android.app.misaghlb.dagger2_mvp_loaders.ui.main;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleMain {
    private final ContractMain.View mView;

    public ModuleMain(ContractMain.View view) {
        mView = view;
    }

    @Provides
    ContractMain.View provideMainContractView() {
        return mView;
    }
}
