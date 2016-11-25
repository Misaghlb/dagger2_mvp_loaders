package com.android.app.misaghlb.dagger2_mvp_loaders.ui.main;

import android.os.Handler;

import com.android.app.misaghlb.dagger2_mvp_loaders.ui.base.BaseView;

import javax.inject.Inject;

import timber.log.Timber;

public class PresenterMain implements ContractMain.Presenter {

    private ContractMain.View mMainView;

    @Inject
    PresenterMain(ContractMain.View mMainView) {
        this.mMainView = mMainView;
    }


    @Inject
    void setListeners() {
        mMainView.setPresenter(this);
    }

    @Override
    public void start() {
        Timber.i("START");
    }

    @Override
    public void onViewAttached(BaseView view) {
        Timber.d(mMainView+"");
        mMainView = (ContractMain.View) view;
    }

    @Override
    public void onViewDetached() {
        mMainView = null;
    }

    @Override
    public void onDestroyed() {

    }

    @Override
    public void sayHi() {
        mMainView.changeColor();
    }

    @Override
    public void longOpt() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Timber.i("Done");
                mMainView.changeColor();
            }
        }, 4000);
    }
}
