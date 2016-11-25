package com.android.app.misaghlb.dagger2_mvp_loaders.ui.base;

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
