package com.example.nikolettatoth.recepies_andoid.ui;

import android.content.Context;

import com.example.nikolettatoth.recepies_andoid.ui.detail.DetailPresenter;
import com.example.nikolettatoth.recepies_andoid.ui.main.MainPresenter;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public DetailPresenter provideDetailPresenter() {
        return new DetailPresenter();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}
