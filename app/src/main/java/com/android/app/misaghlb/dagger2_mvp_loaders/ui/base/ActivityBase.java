package com.android.app.misaghlb.dagger2_mvp_loaders.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public abstract class ActivityBase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent();
    }

    protected abstract void setupActivityComponent();
}