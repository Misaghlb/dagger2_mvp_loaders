package com.android.app.misaghlb.dagger2_mvp_loaders.di;

import android.content.Context;
import android.support.v4.content.Loader;
import android.util.Log;

import com.android.app.misaghlb.dagger2_mvp_loaders.ui.base.BasePresenter;

public class PresenterLoader<T extends BasePresenter> extends Loader<T> {

    private T presenter;

    /**
     * Stores away the application context associated with context.
     * Since Loaders can be used across multiple activities it's dangerous to
     * store the context directly; always use {@link #getContext()} to retrieve
     * the Loader's Context, don't use the constructor argument directly.
     * The Context returned by {@link #getContext} is safe to use across
     * Activity instances.
     *
     * @param context used to retrieve the application context.
     */
    public PresenterLoader(Context context, T presenter) {
        super(context);
        this.presenter = presenter;
    }


    @Override
    protected void onStartLoading() {
        Log.i("loader", "onStartLoading-");

        // if we already own a presenter instance, simply deliver it.
        if (presenter != null) {
            deliverResult(presenter);
            return;
        }

        // Otherwise, force a load
//        forceLoad();
    }


    @Override
    public void deliverResult(T data) {
        super.deliverResult(data);
        Log.i("loader", "deliverResult-");
    }

    @Override
    protected void onStopLoading() {
        Log.i("loader", "onStopLoading-");
    }

    @Override
    protected void onReset() {
        Log.i("loader", "onReset-");
        if (presenter != null) {
            presenter.onDestroyed();
            presenter = null;
        }
    }
}
