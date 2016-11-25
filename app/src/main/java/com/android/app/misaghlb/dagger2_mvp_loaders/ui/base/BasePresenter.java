package com.android.app.misaghlb.dagger2_mvp_loaders.ui.base;

public interface BasePresenter {
    void start();

    void onViewAttached(BaseView view);

    void onViewDetached();

    void onDestroyed();
}
