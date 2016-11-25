package com.android.app.misaghlb.dagger2_mvp_loaders.ui.main;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.android.app.misaghlb.dagger2_mvp_loaders.App;
import com.android.app.misaghlb.dagger2_mvp_loaders.R;
import com.android.app.misaghlb.dagger2_mvp_loaders.di.PresenterLoader;
import com.android.app.misaghlb.dagger2_mvp_loaders.ui.activity.base.ActivityBase;
import com.android.app.misaghlb.dagger2_mvp_loaders.utils.ActivityUtil;

import javax.inject.Inject;

import timber.log.Timber;

public class ActivityMain extends ActivityBase implements LoaderManager.LoaderCallbacks<PresenterMain> {

    @Inject
    PresenterMain mPresenter;

    FragmentMain fragmentMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void setupActivityComponent() {
        fragmentMain = (FragmentMain) getSupportFragmentManager()
                .findFragmentById(R.id.container);
        if (fragmentMain == null) {
            fragmentMain = FragmentMain.newInstance();
            ActivityUtil.addFragmentToActivity(getSupportFragmentManager(),
                    fragmentMain, R.id.container);
        }

        App.get(this).getAppcomponent().plus(new ModuleMain(fragmentMain)).inject(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Timber.i("onStop a");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Timber.i("onDestroy a");
    }

    @Override
    public Loader<PresenterMain> onCreateLoader(int id, Bundle args) {
        return new PresenterLoader<>(ActivityMain.this, this.mPresenter);
    }

    @Override
    public void onLoadFinished(Loader<PresenterMain> loader, PresenterMain data) {
        this.mPresenter = data;
        Timber.i(String.valueOf(data));
    }

    @Override
    public void onLoaderReset(Loader<PresenterMain> loader) {

    }
}