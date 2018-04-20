package com.example.nikolettatoth.recepies_andoid;

import android.app.Application;

import com.example.nikolettatoth.recepies_andoid.database.Repository;
import com.example.nikolettatoth.recepies_andoid.ui.UIModule;

import javax.inject.Inject;

public class RecepiesApplication extends Application {
    @Inject
    Repository repository;

    public static RecepiesApplicationComponent injector;

    public void setInjector(RecepiesApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
        repository.open(getApplicationContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerRecepiesApplicationComponent.builder().uIModule(new UIModule(this)).build();
    }
}
