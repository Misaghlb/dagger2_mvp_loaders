package com.android.app.misaghlb.dagger2_mvp_loaders.ui.main;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.app.misaghlb.dagger2_mvp_loaders.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMain extends Fragment implements ContractMain.View {
    private ContractMain.Presenter mPresenter;
    private View view;
    private boolean firstRun = true;
    private boolean tg = false;

    public static FragmentMain newInstance() {
        return new FragmentMain();
    }

    private static final String BGCOLOR_KEY = "BGCOLOR";
    private int BGCOLOR;

    @OnClick(R.id.btn1)
    public void onbtn1Clicked() {
        mPresenter.longOpt();
    }

    @Override
    public void setPresenter(@NonNull ContractMain.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_blank, container, false);
        setRetainInstance(true);
        ButterKnife.bind(this, view);
        return view;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore some state that needs to happen after the Activity was created
            // restore ListViews here because their scroll position will
            // be restored properly
            if (savedInstanceState.getInt(BGCOLOR_KEY) != 0) {
                view.setBackgroundColor(BGCOLOR);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onViewAttached(this);
        if (firstRun) {
            mPresenter.start();
            firstRun = false;
        }
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore some state that needs to happen after our own views have had
            // their state restored
            // DON'T try to restore ListViews here because their scroll position will
            // not be restored properly
            BGCOLOR = savedInstanceState.getInt(BGCOLOR_KEY);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BGCOLOR_KEY, BGCOLOR);
    }

    @Override
    public void changeColor() {
        BGCOLOR = tg ? Color.RED : Color.BLACK;
        view.setBackgroundColor(BGCOLOR);
        tg = !tg;
    }

    @Override
    public void onStop() {
//        mPresenter.onViewDetached();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
