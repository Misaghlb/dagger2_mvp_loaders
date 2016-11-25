package com.android.app.misaghlb.dagger2_mvp_loaders.ui.main;

import com.android.app.misaghlb.dagger2_mvp_loaders.ui.base.BasePresenter;
import com.android.app.misaghlb.dagger2_mvp_loaders.ui.base.BaseView;

public interface ContractMain {

    interface Presenter extends BasePresenter {
        void sayHi();

        void longOpt();
    }

    interface View extends BaseView<Presenter> {
        void changeColor();
    }
}
